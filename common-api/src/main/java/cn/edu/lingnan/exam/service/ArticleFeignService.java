package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Article;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 21:20 2020/6/20
 */
@Component
@FeignClient(value = "provider-article")
public interface ArticleFeignService {

    @ResponseBody
    @RequestMapping("/article/list")
    List clientArticleList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                     @RequestParam(value = "limit", defaultValue = "10") Integer limit);

    @RequestMapping("/article/get")
    @ResponseBody
    Article clientArticleById(@RequestParam("id") int id);


//    @ResponseBody
//    @RequestMapping("/admin/article/list")
//    List list(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                     @RequestParam(value = "limit", defaultValue = "10") Integer limit,
//                                     String keyword1, String keyword2, String keyword3);
//    @RequestMapping("/count")
//    @ResponseBody
//    int count();
//
//    @PostMapping("selectAll")//这里也是提交一个表单申请，所以也是用post请求
//    @ResponseBody//返回的是数据
//    Object selectAll(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit);


    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/article/del")
    Map<String, Object> delArticle(@RequestParam("id") int id);

    /**
     * 添加
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/article/add")
    Map<String, Object> addArticle(@RequestBody JSONObject article);

    /**
     * 更新
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping("/article/update")
    Map<String, Object> updateArticle(@RequestBody JSONObject article);


    }
