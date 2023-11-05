package com.cy.store.service;

import com.cy.store.entity.User;

public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配的用户数据，没有的话返回null
     */
    User login(String username, String password);

}
