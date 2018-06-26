package com.deepcloud.controller.user;

import com.deepcloud.been.User;
import com.deepcloud.mapper.UserMapper;
import com.deepcloud.util.MyBatisConf;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午2:26 2018/6/25
 * @ Description：这个Servlet用来处理注册操作
 */
@WebServlet (name = "/Register")
public class Register extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        String userName = "", userPassword = "";

        String getUserName = request.getParameter("userName");
        String getUserPassword = request.getParameter("userPassword");
        String getUserPasswordVerification = request.getParameter("userPasswordVerification");

        if (getUserName == null || getUserName.equals("")) {

        } else if (getUserPassword == null || getUserPassword.equals("")) {

        } else if (getUserPasswordVerification == null || getUserPasswordVerification.equals("")) {

        } else if (!getUserPassword.equals(getUserPasswordVerification)) {

        }

        userName = getUserName;
        userPassword = getUserPassword;

        UserMapper userMapper = MyBatisConf.getSession().getMapper(UserMapper.class);
        User user = new User(userName, userPassword, 0);
        int isInsert = 0;
        try {
            isInsert = userMapper.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isInsert == 1) {
            // 插入成功
            request.getSession().setAttribute("userName", userName);

        } else {
            // 插入失败

        }
    }
}
