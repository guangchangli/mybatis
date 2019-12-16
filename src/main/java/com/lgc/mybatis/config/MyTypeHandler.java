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
 *     1.预编译设置参数
 *     2.结果集翻译
 * @author lgc
 * @create 2019-12-16 6:08 下午
 **/
@MappedTypes(Integer.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class MyTypeHandler extends BaseTypeHandler<String>{

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

    public String getGender(String genderCode) {
        if ("1".equals(genderCode)) {
            return "男";
        } else if ("2".equals(genderCode)) {
            return "女";
        } else {
            return null;
        }
    }
}