package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.dao.ReplyDao;
import cn.edu.lingnan.exam.entity.Reply;
import cn.edu.lingnan.exam.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Reply)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:20:46
 */
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyDao replyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Reply queryById(Integer id) {
        return this.replyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Reply> queryAllByLimit(int offset, int limit) {
        return this.replyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reply 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Reply reply) {
        try {
            int insert = replyDao.insert(reply);
            if (insert > 0) {
                return true;
            } else {
                throw new RuntimeException("数据库异常....");
            }
        } catch (Exception e) {
            throw new RuntimeException("后台异常...."+e.getMessage());
        }
    }

    /**
     * 修改数据
     *
     * @param reply 实例对象
     * @return 实例对象
     */
    @Override
    public boolean updateByPrimaryKey(Reply reply) {
        try {
            int update = replyDao.updateByPrimaryKey(reply);
            if (update > 0) {
                return true;
            } else {
                throw new RuntimeException("数据库异常...");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务器异常...." + e.getMessage());
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.replyDao.deleteById(id) > 0;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        int del = replyDao.deleteByPrimaryKey(id);
        if (del > 0) {
            return true;
        }
        return false;
    }
}