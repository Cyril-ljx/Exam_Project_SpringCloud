package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Notice;
import cn.edu.lingnan.exam.entity.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "provider-topic")
public interface TopicFeignService {

    @RequestMapping("list")
    List<Topic> list(@RequestParam(value = "page") Integer page,
                      @RequestParam(value = "limit") Integer limit,
                      @RequestParam("keyword1") String keyword1);
    @RequestMapping("/topic/queryAll")

    List<Topic> selectAll(@RequestParam(value = "limit")int page, @RequestParam(value = "limit")int limit);
    @RequestMapping("/count")
    int count();

    @RequestMapping("admin/topic/save")
    boolean saveNotice(@SpringQueryMap Topic topic);

    @RequestMapping("/del")
    boolean del(@RequestParam("id") Integer id);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(@RequestBody Topic topic);

    @PostMapping(value = "/add")
    public boolean insert(@RequestBody Topic topic);

    @PostMapping("upload")
    public Object upload(@RequestPart(value = "file") MultipartFile file);

}
