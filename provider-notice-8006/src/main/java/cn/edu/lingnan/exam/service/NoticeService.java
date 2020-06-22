package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Notice;

import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:20:21
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notice queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    boolean insert(Notice record);

    /**
     * 修改数据
     * @return 实例对象
     */
    boolean update(Notice record);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Notice> queryAll(int page, int limit);

    List<Notice> selectAllClientNotice();

    List<Notice> selectByKeyWord(int page, int limit, String keyword1, String keyword2);

    Notice selectByPrimerKey(Integer id);

    int count();
}