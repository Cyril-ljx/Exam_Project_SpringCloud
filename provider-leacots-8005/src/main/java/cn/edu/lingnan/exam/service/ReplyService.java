package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Reply;

import java.util.List;

/**
 * (Reply)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:20:46
 */
public interface ReplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Reply queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Reply> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reply 实例对象
     * @return 实例对象
     */
    boolean insert(Reply reply);

    /**
     * 修改数据
     *
     * @param reply 实例对象
     * @return 实例对象
     */
    boolean updateByPrimaryKey(Reply reply);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 删除回复
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

}