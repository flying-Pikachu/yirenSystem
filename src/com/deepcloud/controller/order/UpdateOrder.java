package com.deepcloud.controller.order;

import com.deepcloud.been.Car;
import com.deepcloud.been.Orders;
import com.deepcloud.mapper.CarMapper;
import com.deepcloud.mapper.OrderMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午8:59 2018/6/25
 * @ Description：更新订单信息
 */
@WebServlet(name = "UpdateOrder")
public class UpdateOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderNum = request.getParameter("orderNum");
        boolean from = false;

        if (request.getParameter("from").equals("Cancel")) {
            from = true;
        }
        SqlSession sqlSession = MyBatisConf.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        if (true) {
            try {
                Orders orders = orderMapper.selectOrderById(orderNum);
                if (orders.getOrderStatus() == 1)
                    orders.setOrderStatus(2);
                int isUpdate = orderMapper.updateOrder(orders);
                if (isUpdate == 1) {
                    // 订单取消成功
                    // 返回订单中心

                } else {
                    // 订单取消失败
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String pickUpYear = "", pickUpMonth = "", pickUpDay = "",
                    returnYear = "", returnMonth = "", returnDay = "",
                    orderCost = "";
            CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
            String carID = request.getParameter("carID");
            Car car = carMapper.selectCarById(carID);
            if ((pickUpDay == null && pickUpDay.equals("")) ||
                    (pickUpMonth == null && pickUpMonth.equals("")) ||
                    (pickUpYear == null && pickUpYear.equals("")) ||
                    (returnDay == null && returnDay.equals("")) ||
                    (returnMonth == null && returnMonth.equals("")) ||
                    (returnYear == null && returnYear.equals("")) ||
                    (orderCost == null && orderCost.equals(""))) {
                //  有空值，返回提交订单界面
                // 返回的时候把想要预定的车辆的车号记录下来

            }
            try {
                Orders orders = orderMapper.selectOrderById(orderNum);
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                Date pickupTime = null, returnTime = null;
                pickupTime = dateFormat1.parse(pickUpYear + "-" + pickUpMonth + "-" + pickUpDay);
                returnTime = dateFormat1.parse(returnYear + "-" + returnMonth + "-" + returnDay);
                double cost = (int) ((returnTime.getTime() - pickupTime.getTime()) / (1000*3600*24)) * car.getOriginalPrice() * car.getDiscount();
                orders.setPickupTime(pickupTime);
                orders.setReturnTime(returnTime);
                orders.setOrderCost(cost);
                int isUpdate = orderMapper.updateOrder(orders);
                if (isUpdate == 1) {
                    // 更新成功
                    // 返回订单中心

                } else {
                    // 失败
                    // 返回修改界面，显示失败原因

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}