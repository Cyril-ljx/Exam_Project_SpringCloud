package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Notice;
import cn.edu.lingnan.exam.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class NoticeController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticeUi")
    public String noticeListUi(){
   /*     if(!LoginSession.getCurrentUser().getTocheck().equals(1)){
            return "client/html/index";
        }*/
        return "admin/notice/noticeList";
    }

    @RequestMapping("/noticeUiAdd")
    public String articleAddUi(){
      /*  if(!LoginSession.getCurrentUser().getTocheck().equals(1)){
            return "client/html/index";
        }*/
        return "admin/notice/noticeAdd";
        }

        @RequestMapping("/admin/notice/save")
        @ResponseBody
        public boolean saveNotice(@RequestBody Notice notice){
            return noticeService.insert(notice);

        }

        @RequestMapping("/admin/notice/del")
        @ResponseBody
        public boolean delNotice(@RequestParam("id") int id){
            return noticeService.deleteById(id);
        }

        @RequestMapping("/admin/notice/update")
        @ResponseBody
        public  boolean updaNotice(@RequestBody Notice notice){
          return noticeService.update(notice);
        }

        @RequestMapping("/admin/notice/list")
        @ResponseBody
        public  List<Notice> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                             String keyword1, String keyword2){

                return noticeService.selectByKeyWord(page,limit,keyword1,keyword2);

            }
    @RequestMapping("/noticeClientUi/queryAll")
    @ResponseBody
    List<Notice> queryAll(@RequestParam(value = "page")int page, @RequestParam(value = "limit") int limit){
            return noticeService.queryAll(page,limit);
    }
    @RequestMapping("/noticeClientUi/count")
    @ResponseBody
    int count(){
            return noticeService.count();
    }
    }