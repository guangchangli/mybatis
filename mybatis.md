# mybatis

1. ### mybatis初始化

   - 加载 mybatis-config.xml，加载映射配置文件，加载Mapper 接口注解信息 保存在Configuration 对象中，利用 Configuration 创建 sqlSessionFactory 对象

     1. BaseBuilder 基本抽象构造类

        ```java
        protected final Configuration configuration;
        protected final TypeAliasRegistry typeAliasRegistry;  注册 alias 信息
        protected final TypeHandlerRegistry typeHandlerRegistry; 注册 typeHandler 
        ```

        里面封装了解析 resultTypeSet，TypeHandler，JdbcType，CreateInstance

     2. 子类 XMLConfiurationBuilder

        ``解析 xml 的 configuration 节点``

        ```java
          public Configuration parse() {
            if (parsed) {
              throw new BuilderException("Each XMLConfigBuilder can only be used once.");
            }
            parsed = true;
            parseConfiguration(parser.evalNode("/configuration"));
            return configuration;
          }
        ```

        ``加载顺序``

        ```java
        private void parseConfiguration(XNode root) {
            try {
              //issue #117 read properties first
              propertiesElement(root.evalNode("properties"));
              Properties settings = settingsAsProperties(root.evalNode("settings"));
              loadCustomVfs(settings);
              loadCustomLogImpl(settings);
              typeAliasesElement(root.evalNode("typeAliases"));
              pluginElement(root.evalNode("plugins"));
              objectFactoryElement(root.evalNode("objectFactory"));
              objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
              reflectorFactoryElement(root.evalNode("reflectorFactory"));
              settingsElement(settings);
              // read it after objectFactory and objectWrapperFactory issue #631
              environmentsElement(root.evalNode("environments"));
              databaseIdProviderElement(root.evalNode("databaseIdProvider"));
              typeHandlerElement(root.evalNode("typeHandlers"));
              mapperElement(root.evalNode("mappers"));
            } catch (Exception e) {
              throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
            }
          }
        ```

   - 加载 mapper 映射文件 XMLMapperBuilder

     ```
     <mapper nameSpace="">
     	<parameterMap>   ParameterMap
     		<parameter/>   ParameterMapping
     	</parameterMap>
     	
     	<ResultMap>      ResultMap
     		<id/>  
     		<Result/>      ResultMapping
     	</ResultMap>
     	
     	<select>         MappedStatement
     	  select * from user where id = #{id}  BoundSql
     	</select>
     </mapper/
     ```

     ```java
     public void parse() {
         //  判断当前 Mapper 是否已经加载过
         if (!configuration.isResourceLoaded(resource)) {
             // 解析 `<mapper />` 节点
             configurationElement(parser.evalNode("/mapper"));
             // 标记该 Mapper 已经加载过 configuration 对象 HashSet 维护
             configuration.addLoadedResource(resource);
             // 绑定 Mapper
             bindMapperForNamespace();
         }
     
         //  解析待定的 <resultMap /> 节点
         parsePendingResultMaps();
         //  解析待定的 <cache-ref /> 节点
         parsePendingCacheRefs();
         //  解析待定的 SQL 语句的节点
         parsePendingStatements();
     }
     ```

     ``cache-ref 节点 nameSpace cache 另一个 nameSpace cacheRefMap 维护``

   - 加载 Statement XMLStatementBuilder 解析 select | insert |update |delete

     ```
     
     ```

     