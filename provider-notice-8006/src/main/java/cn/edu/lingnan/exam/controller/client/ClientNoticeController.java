package cn.edu.lingnan.exam.controller.client;

import cn.edu.lingnan.exam.entity.Notice;
import cn.edu.lingnan.exam.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClientNoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticeClientUi/list")
    @ResponseBody
    public List<Notice> clientNotice(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10") Integer limit, Model model){
        PageHelper.startPage(page,limit);
        System.out.println(222);
        List<Notice> notices=noticeService.selectAllClientNotice();

        //共享数据
        return notices;

    }
    @RequestMapping("/noticeClientUi/get")
    @ResponseBody
    public Notice clientNoticeByGet(@RequestParam("id") int id, Model model){
        Notice notice=noticeService.selectByPrimerKey(id);
       return notice;
    }

}
