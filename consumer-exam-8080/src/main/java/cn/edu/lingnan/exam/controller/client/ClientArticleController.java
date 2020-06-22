package cn.edu.lingnan.exam.controller.client;

import cn.edu.lingnan.exam.entity.Article;
import cn.edu.lingnan.exam.service.ArticleFeignService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 21:20 2020/6/20
 */
@Controller
@RequestMapping("feign")
public class ClientArticleController {

    @Autowired
    private ArticleFeignService articleFeignService;

    @RequestMapping("/article/list")
    public String leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "limit", defaultValue = "10") Integer limit, Model model) {

        System.out.println("dasdasdasdasd");

        List<Article> articles = articleFeignService.clientArticleList(page, limit);
        System.out.println("你好");
        System.out.println(articles);
        PageInfo info = new PageInfo(articles);
        System.out.println(info);
        model.addAttribute("info", info);
        model.addAttribute("articleList", info.getList());
        System.out.println(info.getList());
        //共享数据
        return "client/html/article";
    }

    @RequestMapping("/get")
    public String clientArticleById(@RequestParam("id") int id,Model model){
        Article article = articleFeignService.clientArticleById(id);
        model.addAttribute("article", article);
        int index = 1;
        model.addAttribute("index", ++index);
        return "client/html/articleDetails";
    }

}
