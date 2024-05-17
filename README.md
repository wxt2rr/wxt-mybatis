# wxt-mybatis
> 自定义持久层框架(仿mybatis)

**测试**
~~~java
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
~~~

**整体流程**
</br>
核心就是 <span style="color:red;">反射</span> + <span style="color:red;">代理</span>
* 加载配置文件
  * 读取配置文件内容
  * 解析配置文件内容
  * 封装实体配置对象类
* 创建 SqlSessionFactory 接口
  * 封装核心配置对象
  * 生产SqlSession
* 创建 SqlSession 接口
  * 代理dao层接口
  * 抽象sql方法
* 创建 Executor 接口
  * 使用连接池与数据库交互
  * 执行sql
  * 封装返回结果

**流程图**
![image](https://cdn.jsdelivr.net/gh/wxt2rr/images@main/github/未命名文件.png)
