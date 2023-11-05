package com.cy.store.mapper;

import com.cy.store.entity.User;

//用户模块的持久层接口
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数（增删改，受影响的行数都作为返回值）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户则返回这个用户的数据，如果没有找到则返回null
     */
    User findByUsername(String username);
}
