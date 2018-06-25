package com.deepcloud.mapper;

import com.deepcloud.been.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午1:50 2018/6/25
 * @ Description：用户操作接口
 */
public interface UserMapper {
    /**
     * 新增用戶
     * @param user 想要添加的用户的信息
     * @return int 成功返回1，不成功返回0
     */
    int insertUser(@Param("user") User user) throws Exception;

    /**
     * 修改用戶
     * @param user 想要删除的用户的信息
     * @return int 成功返回1，不成功返回0
     */
    int updateUser (@Param("user") User user);

    /**
     * 刪除用戶
     * @param userName 需要删除的用户名
     * @return int 当成功的时候，返回1 不成功返回0
     */
    int deleteUser(@Param("userName") String userName);

    /**
     * 根据id查询用户信息
     * @param userName 想要查询的用户名
     * @return User 查询到的信息
     */
    User selectUserById(@Param("userName") String userName);

    /**
     * 查询所有的用户信息
     * @return java.util.List<T> 返回全部的用户信息
     */
    List<User> findAllUsers();

}
