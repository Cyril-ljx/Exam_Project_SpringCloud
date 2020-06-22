package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Notice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "provider-notice")
public interface NoticeFeignService {
    @RequestMapping("/noticeClientUi/list")
     List<Notice> clientNotice(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "limit",defaultValue = "10") Integer limit);

     @RequestMapping("/admin/notice/list")
     List<Notice> list(@RequestParam(value = "page") Integer page,
                                        @RequestParam(value = "limit") Integer limit,
                                        @RequestParam("keyword1") String keyword1, @RequestParam("keyword2") String keyword2);
    @RequestMapping("/noticeClientUi/get")
     Notice clientNoticeByGet(@RequestParam("id") int id);

    @RequestMapping("/noticeClientUi/queryAll")
    List<Notice> queryAll(@RequestParam(value = "limit")int page, @RequestParam(value = "limit")int limit);
    @RequestMapping("/noticeClientUi/count")
    int count();

    @RequestMapping("admin/notice/save")
     boolean saveNotice(@SpringQueryMap Notice notice);

    @RequestMapping("admin/notice/del")
    boolean delNotice(@RequestParam("id") int id);

    @RequestMapping("/admin/notice/update")
    public  boolean updaNotice(@RequestBody Notice notice);
}
