package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.common.ServerLayResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 12:29 2020/6/20
 */
@Component
@FeignClient(value = "provider-leacot")
public interface LeacotFeignService {

    @RequestMapping("/leacots/leacotsUi")
    @ResponseBody
    List clientArticleUi(@RequestParam(value = "page", defaultValue = "1") Integer page,
                         @RequestParam(value = "limit", defaultValue = "10") Integer limit);

    @ResponseBody
    @PostMapping(value = "/leacots/save")
    Map<String, Object> saveLeacot(@RequestBody JSONObject data);

//    @ResponseBody
//    @RequestMapping("/admin/leacots/list")
//    Object leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit, String keyword1);

    @ResponseBody
    @RequestMapping("/admin/leacots/list")
    List leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit, String keyword1);

    @RequestMapping("/count")
    @ResponseBody
    int count();

    @PostMapping("selectAll")//这里也是提交一个表单申请，所以也是用post请求
    @ResponseBody//返回的是数据
    Object selectAll(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit);

    @RequestMapping("/del")
    @ResponseBody
    Map<String, Object> del(@RequestParam("id") int id);


    @RequestMapping("/update")
    @ResponseBody
    Map<String, Object> update(@RequestBody JSONObject json);

}
