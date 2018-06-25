package com.deepcloud.mapper;

import com.deepcloud.been.Car;
import com.deepcloud.been.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午7:08 2018/6/25
 * @ Description：这个接口封装了关于订单操作的方法
 */
public interface OrderMapper {
    /**
     * 新增用戶
     * @param order 想要添加的订单的信息
     * @return int 成功返回1，不成功返回0
     */
    int insertOrder(@Param("order") Orders order) throws Exception;

    /**
     * 修改车辆信息
     * @param order 想要修改的订单的信息
     * @return int 成功返回1，不成功返回0
     */
    int updateOrder (@Param("order") Orders order) throws Exception;

    /**
     * 刪除车辆信息
     * @param orderNum 需要删除的订单的编号
     * @return int 当成功的时候，返回1 不成功返回0
     */
    int deleteOrder(@Param("orderNum") String orderNum) throws Exception;

    /**
     * 根据id查询车辆信息
     * @param orderNum 想要查询的订单的编号
     * @return Car 查询到的信息
     */
    Orders selectOrderById(@Param("orderNum") String orderNum) throws Exception;

    /**
     * 根据id查询用户信息
     * @param userName 想要查询的车辆的所有人的姓名
     * @return java.util.List<T> 返回全部的那个租户的车辆租用信息
     */
    List<Orders> findAllOrdersByUserName(@Param("userName") String userName) throws Exception;

    /**
     * 查询所有的订单信息
     * @return java.util.List<T> 返回全部的租用信息
     */
    List<Orders> findAllOrders() throws Exception;
}
