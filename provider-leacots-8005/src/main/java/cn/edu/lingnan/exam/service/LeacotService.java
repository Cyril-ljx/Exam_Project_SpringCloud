package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Leacot;

import java.util.List;

/**
 * (Leacot)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:20:06
 */
public interface LeacotService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Leacot queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Leacot> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param leacot 实例对象
     * @return 实例对象
     */
    boolean insert(Leacot leacot);

    /**
     * 修改数据
     *
     * @param leacot 实例对象
     * @return 实例对象
     */
    Leacot update(Leacot leacot);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查看全部留言
     * @return
     */
    List<Leacot> selectByList();

    List<Leacot> selectByKeyWord(Integer page, Integer limit, String keyword1);

    /**
     * 查询总数，并进行显示
     * @return
     */
    int count();

    /**
     * 选出全部留言并显示
     * @param page
     * @param limit
     * @return
     */
    List<Leacot> selectAll(int page, int limit);

    /**
     * 根据id查询留言
     * @param id
     * @return
     */
    Leacot selectByPrimaryKey(Integer id);

    /**
     * 删除留言
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    boolean updateByPrimaryKey(Leacot record);
}