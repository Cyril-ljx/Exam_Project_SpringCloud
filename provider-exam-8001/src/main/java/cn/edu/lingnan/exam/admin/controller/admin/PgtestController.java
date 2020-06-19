package cn.edu.lingnan.exam.admin.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Pgtest;
import cn.edu.lingnan.exam.service.PgtestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Pgtest)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:20:32
 */
@Controller
@RequestMapping("admin/pgtest")
public class PgtestController {
    /**
     * 服务对象
     */
    @Resource
    private PgtestService pgtestService;

    @RequestMapping("/pgtestView")
    public String pgtestView() {
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }
        return "admin/topic/pgtestList";
    }

    /**
     * 列表查询，
     *
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ServerLayResult list(@RequestParam("page") int page, @RequestParam("limit") int limit, String keyword1) {
        if (keyword1 != null) {
            if (keyword1 != null && keyword1 != "") {
                List<Pgtest> pgTests = pgtestService.selectByKeyWord(page, limit, keyword1);
                ServerLayResult result = new ServerLayResult(0, "", pgTests.size(), pgTests);
                return result;
            }
        }
        ServerLayResult result = new ServerLayResult(0, "", pgtestService.count(), pgtestService.selectAll(page, limit));
        return result;
    }

    /**
     * 根据ID删除评测记录
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public Map<String, Object> del(@RequestParam("id") Integer id) {
        Map<String, Object> dataMap = new HashMap<>();
        boolean delete = pgtestService.deleteByPrimaryKey(id);
        dataMap.put("status", delete);
        return dataMap;
    }



}