package com.lgc.mybatis.dao;

import com.lgc.mybatis.entity.Person;

/**
 * @author lgc
 * @create 2019-12-16 11:18 下午
 **/
public interface PersonMapper {
    Person selectPersonById(String id);
}
