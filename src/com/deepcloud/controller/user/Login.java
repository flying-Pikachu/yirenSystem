package com.deepcloud.controller.user;

import com.deepcloud.been.User;
import com.deepcloud.mapper.UserMapper;
import com.deepcloud.util.MyBatisConf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午2:26 2018/6/25
 * @ Description：这个Servlet用来处理登录请求
 */
@WebServlet(name = "/Login")
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {


        System.out.println("进入");
        String userName = "", userPassword = "";
        boolean from = false;

        String getUserName = request.getParameter("userName");
        String getUserPassword = request.getParameter("userPassword");
        String getFrom = request.getParameter("from");

        if (getUserName == null || getUserName.equals("")) {

        } else if (getUserPassword == null || getUserPassword.equals("")) {

        }

        from = getFrom.equals("true");

        userName = getUserName;
        userPassword = getUserPassword;

        System.out.println(userName + " " + userPassword + " " + from);

        UserMapper userMapper = MyBatisConf.getSession().getMapper(UserMapper.class);
        User user = userMapper.selectUserById(userName);
        if (!user.getUserPassword().equals(userPassword)) {
            // 密码不对，跳转回原来的界面
            response.sendRedirect("Login.html?userName="+userName+"&from=false");
        }

        request.getSession().setAttribute("userName", userName);
        // 验证是否从管理员界面过来
        if (from) {
            if (user.getIsManager() == 1) {
                // 从管理员界面跳转并且是管理员
                // 管理员界面

            } else {
                // 不是管理员
                // 管理员登录界面
                // 获取全部的可用车辆信息
            }
        }

    }
}
