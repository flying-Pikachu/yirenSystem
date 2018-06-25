package com.deepcloud.test;

import com.deepcloud.mapper.UserMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午3:51 2018/6/25
 * @ Description：测试user
 */
public class UserTest {

    public static void main(String[] args) {
        UserMapper userMapper = MyBatisConf.getMapper(UserMapper.class);

        System.out.println(userMapper.isExist("1"));
    }

}
