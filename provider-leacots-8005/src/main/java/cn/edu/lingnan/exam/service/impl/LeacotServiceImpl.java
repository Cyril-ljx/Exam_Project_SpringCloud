package cn.edu.lingnan.exam.service.impl;


import cn.edu.lingnan.exam.dao.LeacotDao;
import cn.edu.lingnan.exam.entity.Leacot;
import cn.edu.lingnan.exam.service.LeacotService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Leacot)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:20:06
 */
@Service("leacotService")
public class LeacotServiceImpl implements LeacotService {
    @Resource
    private LeacotDao leacotDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Leacot queryById(Integer id) {
        return this.leacotDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Leacot> queryAllByLimit(int offset, int limit) {
        return this.leacotDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param leacot 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Leacot leacot) {
        try {
            int insert = leacotDao.insert(leacot);
            if (insert > 0) {
                return true;
            } else {
                throw new RuntimeException("服务器中途喝咖啡去了，稍后就回来！");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务器卡顿，留言添加失败！"+e.getMessage());
        }
    }

    /**
     * 修改数据
     *
     * @param leacot 实例对象
     * @return 实例对象
     */
    @Override
    public Leacot update(Leacot leacot) {
        this.leacotDao.update(leacot);
        return this.queryById(leacot.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.leacotDao.deleteById(id) > 0;
    }

    /**
     * 查看全部留言
     * @return
     */
    @Override
    public List<Leacot> selectByList() {
        return leacotDao.selectAll();
    }

    /**
     * 通过关键字，并进行分页显示
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @Override
    public List<Leacot> selectByKeyWord(Integer page, Integer limit, String keyword1) {
        return leacotDao.selectByKeyWord(keyword1);
    }

    @Override
    public int count() {
        return leacotDao.count();
    }


    @Override
    public List<Leacot> selectAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Leacot> leacots = leacotDao.selectAll();
        PageInfo info = new PageInfo(leacots);
        return info.getList();
    }

    @Override
    public Leacot selectByPrimaryKey(Integer id) {
        return leacotDao.selectByPrimaryKey(id);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        int del = leacotDao.deleteByPrimaryKey(id);
        if (del > 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除留言
     * @param leacot
     * @return
     */
    @Override
    public boolean updateByPrimaryKey(Leacot leacot) {
        try {
            int update = leacotDao.updateByPrimaryKey(leacot);
            if (update > 0) {
                return true;
            } else {
                throw new RuntimeException("服务器中途喝咖啡去了，稍后就回来！");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务器卡顿，留言修改失败！"+e.getMessage());
        }
    }
}