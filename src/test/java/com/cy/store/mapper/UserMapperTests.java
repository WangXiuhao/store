package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

//@SpringBootTest 表示标注当前的类是一个测试类，特点是不会随同项目一起打包发送
@SpringBootTest
//@RunWith表示的是启动单元测试类，需要传递固定的参数
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试方法：可以独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 特点：
     * 1.返回值类型必须是void
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("Leo");
        user.setPassword("5277");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);

    }
    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("Leo");
        System.out.println(user);
    }
}
