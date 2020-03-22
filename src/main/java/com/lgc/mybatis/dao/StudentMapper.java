package com.lgc.mybatis.dao;

import com.lgc.mybatis.entity.Student;

/**
 * @author lgc
 **/
public interface StudentMapper {
    Student getStudentById(String id);
    Student getStudentUser(String id);
}
