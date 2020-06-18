package cn.edu.lingnan.exam.dao;

import cn.edu.lingnan.exam.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 17:19:47
 */
@Mapper
@Repository
public interface ArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<Article> queryAll(Article article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    //查询全部的文章
    List<Article> selectAll();

    //根据主键查询文章
    Article selectByPrimaryKey(Integer id);

    //关键字查询
    List<Article> selectByKeyWord(String keyword1, String keyword2, String keyword3);

    //计数
    int count();

    //根据id删除
    int deleteByPrimaryKey(Integer id);

    //根据文章的id更新文章
    int updateByPrimaryKey(Article record);
}