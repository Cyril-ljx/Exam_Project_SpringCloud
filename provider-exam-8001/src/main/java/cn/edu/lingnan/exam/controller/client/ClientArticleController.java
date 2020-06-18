package cn.edu.lingnan.exam.controller.client;

import cn.edu.lingnan.exam.entity.Article;
import cn.edu.lingnan.exam.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 17:27 2020/6/16
 */
@Controller
@RequestMapping("article")
public class ClientArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 前台文章
     * @param page
     * @param limit
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String clientArticleList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit, Model model) {
        PageHelper.startPage(page, limit);
        List<Article> articles = articleService.selectClientAll();
        System.out.println(articles);
        PageInfo info = new PageInfo(articles);
        System.out.println(info);
        model.addAttribute("info", info);
        model.addAttribute("articleList", info.getList());
        System.out.println(info.getList());
        //共享数据
        return "client/html/article";
    }

    /**
     * 前台查看文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/get")
    public String clientArticleById(@RequestParam("id") int id, Model model) {
        Article article = articleService.selectByPrimaryKey(id);
        model.addAttribute("article", article);
        int index = 1;
        model.addAttribute("index", ++index);
        return "client/html/articleDetails";
    }

}
