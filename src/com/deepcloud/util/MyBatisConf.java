package com.deepcloud.util;


import com.deepcloud.been.User;
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
 * @ Date       ：Created in 下午12:52 2018/6/25
 * @ Description：MyBatis 的配置文件，封装一些常用的增删改查的方法
 */
public class MyBatisConf {

    /**
     * create by: xzp
     * description: 通过xml以及提供的参数，返回需要的类型
     * create time: 下午12:56 2018/6/25
     *
     * @param loc xml 的路径
     * @param args 执行sql语句所需要的参数
     * @param c 返回列表的泛型类型
     * @return java.util.List<T>
     * @throws IOException 当没有找到配置文件的时候
     */
    public static <T>List<T> search(Class<T> c, String loc, String ...args) {
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
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        List<T> list = sqlSession.selectList(loc, args[0]);
        sqlSession.close();
        return list;
    }
}
