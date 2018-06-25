package com.deepcloud.dao;

import com.deepcloud.been.User;
import com.deepcloud.util.MyBatisConf;
import com.rock.util.JDBCUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午9:53 2018/6/25
 * @ Description：管理软件用户的操作
 */
public class UserDao {

    /**
     * create by: xzp
     * description: 这个方法通过用户名查找是否是管理员账号，从而判断是否能登录进管理员界面
     * create time: 下午12:47 2018/6/25
     *
     * @param userName 需要验证的登录用户的名字
     * @return boolean
     */
    public static boolean isManager(String userName) {
        List<User> list = MyBatisConf.search(User.class, "test.isManager", userName);
        for (User u : list)
            System.out.println(u.toString());
        return true;
    }

    /**
     * create by: xzp
     * description: 得到全部的user对象
     * create time: 下午1:03 2018/6/25
     *
     * @return void
     * @throws
     */
    public void findAllUsers() {
        List<User> list = MyBatisConf.search(User.class, "test.findAllUsers", "");
        for (User user : list)
            System.out.println(user);
    }
}
