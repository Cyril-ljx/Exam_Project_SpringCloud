package cn.edu.lingnan.exam.controller.client;

import cn.edu.lingnan.exam.entity.Notice;
import cn.edu.lingnan.exam.service.LoginFeignService;
import cn.edu.lingnan.exam.service.NoticeFeignService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("feign")
public class ConsumerClientNoticeController {

//    @Autowired
//    private NoticeService noticeService;
      @Autowired
       private NoticeFeignService noticeFeignService;

    @RequestMapping("noticeClientUi/list")
    public String clientNotice(@RequestParam(value = "page",defaultValue = "1") Integer page,
                               @RequestParam(value = "limit",defaultValue = "10") Integer limit,Model model){

       List<Notice> notices=noticeFeignService.clientNotice(page,limit);
        System.out.println(notices);
        PageInfo infoNotice=new PageInfo(notices);
        model.addAttribute("infoNotice",infoNotice);
        model.addAttribute("noticeList",infoNotice.getList());
        return "client/html/notice";

    }
    @RequestMapping("/noticeClientUi/get")
    public String clientNoticeByGet(@RequestParam("id") int id, Model model){
        Notice notice=noticeFeignService.clientNoticeByGet(id);
        int index=id-1;
        if(index==0)index=1;
        model.addAttribute("notice",notice);
        model.addAttribute("id",++id);
        model.addAttribute("index",index);
        return "client/html/noticeDetails";
    }

}
