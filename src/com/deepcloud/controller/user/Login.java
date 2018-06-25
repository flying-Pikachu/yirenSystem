package com.deepcloud.controller.user;

import com.deepcloud.been.User;
import com.deepcloud.mapper.UserMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午2:26 2018/6/25
 * @ Description：这个Servlet用来处理登录请求
 */
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
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

        UserMapper userMapper = MyBatisConf.getMapper(UserMapper.class);
        User user = null;
        // 验证用户名密码
        if (userMapper.isExist(userName)) {
            user = userMapper.selectUserById(userName);
            if (!user.getUserPassword().equals(userPassword)) {
                // 密码不对，返回登录界面-用户或管理员
            }
        } else {
            // 用户不存在，返回登录界面-用户或管理员
        }

        // 验证是否从管理员界面过来
        if (from) {
            if (user.getIsManager() == 1) {
                // 从管理员界面跳转并且是管理员
                // 管理员界面
            } else {
                // 不是管理员
                // 管理员登录界面
            }
        }

    }
}
