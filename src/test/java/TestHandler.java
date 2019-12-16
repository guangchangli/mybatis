import com.lgc.mybatis.dao.PersonMapper;
import com.lgc.mybatis.dao.UserMapper;
import com.lgc.mybatis.entity.Person;
import com.lgc.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author lgc
 * @create 2019-12-16 10:46 下午
 **/
public class TestHandler {
    private UserMapper userMapper;
    private PersonMapper personMapper;

    @Before
    public void setUp() throws Exception {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testMyHandler(){
        User user = userMapper.selectUserById("1");
        System.out.println(user);
    }
    @Test
    public void testMyHandler1(){
        Person person = personMapper.selectPersonById("1");
        System.out.println(person);
    }
}
