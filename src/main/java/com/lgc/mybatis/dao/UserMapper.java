package com.lgc.mybatis.dao;

import com.lgc.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lgc
 * @create 2019-12-16 5:04 下午
 **/
public interface UserMapper {

    /**
     * 登录（直接使用注解指定传入参数名称）
     */
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     */
    List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     */
    User queryUserById(Long id);

    /**
     * 查询所有用户信息
     */
    List<User> queryUserAll();

    /**
     * 新增用户信息
     */
    void insertUser(User user);

    /**
     * 根据id更新用户信息
     */
    void updateUser(User user);

    /**
     * 根据id删除用户信息
     */
    void deleteUserById(Long id);

    /**
     * test myTypeHandler
     */
    User selectUserById(String id);
}
