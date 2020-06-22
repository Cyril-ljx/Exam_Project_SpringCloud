package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Notice;
import cn.edu.lingnan.exam.service.NoticeFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("feign")
public class ConsumerNoticeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NoticeFeignService noticeFeignService;

    @RequestMapping("noticeUi")
    public String noticeListUi() {/*
        if(!LoginSession.getCurrentUser().getTocheck().equals(1)){
            return "client/html/index";
        }*/
        return "admin/notice/noticeList";
    }

    @RequestMapping("noticeUiAdd")
    public String articleAddUi() {
       /* if(!LoginSession.getCurrentUser().getTocheck().equals(1)){
            return "client/html/index";
        }*/
        return "admin/notice/noticeAdd";
    }

        @RequestMapping("admin/notice/save")
        @ResponseBody
        public Map<String,Object> saveNotice(@SpringQueryMap Notice notice){
            Map<String,Object> dataMap=new HashMap<>();
            boolean isSuccess=noticeFeignService.saveNotice(notice);
            dataMap.put("success",isSuccess);
            return dataMap;
        }

        @RequestMapping("admin/notice/del")
        @ResponseBody
        public Map<String,Object> delNotice(@RequestParam("id") int id){
            Map<String,Object> dataMap=new HashMap<>();
            boolean isSuccess=noticeFeignService.delNotice(id);
            dataMap.put("success",isSuccess);
            return dataMap;
        }

        @RequestMapping("/admin/notice/update")
        @ResponseBody
        public  Map<String,Object> updaNotice(@RequestBody Notice notice){
            Map<String,Object> dataMap=new HashMap<>();
            boolean isSuccess=noticeFeignService.updaNotice(notice);
            dataMap.put("success",isSuccess);
            return dataMap;
        }

    @RequestMapping("/admin/notice/list")
    @ResponseBody
    public ServerLayResult<Notice> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        String keyword1, String keyword2){
        System.out.println(111);
        logger.info("" + keyword1 + "---->" + keyword2);
        if(keyword1!=null&&keyword1!=""||keyword2!=null&&keyword2!=""){
            List<Notice> notices= noticeFeignService.list(page,limit,keyword1,keyword2);
            System.out.println(notices);
            ServerLayResult result= new ServerLayResult(0,"",notices.size(),notices);
            System.out.println(result);
            return result;
        }
        ServerLayResult result=new ServerLayResult(0,"",noticeFeignService.count(),noticeFeignService.queryAll(page,limit));
        System.out.println(result);
        return result;
    }
}