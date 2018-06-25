package com.deepcloud.controller.car;

import com.deepcloud.mapper.CarMapper;
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
 * @ Date       ：Created in 下午8:58 2018/6/25
 * @ Description：处理车辆删除操作
 */
@WebServlet(name = "DeleteCar")
public class DeleteCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carID = "";
        String getCarID = request.getParameter("carID");

        if (getCarID != null && !getCarID.equals("")) {
            carID = getCarID;
        } else {
            // 不存在，保险起见重定向到更新车辆界面

        }

        SqlSession sqlSession = MyBatisConf.getSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        int isDelete = carMapper.deleteCar(carID);
        if (isDelete == 1) {
            // 删除成功，跳转到更新车辆界面，并刷新

        } else {
            // 删除失败，跳转到更新车辆界面

        }
    }
}
