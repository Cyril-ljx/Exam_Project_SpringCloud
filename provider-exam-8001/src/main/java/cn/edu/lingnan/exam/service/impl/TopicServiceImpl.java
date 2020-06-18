package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.dao.TopicDao;
import cn.edu.lingnan.exam.entity.Topic;
import cn.edu.lingnan.exam.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Topic)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:20:58
 */
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Topic queryById(Integer id) {
        return this.topicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Topic> queryAllByLimit(int offset, int limit) {
        return this.topicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Topic topic) {
        try {
            topic.setTopicTime(new Date());
            //从全局Session获得，操作用户
            topic.setUserOp(LoginSession.getCurrentUser().getUsername());
            int insert = topicDao.insert(topic);
            if (insert > 0) {
                return true;
            } else {
                throw new RuntimeException("数据库异常...");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务器异常..."+e.getMessage());
        }
    }

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    @Override
    public Topic update(Topic topic) {
        this.topicDao.update(topic);
        return this.queryById(topic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        int del = topicDao.deleteByPrimaryKey(id);
        if (del > 0) {
            return true;
        }
        return false;
    }

    /**
     * 选出题库中存放的题目
     * @return
     */
    @Override
    public List<Topic> selectByList() {
        return topicDao.selectAll();
    }

    /**
     * 通过关键字进行查询
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @Override
    public List<Topic> selectByKeyWord(Integer page, Integer limit, String keyword1) {
        PageHelper.startPage(page, limit);
        List<Topic> topics = topicDao.selectByKeyWord(keyword1);
        PageInfo info = new PageInfo(topics);
        return info.getList();
    }

    /**
     * 更新数据
     * @param topic
     * @return
     */
    @Override
    public boolean updateByPrimaryKey(Topic topic) {
        try {
            topic.setTopicTime(new Date());
            //从全局Session获得，操作用户
            topic.setUserOp("admin");
            int update = topicDao.updateByPrimaryKey(topic);
            if (update > 0) {
                return true;
            } else {
                throw new RuntimeException("数据库异常....");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务器异常...."+e.getMessage());
        }
    }


    @Override
    public int count() {
        return topicDao.count();
    }

    /**
     * 查询全部并分页
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Topic> selectAll(int page, int limit) {
        //分页
        PageHelper.startPage(page, limit);
        List<Topic> topics = topicDao.selectAll();
        PageInfo info = new PageInfo(topics);
        return info.getList();
    }
}