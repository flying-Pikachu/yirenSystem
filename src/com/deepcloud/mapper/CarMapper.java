package com.deepcloud.mapper;

import com.deepcloud.been.Car;
import com.deepcloud.been.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午6:30 2018/6/25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface CarMapper {

    /**
     * 新增用戶
     * @param car 想要添加的车辆的信息
     * @return int 成功返回1，不成功返回0
     */
    int insertCar(@Param("car") Car car) throws Exception;

    /**
     * 修改车辆信息
     * @param car 想要修改的车辆的信息
     * @return int 成功返回1，不成功返回0
     */
    int updateCar (@Param("car") Car car);

    /**
     * 刪除车辆信息
     * @param carID 需要删除的车辆的id用户名
     * @return int 当成功的时候，返回1 不成功返回0
     */
    int deleteCar(@Param("carID") String carID);

    /**
     * 根据id查询车辆信息
     * @param carID 想要查询的车辆的编号
     * @return Car 查询到的信息
     */
    Car selectCarById(@Param("carID") String carID);

    /**
     * 根据id查询用户信息
     * @param carBrand 想要查询的车辆的牌子
     * @return java.util.List<T> 返回全部的那个牌子的车辆信息
     */
    List<Car> findAllCarsByBrand(@Param("carBrand") String carBrand);

    /**
     * 查询所有的车辆信息
     * @return java.util.List<T> 返回全部的用户信息
     */
    List<Car> findAllCars();
}
