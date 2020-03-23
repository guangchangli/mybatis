package com.lgc.mybatis.dao;

import com.lgc.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 根据id查询用户信息
     */
    User queryUserById(String id);

    /**
     * 查询所有用户信息
     */
    List<User> queryUserAll();

    /**
     * 新增用户
     */
    void insertUser(User user);

    /**
     * 更新用户信息
     */
    void updateUser(User user);

    /**
     * 根据id删除用户信息
     */
    void deleteUser(String id);

    /**
     * 返回map colume value
     */
    Map<String,Object> selectUserMap(String id);

    /**
     * 指定key
     */
    @MapKey("id")
    Map<String,User> selectMapUser(String id);

    /**
     * result
     */
    User selectUserByResultMap(String id);

    /**
     * association
     */
    User selectUserByResultMapAss(String id);

    /**
     * 分步查询
     *  在mybatis中，resultMap可以实现高级映射(使用association、collection实现一对一及一对多映射)，association、collection具备延迟加载功能。
     */
    User selectUserByStep(String id);

}
