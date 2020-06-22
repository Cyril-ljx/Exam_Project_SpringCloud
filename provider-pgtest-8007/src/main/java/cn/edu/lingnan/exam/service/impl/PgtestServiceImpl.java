package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.dao.PgtestDao;
import cn.edu.lingnan.exam.entity.Pgtest;
import cn.edu.lingnan.exam.service.PgtestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Pgtest)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:20:32
 */
@Service("pgtestService")
public class PgtestServiceImpl implements PgtestService {
    @Resource
    private PgtestDao pgtestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Pgtest queryById(Integer id) {
        return this.pgtestDao.queryById(id);
    }



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Pgtest> queryAllByLimit(int offset, int limit) {
        return this.pgtestDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pgtest 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Pgtest pgtest) {

        try {
            int insert = pgtestDao.insert(pgtest);
            if (insert > 0) {
                return true;
            } else {
                throw new RuntimeException("数据库异常...");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务器异常...." + e.getMessage());
        }
    }

    /**
     * 修改数据
     *
     * @param pgtest 实例对象
     * @return 实例对象
     */
    @Override
    public Pgtest update(Pgtest pgtest) {
        this.pgtestDao.update(pgtest);
        return this.queryById(pgtest.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.pgtestDao.deleteById(id) > 0;
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @Override
    public List<Pgtest> selectByKeyWord(int page, int limit, String keyword1) {
        //分页
        PageHelper.startPage(page, limit);
        //
        List<Pgtest> pgTests = pgtestDao.selectAllByKeyWord(keyword1);
        PageInfo info = new PageInfo(pgTests);
        return info.getList();
    }

    /**
     * 查询结果总数
     *
     * @return
     */
    @Override
    public int count() {
        return pgtestDao.count();
    }

    /**
     * 分页查询全部
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Pgtest> selectAll(int page, int limit) {

        //分页
        PageHelper.startPage(page, limit);
        List<Pgtest> pgTests = pgtestDao.selectAll();
        PageInfo info = new PageInfo(pgTests);
        return info.getList();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        int del = pgtestDao.deleteByPrimaryKey(id);
        if (del > 0) {
            return true;
        }
        return false;
    }
}