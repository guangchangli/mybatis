import com.lgc.mybatis.dao.DynamicMapper;
import com.lgc.mybatis.dao.UserDao;
import com.lgc.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态sql
 * if
 * choose (when otherwise)
 * trim (where set)
 * foreach
 *
 * @author lgc
 **/
public class DynamicTest {

    SqlSession sqlSession;
    DynamicMapper dynamicMapper;

    @Before
    public void setUp() throws IOException {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession(true);
        this.dynamicMapper = sqlSession.getMapper(DynamicMapper.class);
    }

    @Test
    public void testIf() {
        User user = new User();
        user.setName("2");
        System.out.println(dynamicMapper.IfMapper(user));
    }

    @Test
    public void testTrim() {
        User user = new User();
        user.setSex("1");
        System.out.println(dynamicMapper.TrimMapper(user));
    }

    @Test
    public void testTrimUpdate() {
        User user = new User();
        user.setId("1");
        user.setSex("1");
        user.setPassword("22222222");
        System.out.println(dynamicMapper.TrimUpdateMapper(user));
    }

    @Test
    public void testChoose() {
        User user = new User();
        user.setPassword("22222222");
        System.out.println(dynamicMapper.ChooseMapper(user));
    }

    @Test
    public void setUpdate() {
        User user = new User();
        user.setId("1");
        user.setPassword("333333");
        System.out.println(dynamicMapper.setUpdateMapper(user));
    }

    @Test
    public void foreach() {
        List<String> ids = Arrays.asList("1", "2", "3");
        System.out.println(dynamicMapper.foreachMapper(ids));
    }
    @Test
    public void foreachInsert() {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        User user1 = new User();
        user.setName("ccc");
        user.setUserName("aaaa");
        user1.setName("ddd");
        user1.setUserName("bbbb");
        users.add(user);
        users.add(user1);
        System.out.println(dynamicMapper.foreachInsertMapper(users));
    }
    @Test
    public void bindParam() {
        System.out.println(dynamicMapper.bindParam("鹏"));
    }
}
