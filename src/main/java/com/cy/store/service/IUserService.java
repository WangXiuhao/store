package com.cy.store.service;

import com.cy.store.entity.User;

public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

}
