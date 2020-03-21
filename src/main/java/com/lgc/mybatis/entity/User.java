package com.lgc.mybatis.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author lgc
 * @create 2019-12-15 11:20 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    @JSONField(ordinal = 4)
    private String id;
    @JSONField(ordinal = 4)
    private String userName;
    //不序列化
    @JSONField(ordinal = 4,serialize = false)
    private String password;
    //本来是json 直接输出
    @JSONField(ordinal = 1,jsonDirect = true)
    private String name;
    //指定 序列化类
    @JSONField(ordinal = 4, serializeUsing = MySerializer.class)
    private Integer age;
    @JSONField(ordinal = 4)
    private Integer sex;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", ordinal = 3)
    private Date birthday;
    @JSONField(format = "yyyy-MM-dd", ordinal = 1)
    private String created;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", ordinal = 2)
    private String updated;

    public static class MySerializer implements ObjectSerializer {
        @Override
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                          int features) {
            Integer value = (Integer) object;
            String text = value + "岁";
            serializer.write(text);
        }
    }
}
