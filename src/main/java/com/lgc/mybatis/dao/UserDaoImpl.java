package com.lgc.mybatis.dao;


import com.lgc.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(String id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("UserDao.updateUser", user);
    }

    @Override
    public void deleteUser(String id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }

    @Override
    public Map<String, Object> selectUserMap(String id) {
        return this.sqlSession.selectOne("UserDao.selectUserMap",id);
    }

    @Override
    public Map<String, User> selectMapUser(String id) {
        return this.sqlSession.selectOne("UserDao.selectMapUser",id);
    }

    @Override
    public User selectUserByResultMap(String id) {
        return this.sqlSession.selectOne("UserDao.selectUserByResultMap",id);
    }

    @Override
    public User selectUserByResultMapAss(String id) {
        return this.sqlSession.selectOne("UserDao.selectUserByResultMapAss",id);
    }

    @Override
    public User selectUserByStep(String id) {
        return this.sqlSession.selectOne("UserDao.selectUserByStep",id);
    }

}
