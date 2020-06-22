package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Article;
import cn.edu.lingnan.exam.entity.Label;
import cn.edu.lingnan.exam.entity.Leacot;
import cn.edu.lingnan.exam.service.ArticleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:19:48
 */
@Controller
@RequestMapping("admin")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    @RequestMapping("/articleUi")
    public String articleListUi() {
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }
        return "admin/article/list";
    }

    /**
     * 后台查看文章列表
     * @param page 当前页
     * @param limit 每页条数
     * @param keyword1 关键字查询1
     * @param keyword2 关键字查询2
     * @param keyword3 关键字查询3
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/article/list")
//    public ServerLayResult<Article> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                         @RequestParam(value = "limit", defaultValue = "10") Integer limit,
//                                         String keyword1, String keyword2, String keyword3) {
//        if (keyword1 != null && keyword2 != "" || keyword2 != null && keyword2 != "" || keyword3 != null && keyword3 != "") {
//            List<Article> articles = articleService.selectByKeyWord(page, limit, keyword1, keyword2, keyword3);
//            ServerLayResult result = new ServerLayResult(0, "", articles.size(), articles);
//            return result;
//        }
//        //封装数据
//        ServerLayResult result = new ServerLayResult(0, "", articleService.count(), articleService.selectAll(page, limit));
//        return result;
//    }

    @ResponseBody
    @RequestMapping("/article/list")
    public List<Article> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                              @RequestParam(value = "keyword1") String keyword1,
                              @RequestParam(value = "keyword2") String keyword2,
                              @RequestParam(value = "keyword2") String keyword3) {

        List<Article> articles = articleService.selectByKeyWord(page, limit, keyword1, keyword2, keyword3);
        System.out.println(articles);
//            ServerLayResult result = new ServerLayResult(0, "", leacots.size(), leacots);
        return articles;
//        ServerLayResult result = new ServerLayResult(0, "", leacotService
//                .count(), leacotService.selectAll(page, limit));
//        return result;
    }


    @RequestMapping("/count")
    @ResponseBody
    public int count(){
        return articleService.count();
    }

    @PostMapping("selectAll")//这里也是提交一个表单申请，所以也是用post请求
    @ResponseBody//返回的是数据
    public Object selectAll(Integer page, Integer limit){
        return articleService.selectAll(page,limit);
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/del")
    public Map<String, Object> delArticle(@RequestParam("id") int id) {
        Map<String, Object> dataMap = new HashMap<>();
        boolean isSuccess = articleService.deleteByPrimaryKey(id);
        dataMap.put("success", isSuccess);
        return dataMap;
    }

//  去到添加页面
    @RequestMapping("/articleUiAdd")
    public String articleAddUi() {
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }
        return "admin/article/listform";
    }

    /**
     * 前台响应json数据
     * 解析保存
     *
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/add")
    public Map<String, Object> addArticle(@RequestBody JSONObject article) {
        JSONObject json = JSON.parseObject(article.toJSONString());
        String author = json.getString("author");
        Integer label = json.getInteger("label");
        String title = json.getString("title");
        String content = json.getString("content");
        String status = json.getString("status");
        int temp = 0;
        if (status != null) {
            if (status.equals("on")) {
                temp = 1;
            }
        }
        Label label1 = new Label();
        label1.setId(label);
        Article articles = new Article();
        articles.setAuthor(author);
        articles.setContent(content);
        articles.setTitle(title);
        articles.setStatus(temp);
        articles.setCreateTime(new Date());
        articles.setLabel(label1);
        logger.info(article + "");
        boolean isSuccess = articleService.insert(articles);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("success", isSuccess);
        return dataMap;
    }

    /**
     * 根据前台响应的json对象封装后通过业务方法保存到数据库
     *
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/update")
    public Map<String, Object> updateArticle(@RequestBody JSONObject article) {
        JSONObject json = JSON.parseObject(article.toJSONString());
        String author = json.getString("author");
        Integer label = json.getInteger("label");
        Integer id = json.getInteger("id");
        String title = json.getString("title");
        String content = json.getString("content");
        String status = json.getString("status");
        int temp = 0;
        if (status != null) {
            if (status.equals("on")) {
                temp = 1;
            }
        }
        Label label1 = new Label();
        label1.setId(label);
        Article articles = new Article();
        articles.setId(id);
        articles.setAuthor(author);
        articles.setContent(content);
        articles.setTitle(title);
        articles.setStatus(temp);
        articles.setCreateTime(new Date());
        articles.setLabel(label1);
        logger.info(article + "");
        boolean isSuccess = articleService.updateByPrimaryKey(articles);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("success", isSuccess);
        return dataMap;
    }


}