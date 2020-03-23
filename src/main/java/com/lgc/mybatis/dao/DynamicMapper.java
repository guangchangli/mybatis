package com.lgc.mybatis.dao;

import com.lgc.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lgc
 **/
public interface DynamicMapper {

    List<User> IfMapper(User user);

    List<User> TrimMapper(User user);

    int TrimUpdateMapper(User user);
    int setUpdateMapper(User user);

    List<User> ChooseMapper(User user);

    List<User> foreachMapper(List<String> ids);

    int foreachInsertMapper(@Param("list") List<User> list);

    List<User> bindParam(@Param("name") String name);

}
