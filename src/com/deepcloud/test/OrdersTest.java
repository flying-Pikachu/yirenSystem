package com.deepcloud.test;

import com.deepcloud.been.Car;
import com.deepcloud.been.Orders;
import com.deepcloud.mapper.CarMapper;
import com.deepcloud.mapper.OrderMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午7:38 2018/6/25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class OrdersTest {

    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = MyBatisConf.getSession();
        OrderMapper carMapper = sqlSession.getMapper(OrderMapper.class);
        for (Orders c : carMapper.findAllOrders())
            System.out.println(c);
        for (Orders cc : carMapper.findAllOrdersByUserName("1"))
            System.out.println(cc);
        try {
            carMapper.insertOrder(new Orders("5", "5", "1", new Date(), new Date(), true, 5.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Orders orders = carMapper.selectOrderById("5");
        System.out.println(orders);
        carMapper.updateOrder(new Orders("5", "5", "1", new Date(), new Date(), false, 5.0));
        System.out.println(carMapper.selectOrderById("5"));
        carMapper.deleteOrder("5");
        for (Orders cc : carMapper.findAllOrders())
            System.out.println(cc);
    }
}
