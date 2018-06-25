package com.deepcloud.controller.car;

import com.deepcloud.been.Car;
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
 * @ Description：更新车辆信息，以及插入车辆信息
 * @ Modified By：
 * @Version: $version$
 */
@WebServlet(name = "UpAndInCar")
public class UpAndInCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = "", carBrand = "", carModel = "", carStruct = "";
        double carDisplacement = 0, originalPrice = 0, discount = 0;
        boolean isManual = false;
        int maxMum = 0;
        // 判断界面的跳转，如果从Insert界面跳转过来为true,Update跳转为false
        boolean from = false;

        String getCarId = request.getParameter("carId"),
                getCarBrand = request.getParameter("carBrand"),
                getCarModel = request.getParameter("carModel"),
                getCarStruct = request.getParameter("carStruct"),
                getCarDisplacement = request.getParameter("carDisplacement"),
                getOriginalPrice = request.getParameter("originalPrice"),
                getDiscount = request.getParameter("discount"),
                getIsManual = request.getParameter("isManual"),
                getMaxMum = request.getParameter("maxMum");

        SqlSession sqlSession = MyBatisConf.getSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        String getFrom = request.getParameter("from");
        if (getFrom.equals("Ins")) {
            from = true;
            // 给getCarId 分配一个新的id
            int i = 1;
            while (true) {
                if (carMapper.selectCarById(""+i) == null) {
                    getCarId = "" + i;
                    break;
                }
                i++;
            }
        }

        // 进行非空检测
        if (getCarId != null && !getCarId.equals("")) {
            carId = getCarId;
        } else {
            // 由于是点击过来的，应该不会触发这里
            // 跳转到更新车辆界面
        }
        if (getCarBrand != null && !getCarBrand.equals("")) {
            carBrand = getCarBrand;
        } else {

        }
        if (getCarModel != null && !getCarModel.equals("")) {
            carModel = getCarModel;
        } else {

        }
        if (getCarStruct != null && !getCarStruct.equals("")) {
            carStruct = getCarStruct;
        } else {

        }
        if (getCarDisplacement != null && !getCarDisplacement.equals("")) {
            carDisplacement = Double.valueOf(getCarDisplacement);
        } else {

        }
        if (getOriginalPrice != null && !getOriginalPrice.equals("")) {
            originalPrice = Double.valueOf(getOriginalPrice);
        } else {

        }
        if (getDiscount != null && !getDiscount.equals("")) {
            discount = Double.valueOf(getDiscount);
        } else {

        }
        if (getIsManual != null && !getIsManual.equals("")) {
            if (getIsManual.equals("1"))
                isManual = true;
        } else {

        }
        if (getMaxMum != null && !getMaxMum.equals("")) {
            maxMum = Integer.valueOf(getMaxMum);
        } else {

        }

        Car c = new Car(carId, carBrand, carModel, carStruct, carDisplacement, isManual, maxMum, originalPrice, discount);

        int i = 0;
        if (from) {
            try {
                i = carMapper.insertCar(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            i = carMapper.updateCar(c);
        }
        if (i == 1) {
            // 更改成功，跳转到更改车辆界面

        } else {
            // 更改失败， 跳转回更改界面

        }
    }
}
