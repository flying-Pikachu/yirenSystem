package com.deepcloud.test;

import com.deepcloud.been.User;
import com.deepcloud.mapper.UserMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午3:51 2018/6/25
 * @ Description：测试user
 */
public class UserTest {

    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisConf.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            System.out.println(userMapper.insertUser(new User("4", "4", 1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (User user : userMapper.findAllUsers())
            System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

}
