import com.wangxt.mybatis.core.demo.dao.RoleDao;
import com.wangxt.mybatis.core.demo.dao.UserDao;
import com.wangxt.mybatis.core.demo.pojo.RoleDo;
import com.wangxt.mybatis.core.demo.pojo.UserDo;
import com.wangxt.mybatis.core.io.Resources;
import com.wangxt.mybatis.core.sqlSession.SqlSession;
import com.wangxt.mybatis.core.sqlSession.SqlSessionFactory;
import com.wangxt.mybatis.core.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MyTest {

    @Test
    public void test() throws Exception{
        // 加载 数据源配置文件
        InputStream resourceAsSteam = Resources.getResourceAsSteam("SqlConfig.xml");
        // 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        // 生产 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 代理 实际 dao层 对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        UserDo result = userDao.queryUser(new UserDo(1L, "wxt"));
        System.out.println(result);

        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        RoleDo roleDo = roleDao.queryRole(1L);
        System.out.println(roleDo);
    }
}
