package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.CommonResult;
import cn.edu.lingnan.exam.entity.Topic;
import cn.edu.lingnan.exam.listener.TopicExcelListener;
import cn.edu.lingnan.exam.service.TopicService;
import com.alibaba.excel.EasyExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Topic)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:20:58
 */
@Controller
@RequestMapping("/feign/admin/topic")
public class TopicController {
    /**
     * 服务对象
     */
    @Resource
    private TopicService topicService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("topicView")
    public String topicView() {
    /*    if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }*/
        return "admin/topic/topicList";
    }

    /**
     * 题目列表显示和关键字查询
     *
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<Topic> list(@RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit, String keyword1) {
        return topicService.selectByKeyWord(page, limit, keyword1);
    }
    @ResponseBody
    @RequestMapping("/count")
    int count(){
        return topicService.count();
    }

    @RequestMapping("/topic/queryAll")
    @ResponseBody
    List<Topic> queryAll(@RequestParam(value = "limit")int page, @RequestParam(value = "limit")int limit){
        return topicService.selectAll(page,limit);
    }

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public boolean del(@RequestParam("id") Integer id) {
        return topicService.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param topic
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody Topic topic) {
        return topicService.updateByPrimaryKey(topic);
    }

    /**
     * 增加
     * @param topic
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/add")
    public boolean insert(@RequestBody Topic topic) {
        Map<String, Object> dataMap = new HashMap<>();
        return topicService.insert(topic);
    }

    @PostMapping("upload")
    @ResponseBody
    public Object upload(MultipartFile file) {
        CommonResult<String> result = new CommonResult<>();
        try {
            EasyExcel.read(file.getInputStream(), Topic.class, new TopicExcelListener(topicService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            result.setMsg("Excel上传出错");
        }
        result.setData(Collections.singletonList(file.getOriginalFilename()));
        return result;
    }
}