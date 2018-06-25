package com.deepcloud.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午12:52 2018/6/25
 * @ Description：MyBatis 的配置文件，封装一些常用的增删改查的方法
 */
public class MyBatisConf {

    /**
     * create by: xzp
     * description: 通过xml以及提供的参数，返回需要的类型
     * create time: 下午12:56 2018/6/25
     *
     * @return java.util.List<T>
     * @throws IOException 创建输入流失败
     */
    public static SqlSession getSession() {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        return sqlSessionFactory.openSession();
    }

}
