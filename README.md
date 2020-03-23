# mybatis
start mybatis
1.mybatis 处理参数
ParamNameResolver解析参数转换为map(SortedMap) 内部封装反射
useActualParamName jdk1.8 name=参数

#{}占位符
${} 直接取出来
原生不支持占位符 可以使用 ${}
select * from ${year}_tableName order by ${month}

#{} javaType jdbcType mode(存储过程) numericScale(小数)
    resultMap  typeHandler jdbcTypeName expression(未来支持)

ognl
      <foreach>insert into tb_user (name) values separator ； 执行多次sql 连接属性 需要 allowMultiQueries=true
      </foreach>
按需加载有问题
内置参数 _parameter 单个参数/map
        _databaseId