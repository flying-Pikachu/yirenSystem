package com.deepcloud.controller.car;

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
import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午8:49 2018/6/25
 * @ Description：获取全部车辆信息界面
 */
@WebServlet(name = "GetCars")
public class GetCars extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String)request.getSession().getAttribute("userName");
        String carBrand = "";
        boolean from = false;

        if (request.getParameter("from").equals("true"))
            from = true;

        if (from) {
            // 从管理员界面跳转过来,返回全部订单信息
            String getCarBrand = request.getParameter("carBrand");
            if (getCarBrand != null)
                carBrand = getCarBrand;
            List<Car> list = null;
            SqlSession sqlSession = MyBatisConf.getSession();
            CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
            if (carBrand.equals("")) {
                try {
                    list = carMapper.findAllCars();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    list = carMapper.findAllCarsByBrand(carBrand);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 数据存储在了list中，返回页面即可，分页处理之后再做

        } else {
            // 从用户端跳转过来
            double lowPrice = 0, highPrice = 0;

            String getCarBrand = request.getParameter("carBrand"),
                    getLowPrice = request.getParameter("lowPrice"),
                    getHighPrice = request.getParameter("highPrice");

            if (getCarBrand != null)
                carBrand = getCarBrand;

            if (getLowPrice.equals(""))
                lowPrice = 0;
            else
                lowPrice = Double.valueOf(getLowPrice);
            if (getHighPrice.equals(""))
                highPrice = 0;
            else
                highPrice = Double.valueOf(getHighPrice);
            if (highPrice < lowPrice)
                // 输入有误，返回用户端查询界面
                System.out.println();
            else {
                SqlSession sqlSession = MyBatisConf.getSession();
                CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
                List<Car> list = carMapper.findAllCarsByBrandAndPrice(carBrand, lowPrice, highPrice);
                // 得到list，返回界面
            }
        }
    }
}
