import com.lgc.mybatis.dao.PersonMapper;
import com.lgc.mybatis.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lgc
 **/
public class PersonTest {
    SqlSession sqlSession;
    PersonMapper personMapper;

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
        this.personMapper = sqlSession.getMapper(PersonMapper.class);
    }

    @Test
    public void testSelectKey() {
        Person person = new Person();
        person.setAge(22);
        person.setName("ggg");
        person.setSex("1");
        personMapper.insertPerson(person);
        System.out.println(person.getId());
    }
}
