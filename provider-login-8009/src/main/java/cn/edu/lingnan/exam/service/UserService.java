package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.User;

import java.util.List;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:21:06
 */
public interface UserService {


    User queryById(Integer id);



    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

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
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids);
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