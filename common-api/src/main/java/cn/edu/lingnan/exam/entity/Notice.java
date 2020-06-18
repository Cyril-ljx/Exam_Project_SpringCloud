package cn.edu.lingnan.exam.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:20:21
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 378119957393711993L;
    /**
    * 公告ID
    */
    private Integer id;
    /**
    * 公告标题
    */
    private String title;
    /**
    * 公告内容
    */
    private String content;
    /**
    * 公告创建时间
    */
    private Date createTime;
    /**
    * 操作用户
    */
    private String userOp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserOp() {
        return userOp;
    }

    public void setUserOp(String userOp) {
        this.userOp = userOp;
    }

}