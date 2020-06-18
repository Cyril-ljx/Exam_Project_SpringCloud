package cn.edu.lingnan.exam.dao;

import cn.edu.lingnan.exam.entity.Leacot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Leacot)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 17:20:06
 */
@Mapper
@Repository
public interface LeacotDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Leacot queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Leacot> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param leacot 实例对象
     * @return 对象列表
     */
    List<Leacot> queryAll(Leacot leacot);

    /**
     * 新增数据
     *
     * @param leacot 实例对象
     * @return 影响行数
     */
    int insert(Leacot leacot);

    /**
     * 修改数据
     *
     * @param leacot 实例对象
     * @return 影响行数
     */
    int update(Leacot leacot);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Leacot> selectAll();

    /**
     * 通过关键字并进行分页显示
     * @param keyword1
     * @return
     */
    List<Leacot> selectByKeyWord(String keyword1);

    int count();

    /**
     * 根据id查看留言
     * @param id
     * @return
     */
    Leacot selectByPrimaryKey(Integer id);

    /**
     * 根据id删除留言
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Leacot record);
}