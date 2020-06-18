package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.dao.LabelDao;
import cn.edu.lingnan.exam.entity.Label;
import cn.edu.lingnan.exam.service.LabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Label)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:19:57
 */
@Service("labelService")
public class LabelServiceImpl implements LabelService {
    @Resource
    private LabelDao labelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Label queryById(Integer id) {
        return this.labelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Label> queryAllByLimit(int offset, int limit) {
        return this.labelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    @Override
    public Label insert(Label label) {
        this.labelDao.insert(label);
        return label;
    }

    /**
     * 修改数据
     *
     * @param label 实例对象
     * @return 实例对象
     */
    @Override
    public Label update(Label label) {
        this.labelDao.update(label);
        return this.queryById(label.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.labelDao.deleteById(id) > 0;
    }

    /**
     * 查询全部标签
     * @return
     */
    @Override
    public List<Label> selectAll() {
        return labelDao.selectAll();
    }
}