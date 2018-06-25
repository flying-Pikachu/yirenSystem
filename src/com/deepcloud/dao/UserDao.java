package com.deepcloud.dao;

import com.deepcloud.been.User;
import com.rock.util.JDBCUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午9:53 2018/6/25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class UserDao {

    public static boolean isManager(String userName) {
        JDBCUtil util = new JDBCUtil();
        System.out.println(userName);
        String sql = "SELECT * FROM user WHERE userName = ?";

        for (User u : util.query(User.class, sql, userName))
            System.out.println(u.toString());
        return true;
    }

    public void findUserByIdTest() throws IOException {

        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        // 释放资源
        sqlSession.close();

    }
}
