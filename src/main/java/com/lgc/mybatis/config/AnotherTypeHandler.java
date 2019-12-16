package com.lgc.mybatis.config;

import com.lgc.mybatis.entity.User;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lgc
 * @create 2019-12-16 10:27 下午
 **/
public class AnotherTypeHandler implements TypeHandler<User> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, User user, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public User getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public User getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public User getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
