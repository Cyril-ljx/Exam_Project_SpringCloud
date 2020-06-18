package cn.edu.lingnan.exam.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Leacot)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:20:06
 */
public class Leacot implements Serializable {
    private static final long serialVersionUID = -31130807183104546L;
    /**
    * 留言ID
    */
    private Integer id;
    /**
    * 留言内容
    */
    private String content;
    /**
    * 留言时间
    */
    private Date leacotsTime;
    /**
    * 留言用户
    */
    private String leacotsUser;
    /**
    * 关联回复内容
    */
    private Reply replyId;
    /**
    * 回复状态
    */
    private Integer status;

    public Leacot() {
    }

    public Leacot(Integer id, String content, Date leacotsTime, String leacotsUser, Reply replyId, Integer status) {
        this.id = id;
        this.content = content;
        this.leacotsTime = leacotsTime;
        this.leacotsUser = leacotsUser;
        this.replyId = replyId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLeacotsTime() {
        return leacotsTime;
    }

    public void setLeacotsTime(Date leacotsTime) {
        this.leacotsTime = leacotsTime;
    }

    public String getLeacotsUser() {
        return leacotsUser;
    }

    public void setLeacotsUser(String leacotsUser) {
        this.leacotsUser = leacotsUser;
    }

    public Reply getReplyId() {
        return replyId;
    }

    public void setReplyId(Reply replyId) {
        this.replyId = replyId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}