package cn.edu.lingnan.exam.dao;


import cn.edu.lingnan.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    User queryById(@Param("id") Integer id);


    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 影响行数
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(@Param("id") Integer id);
    /**
     * 查找全部
     * @return
     */
    List<User> selectAll();

    /**
     * 通过username查找
     * @param username
     * @return
     */
    List<User> selectByUsername(@Param("username") String username);

    long count();
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User loginByUser(@Param("username") String username, @Param("password") String password);

    /**
     * 用于修改密码
     * @param username
     * @return
     */
    User queryByUserName(String username);


}
