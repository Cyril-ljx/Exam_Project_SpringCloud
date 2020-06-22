package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.User;

import java.util.List;

public interface UserService {

    User queryById(Integer id);


    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User loginByUser(String username, String password);

    /**
     * 查找全部
     * @param page
     * @param limit
     * @return
     */
    List<User> selectAll(int page, int limit);


    /**
     * 通过username查找
     * @param username
     * @param page
     * @param limit
     * @return
     */
    List<User> selectByUsername(String username, int page, int limit);

    /**
     * 用于分页计数
     * @return
     */
    long count();

    /**
     * 用于查询用户，然后修改密码
     * @param username
     * @return
     */
    User queryByUserName(String username);


}
