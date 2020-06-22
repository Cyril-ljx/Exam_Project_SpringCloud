package cn.edu.lingnan.exam.controller;

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

@Controller
@RequestMapping("admin/pgtest")
public class PgtestController {

    @Resource
    private PgtestService pgtestService;




    /**
     * 列表查询
     * @param page
     * @param limit
     * @param keyword1
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ServerLayResult list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                @RequestParam(value = "keyword", defaultValue = "") String keyword1) {
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
