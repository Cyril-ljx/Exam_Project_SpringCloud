package cn.edu.lingnan.exam.dao;

import cn.edu.lingnan.exam.entity.Pgtest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Pgtest)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 17:20:32
 */
@Mapper
@Repository
public interface PgtestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Pgtest queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Pgtest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pgtest 实例对象
     * @return 对象列表
     */
    List<Pgtest> queryAll(Pgtest pgtest);

    /**
     * 新增数据
     *
     * @param pgtest 实例对象
     * @return 影响行数
     */
    int insert(Pgtest pgtest);

    /**
     * 修改数据
     *
     * @param pgtest 实例对象
     * @return 影响行数
     */
    int update(Pgtest pgtest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Pgtest> selectAllByKeyWord(String keyword1);

    int count();

    /**
     * 查询全部
     * @return
     */
    List<Pgtest> selectAll();

    int deleteByPrimaryKey(Integer id);

}