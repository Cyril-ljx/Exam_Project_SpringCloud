package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Article;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2020-06-15 17:19:47
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
//    Article insert(Article article);
     boolean insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 这是客户端查找全部页面的方法
     * @return
     */
    List<Article> selectClientAll();

    /**
     * 查看具体的某篇文章
     * @param id
     * @return
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * 关键字查询
     * @param page
     * @param limit
     * @param keyword1
     * @param keyword2
     * @param keyword3
     * @return
     */
    List<Article> selectByKeyWord(int page, int limit, String keyword1, String keyword2, String keyword3);

    /**
     * 查询全部
     * @return
     */
    int count();

    /**
     * 分页
     * @param page
     * @param limit
     * @return
     */
    List<Article> selectAll(int page, int limit);

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

    //根据拿到的对象对数据进行修改
    boolean updateByPrimaryKey(Article article);
}