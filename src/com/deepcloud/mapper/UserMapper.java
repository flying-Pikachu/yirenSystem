package com.deepcloud.mapper;

import com.deepcloud.been.User;

import java.util.List;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 下午1:50 2018/6/25
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public interface UserMapper {
    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    int insertUser(User user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    int updateUser (User user,int id) throws Exception;
    /**
     * 刪除用戶
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUser(int id) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    User selectUserById(int id) throws Exception;
    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    List<User> selectAllUser() throws Exception;
}
