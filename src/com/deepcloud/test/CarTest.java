package com.deepcloud.test;

import com.deepcloud.been.Car;
import com.deepcloud.mapper.CarMapper;
import com.deepcloud.util.MyBatisConf;
import org.apache.ibatis.session.SqlSession;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午6:49 2018/6/25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class CarTest {

    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisConf.getSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
//        for (Car c : carMapper.findAllCars())
//            System.out.println(c);
//        Car c = carMapper.selectCarById("1");
//        System.out.println(c);
//        for (Car cc : carMapper.findAllCarsByBrand("2"))
//            System.out.println(cc);
//        try {
//            carMapper.insertCar(new Car("5", "5", "5", "5", 5.0, true, 5, 5.0, 5.0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        c = carMapper.selectCarById("5");
//        System.out.println(c);
//        carMapper.updateCar(new Car("5", "2", "5", "5", 5.0, true, 5, 5.0, 5.0));
//        System.out.println(carMapper.selectCarById("5"));
//        carMapper.deleteCar("5");
//        for (Car cc : carMapper.findAllCars())
//            System.out.println(cc);
        for (Car cc: carMapper.findAllCarsByBrandAndPrice("", 0, 0))
            System.out.println(cc);
    }
}
