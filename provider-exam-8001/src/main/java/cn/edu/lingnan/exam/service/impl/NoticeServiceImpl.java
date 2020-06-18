package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.dao.NoticeDao;
import cn.edu.lingnan.exam.entity.Notice;
import cn.edu.lingnan.exam.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:20:21
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer id) {
        return this.noticeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Notice> queryAllByLimit(int offset, int limit) {
        return this.noticeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param record 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Notice record) {
        //更新时间
        record.setCreateTime(new Date());
        //从session中获取

        record.setUserOp("admin");

        try {
            int insert=noticeDao.insert(record);
            if(insert>0){
                return true;
            }else{
                throw new RuntimeException("公告添加失败！");
            }
        }catch (Exception e){
            throw new RuntimeException("公告添加失败"+e.getMessage());
        }
    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public boolean update(Notice record) {
       record.setCreateTime(new Date());
       //从session获取
       record.setUserOp(LoginSession.getCurrentUser().getUsername());
        try {
            //添加
            int insert = noticeDao.update(record);
            if (insert > 0) {
                return true;
            } else {
                throw new RuntimeException("公告更新失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("公告更新失败！" + e.getMessage());
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
        return this.noticeDao.deleteById(id) > 0;
    }

    @Override
    public List<Notice> queryAll(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Notice> notices=noticeDao.queryAll();
        PageInfo info=new PageInfo(notices);

        return info.getList();
    }

    @Override
    public List<Notice> selectAllClientNotice() {
        return noticeDao.queryAll();
    }

    @Override
    public Notice selectByPrimerKey(Integer id) {
        return noticeDao.queryById(id);
    }

    @Override
    public int count() {
        return noticeDao.count();
    }

    /**
     * 高级查询
     *
     * @param page
     * @param limit
     * @param keyword1
     * @param keyword2
     * @return
     */
    @Override
    public List<Notice> selectByKeyWord(int page, int limit, String keyword1, String keyword2) {
        PageHelper.startPage(page, limit);
        List<Notice> notices = noticeDao.selectByKeyWord(keyword1,keyword2);
        PageInfo info = new PageInfo(notices);
        return info.getList();
    }
}