package cn.edu.lingnan.exam.controller.admin;


import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Article;
import cn.edu.lingnan.exam.service.ArticleFeignService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 22:15 2020/6/20
 */
@Controller
@RequestMapping("feign")
public class ArticleController {

    @Autowired
    private ArticleFeignService articleFeignService;

    @RequestMapping("/articleUi")
    public String articleListUi() {
        return "admin/article/list";
    }

//    @ResponseBody
//    @RequestMapping("/article/list")
//    public Object list(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                         @RequestParam(value = "limit", defaultValue = "10") Integer limit){
//        return articleFeignService.list(page, limit);
//
//    }

//    @RequestMapping("/article/list")
//    @ResponseBody
//    public ServerLayResult leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
//                                       @RequestParam(value = "keyword1") String keyword1,
//                                       @RequestParam(value = "keyword2") String keyword2,
//                                       @RequestParam(value = "keyword3") String keyword3){
//
//        if (keyword1 != null){
//            List<Article> articles = articleFeignService.list(page,limit,keyword1,keyword2,keyword3);
//
//            ServerLayResult result = new ServerLayResult(0, "", articles.size(), articles);
//            return result;
//        }
//        ServerLayResult result = new ServerLayResult(0, "", articleFeignService.count(), articleFeignService.selectAll(page,limit));
//        return result;
//    }


    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/del")
    public Map<String, Object> delArticle(@RequestParam("id") int id) {
        return articleFeignService.delArticle(id);
    }

    //  去到添加页面
    @RequestMapping("/articleUiAdd")
    public String articleAddUi() {
        return "admin/article/listform";
    }

//    这里的实现是需要写lebal标签的
    @ResponseBody
    @RequestMapping("/article/add")
    public Map<String, Object> addArticle(@RequestBody JSONObject article){
        return articleFeignService.addArticle(article);
    }

    @ResponseBody
    @RequestMapping("/article/update")
    public Map<String, Object> updateArticle(@RequestBody JSONObject article){
        return articleFeignService.updateArticle(article);
    }

}
