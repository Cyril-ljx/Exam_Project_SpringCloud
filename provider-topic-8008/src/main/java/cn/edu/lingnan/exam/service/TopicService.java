package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Topic;

import java.util.List;
import java.util.Map;

/**
 * (Topic)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:20:58
 */
public interface TopicService {

    /*找答案*/
    public Topic findAnswerById(String id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Topic queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Topic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    boolean insert(Topic topic);

    int insert(List<Topic> topics);

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    Topic update(Topic topic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteByPrimaryKey(Integer id);

    public List<Map<String,Object>> findExamRadioQuestions(Integer taotiid);

    public List<Map<String,Object>> findExamCheckboxQuestions(Integer taotiid);

    List<Topic> selectByList();

    List<Topic> selectByKeyWord(Integer page, Integer limit, String keyword1);

    /**
     * 更新数据
     * @param record
     * @return
     */
    boolean updateByPrimaryKey(Topic record);

    int count();

    /**
     * 查询全部题目
     * @param page
     * @param limit
     * @return
     */
    List<Topic> selectAll(int page, int limit);
}