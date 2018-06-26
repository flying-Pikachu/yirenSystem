package com.deepcloud.controller.order;

import com.deepcloud.been.Orders;
import com.deepcloud.mapper.OrderMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午8:27 2018/6/25
 * @ Description：管理员在订单中心点击确认按钮，
 */
@WebServlet(name = "OrderConfirm")
public class OrderConfirm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderNum = "";

        String getOrderNum = request.getParameter("orderNum");
        String getOrderStatus = request.getParameter("");
        SqlSession sqlSession = MyBatisConf.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        if (getOrderNum != null && getOrderNum.equals("")) {
            // 一定发生，得到订单号，查看状态，如果是订单提交状态，更改为交易成功状态
            try {
                Orders orders = orderMapper.selectOrderById(orderNum);
                if (orders.getOrderStatus() == 1) {
                    orders.setOrderStatus(3);
                    orderMapper.updateOrder(orders);
                    // 跳回管理员查看界面，并刷新状态
                    // 根据orderNum获得当前的返回订单信息
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // 不会发生，但保险起见还是跳回原来的界面吧

        }
    }
}
