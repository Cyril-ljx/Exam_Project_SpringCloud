package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.dao.UserDao;
import cn.edu.lingnan.exam.entity.User;
import cn.edu.lingnan.exam.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;



    @Override
    public User queryById(Integer id) {
        return userDao.queryById(id);
    }


    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    @Override
    public int updateByPrimaryKey(User record) {
        return userDao.updateByPrimaryKey(record);
    }



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public User loginByUser(String username, String password) {
        if (username != null && password != null) {
            return userDao.loginByUser(username, DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        return null;
    }

    @Override
    public List<User> selectAll(int page, int limit) {
        //进行分页
        PageHelper.startPage(page, limit);
        List<User> users = userDao.selectAll();
        PageInfo info = new PageInfo(users);
        return info.getList();
    }

    @Override
    public List<User> selectByUsername(String username, int page, int limit) {
        //进行分页
        PageHelper.startPage(page, limit);
        List<User> users = userDao.selectByUsername(username);
        PageInfo info = new PageInfo(users);
        return info.getList();
    }

    @Override
    public long count() {
        return userDao.count();
    }

    @Override
    public User queryByUserName(String username) {
        if(username != null){
            return userDao.queryByUserName(username);
        }
        return null;
    }
}
