package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Leacot;
import cn.edu.lingnan.exam.entity.Reply;
import cn.edu.lingnan.exam.service.LeacotService;
import cn.edu.lingnan.exam.service.ReplyService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 19:14 2020/6/17
 */
@Controller
@RequestMapping("admin/leacots")
public class LeacotController {

    @Autowired
    private LeacotService leacotService;

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/leacotsView")
    public String leacotUi() {
//       如果用户不是admin无法查看
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }
        return "admin/leacots/leacotsList";
    }

    /**
     * 用户留言列表 分页显示
     *
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ServerLayResult leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit, String keyword1) {
        if (keyword1 != null) {
            List<Leacot> leacots = leacotService.selectByKeyWord(page, limit, keyword1);

            ServerLayResult result = new ServerLayResult(0, "", leacots.size(), leacots);
            return result;
        }
        ServerLayResult result = new ServerLayResult(0, "", leacotService
                .count(), leacotService.selectAll(page, limit));
        return result;
    }

//    @ResponseBody
//    @RequestMapping("/list")
//    public List<Leacot> leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit, String keyword1) {
//
//            List<Leacot> leacots = leacotService.selectByKeyWord(page, limit, keyword1);
//            System.out.println(leacots);
////            ServerLayResult result = new ServerLayResult(0, "", leacots.size(), leacots);
//            return leacots;
////        ServerLayResult result = new ServerLayResult(0, "", leacotService
////                .count(), leacotService.selectAll(page, limit));
////        return result;
//    }

    @RequestMapping("/count")
    @ResponseBody
    public int count(){
        return leacotService.count();
    }

    @PostMapping("selectAll")//这里也是提交一个表单申请，所以也是用post请求
    @ResponseBody//返回的是数据
    public Object selectAll(Integer page, Integer limit){

        return leacotService.selectAll(page,limit);
    }

    /**
     * 根据ID删除 并且删除关联
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public Map<String, Object> del(@RequestParam("id") int id) {
        Map<String, Object> dataMap = new HashMap<>();
        boolean isSuccess = false;
//      先找到具体留言
        Leacot leacot = leacotService.selectByPrimaryKey(id);
        //删除关联
        if (leacot != null) {
            //先删除回复
            boolean delReply = replyService.deleteByPrimaryKey(leacot.getId());
            if (delReply) {
//              再删除留言
                boolean delete = leacotService.deleteByPrimaryKey(id);
                isSuccess = true;
                dataMap.put("success", isSuccess);
                return dataMap;
            }
        }
        dataMap.put("success", isSuccess);
        return dataMap;
    }

    /**
     * 修改留言内容
     *
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestBody JSONObject json) {
        Map<String, Object> dataMap = new HashMap<>();
        boolean isSuccess = false;
        JSONObject data = JSON.parseObject(json.toJSONString());
        Integer id = data.getInteger("id");
        String leacotsUser = data.getString("leacotsUser");
        String content = data.getString("content");
        //回复内容
        String replyContent = data.getString("replyContent");
        //回复状态
        String status = data.getString("status");
        int temp = 0;
        if (status != null) {
            if (status.equals("on")) {
                temp = 1;
            }
        }

        //默认从session获得replyUser
//        实体类需要有惨构造数
        Reply reply = new Reply(id, replyContent, new Date(), "admin");
        //更新回复表
        boolean updateReply = replyService.updateByPrimaryKey(reply);
        Leacot leacot = new Leacot(id, content, new Date(), leacotsUser, reply, temp);
        //更新留言表
        boolean updateLeacot = leacotService.updateByPrimaryKey(leacot);
        if (updateLeacot && updateReply) {
            isSuccess = true;
            dataMap.put("success", isSuccess);
            return dataMap;
        }

        dataMap.put("success", isSuccess);
        return dataMap;
    }

}
