package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.PasswordNotMatchException;
import com.cy.store.service.ex.UserNotFoundException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service //当前类对象交给Spring来管理，可以自动创建对象和对象的维护
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getUsername();
        User reault=userMapper.findByUsername(username);
        //判断结果集是否为null，为null说明没有被占用
        if(reault!=null){
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //密码加密处理
        //串+password+串 md5算法进行加密 串就是盐值（本身是随机的字符串
        String oldPassword = user.getPassword();
        //获取一个盐值
        String salt = UUID.randomUUID().toString().toUpperCase();//全大写的盐值
        //将密码和盐值作为一个整体进行加密处理
        String md5password = getMD5Password(oldPassword,salt);
        user.setPassword(md5password);
        user.setSalt(salt);//盐值也要记录！！
        //进行业务逻辑
        user.setIsDelete(0);
        Date date = new Date();
        user.setCreatedUser(username);
        user.setModifiedUser(username);
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if(rows!=1) {
            throw new InsertException("在用户注册国中当中产生了未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        //用户是否存在
        User result = userMapper.findByUsername(username);
        if (result == null){
            throw new UserNotFoundException("用户数据不存在");
        }
        //检测用户密码是否匹配 先获取盐值加密后比较
        String salt = result.getSalt();
        String newMd5Pwd = getMD5Password(password,salt);
        String oldMd5Pwd = result.getPassword();
        if(!newMd5Pwd.equals(oldMd5Pwd)){
            throw new PasswordNotMatchException("密码输入错误");
        }
        //判断是否删除
        if(result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }

        //因为是辅助其他页面做展示用的，所以不需要全部的数据，著需要uid 名字 头像等信息
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return result;
    }

    //定义一个md5算法的加密处理
    private String getMD5Password(String password, String salt){
        //md5加密算法的调用 (三次）
        for (int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();

        }
        //返回加密后的密码
        return password;
    }
}
