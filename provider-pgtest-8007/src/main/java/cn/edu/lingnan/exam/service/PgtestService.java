package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Pgtest;

import java.util.List;

/**
 * (Pgtest)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:20:32
 */
public interface PgtestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Pgtest queryById(Integer id);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pgtest> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pgtest 实例对象
     * @return 实例对象
     */
    boolean insert(Pgtest pgtest);

    /**
     * 修改数据
     *
     * @param pgtest 实例对象
     * @return 实例对象
     */
    Pgtest update(Pgtest pgtest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 关键字查询
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    List<Pgtest> selectByKeyWord(int page, int limit, String keyword1);

    /**
     * 计算总数
     * @return
     */
    int count();

    /**
     * 查询全部并分页
     * @param page
     * @param limit
     * @return
     */
    List<Pgtest> selectAll(int page, int limit);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);


}