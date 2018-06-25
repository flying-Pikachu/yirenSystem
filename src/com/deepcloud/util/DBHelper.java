package com.studentDemo.util;

import com.studentDemo.been.Student;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {

    public static final String url = "jdbc:mysql://127.0.0.1:3306/studentDemo?useUnicode=true&characterEncoding=utf8";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "123456";

    /**
     * Get the connection with database
     *
     * @return connection if connection successful
     * 		   null if connection fail
     * @throws ....Exception if upload
     */
    public static Connection conn() {
        try {
            Class.forName(name);//指定连接类型
            Connection conn = DriverManager.getConnection(url, user, password);//获取连接\
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
