package com.deepcloud.controller.order;

import com.deepcloud.been.Orders;
import com.deepcloud.mapper.OrderMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午8:07 2018/6/25
 * @ Description：这个servlet用来返回订单查询信息的
 */
public class GetOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String)request.getSession().getAttribute("userName");
        String orderNum = "";
        // 从Manager跳转过来为true，user跳转过来为false
        boolean from = false;

        if (request.getParameter("from").equals("true"))
            from = true;

        if (from) {
            // 从管理员界面跳转过来,返回全部订单信息
            String getOrderNum = request.getParameter("orderNum");
            if (getOrderNum != null)
                orderNum = getOrderNum;
            List<Orders> list = null;
            SqlSession sqlSession = MyBatisConf.getSession();
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            if (orderNum.equals("")) {
                try {
                    list = orderMapper.findAllOrders();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    list.add(orderMapper.selectOrderById(orderNum));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 数据存储在了list中，返回页面即可，分页处理之后再做

        } else {
            // 返回全部的userName的订单信息

        }
    }
}
