package cn.edu.lingnan.exam.dao;

import cn.edu.lingnan.exam.entity.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Label)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 17:19:57
 */
@Mapper
@Repository
public interface LabelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Label queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Label> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param label 实例对象
     * @return 对象列表
     */
    List<Label> queryAll(Label label);

    /**
     * 新增数据
     *
     * @param label 实例对象
     * @return 影响行数
     */
    int insert(Label label);

    /**
     * 修改数据
     *
     * @param label 实例对象
     * @return 影响行数
     */
    int update(Label label);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询全部标签
     * @return
     */
    List<Label> selectAll();

}