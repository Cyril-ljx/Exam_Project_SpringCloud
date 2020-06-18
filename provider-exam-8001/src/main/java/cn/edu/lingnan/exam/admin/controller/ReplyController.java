package cn.edu.lingnan.exam.admin.controller;

import cn.edu.lingnan.exam.entity.Reply;
import cn.edu.lingnan.exam.service.ReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Reply)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:20:46
 */
@RestController
@RequestMapping("reply")
public class ReplyController {
    /**
     * 服务对象
     */
    @Resource
    private ReplyService replyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Reply selectOne(Integer id) {
        return this.replyService.queryById(id);
    }

}