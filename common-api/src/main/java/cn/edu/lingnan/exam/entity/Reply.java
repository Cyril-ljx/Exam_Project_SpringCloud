package cn.edu.lingnan.exam.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Reply)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:20:46
 */
public class Reply implements Serializable {
    private static final long serialVersionUID = -33694326505342524L;
    /**
    * 回复ID
    */
    private Integer id;
    /**
    * 回复内容
    */
    private String replyContent;
    /**
    * 回复时间
    */
    private Date replyTime;
    /**
    * 回复用户
    */
    private String replyUser;

    public Reply() {
    }

    public Reply(Integer id, String replyContent, Date replyTime, String replyUser) {
        this.id = id;
        this.replyContent = replyContent;
        this.replyTime = replyTime;
        this.replyUser = replyUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }

}