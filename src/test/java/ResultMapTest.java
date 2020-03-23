import com.lgc.mybatis.dao.StudentMapper;
import com.lgc.mybatis.dao.UserDao;
import com.lgc.mybatis.entity.Student;
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
 **/
public class ResultMapTest {
    public UserDao userDao;
    public StudentMapper studentMapper;
    public SqlSession sqlSession;


    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession(true);
        this.userDao = sqlSession.getMapper(UserDao.class);
        this.studentMapper = sqlSession.getMapper(StudentMapper.class);

    }

    @Test
    public void queryUserStudent() {
        System.out.println(this.userDao.selectUserByResultMap("1"));
        System.out.println(this.userDao.selectUserByResultMapAss("1"));
        System.out.println("-------");
        System.out.println(this.userDao.selectUserByStep("1"));
        System.out.println();
    }

    @Test
    public void testStep() {
        User user = this.userDao.selectUserByStep("1");
        System.out.println(user);
    }

    @Test
    public void testCollection() {
        Student studentUser = studentMapper.getStudentUser("1");
        System.out.println(studentUser);
    }
    @Test
    public void testCollectionParamMap(){
        System.out.println(studentMapper.getStudentUserMap("1"));
    }

}
