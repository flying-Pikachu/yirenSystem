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
 * @ Date       ：Created in 下午9:00 2018/6/25
 * @ Description：生成一条订单
 */
@WebServlet(name = "InsertOrder")
public class InsertOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 点击租车后进入这个生成订单界面
        String userName = (String)request.getSession().getAttribute("userName");


        String pickUpYear = "", pickUpMonth = "", pickUpDay = "",
                returnYear = "", returnMonth = "", returnDay = "",
                orderCost = "";
        SqlSession sqlSession = MyBatisConf.getSession();
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

        String orderNum = "";

        while (true) {
            int i = 1;
            if (carMapper.selectCarById("" + i) == null) {
                orderNum = "" + i;
                break;
            }
            i++;
        }
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date pickupTime = null, returnTime = null;
        try {
            pickupTime = dateFormat1.parse(pickUpYear + "-" + pickUpMonth + "-" + pickUpDay);
            returnTime = dateFormat1.parse(returnYear + "-" + returnMonth + "-" + returnDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double cost = (int) ((returnTime.getTime() - pickupTime.getTime()) / (1000*3600*24)) * car.getOriginalPrice() * car.getDiscount();
        Orders orders = new Orders(orderNum, carID, userName, pickupTime, returnTime, 1, cost);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        try {
            int isInsert = orderMapper.insertOrder(orders);
            if (isInsert == 1) {
                // 插入成功，进入订单成功界面
                // 需要车辆信息和订单信息

            } else {
                // 插入失败，返回交易界面

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
