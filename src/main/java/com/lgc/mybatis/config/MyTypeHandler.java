package com.lgc.mybatis.config;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型处理器
 * 作用
 * 1.预编译设置参数
 * 2.结果集翻译
 * 插入一个对象数据的时候，对象的每条属性是在经过如何处理后放入JDBC的SQL语句中，
 * 在取出一条数据库记录的时候，每一列的数据又是经过如何的处理放入对象的属性中的
 *
 * @author lgc
 * @create 2019-12-16 6:08 下午
 **/
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.CHAR)
public class MyTypeHandler extends BaseTypeHandler<String> {


    public String getSex(char sex) {
        if ("1".equals(String.valueOf(sex))) {
            return "男";
        } else if ("2".equals(String.valueOf(sex))) {
            return "女";
        } else {
            return null;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}