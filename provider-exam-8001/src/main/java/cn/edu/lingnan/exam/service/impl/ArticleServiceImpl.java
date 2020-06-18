package cn.edu.lingnan.exam.service.impl;

import cn.edu.lingnan.exam.dao.ArticleDao;
import cn.edu.lingnan.exam.entity.Article;
import cn.edu.lingnan.exam.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2020-06-15 17:19:48
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Article queryById(Integer id) {
        return this.articleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Article> queryAllByLimit(int offset, int limit) {
        return this.articleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Article article) {
        if (article.getAuthor() != null && !"".equals(article.getAuthor())) {
            //创建时间和更新时间
            article.setCreateTime(new Date());
            try {
                int insert = articleDao.insert(article);
                if (insert > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加文章失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加文章失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文章作者不能为空！");
        }
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article update(Article article) {
        this.articleDao.update(article);
        return this.queryById(article.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleDao.deleteById(id) > 0;
    }

    /**
     * 查看全部文章
     * @return
     */
    @Override
    public List<Article> selectClientAll() {
        return articleDao.selectAll();
    }

    /**
     * 根据id查具体某篇文章
     * @param id
     * @return
     */
    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleDao.selectByPrimaryKey(id);
    }

    /**
     * 查询并实现分页
     * @param page
     * @param limit
     * @param keyword1
     * @param keyword2
     * @param keyword3
     * @return
     */
    @Override
    public List<Article> selectByKeyWord(int page, int limit, String keyword1, String keyword2, String keyword3) {
        //实现分页
        PageHelper.startPage(page, limit);
        List<Article> articles = articleDao.selectByKeyWord(keyword1, keyword2, keyword3);
        PageInfo info = new PageInfo(articles);
        return info.getList();
    }

    /**
     * 查询结果总数用于分页显示
     *
     * @return
     */
    @Override
    public int count() {
        return articleDao.count();
    }

    /**
     * 分页
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Article> selectAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Article> articles = articleDao.selectAll();
        PageInfo info = new PageInfo(articles);
        return info.getList();
    }

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        int del = articleDao.deleteByPrimaryKey(id);
        if (del > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Article article) {
        if (article.getAuthor() != null && !"".equals(article.getAuthor())) {
            //创建时间和更新时间
            article.setCreateTime(new Date());
            try {
                int update = articleDao.updateByPrimaryKey(article);
                if (update > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加文章失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加文章失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("文章作者不能为空！");
        }
    }

}