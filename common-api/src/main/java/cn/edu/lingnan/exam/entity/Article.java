package cn.edu.lingnan.exam.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:19:46
 */
public class Article implements Serializable {
    /**
    * 文章ID
    */
    private Integer id;
    /**
    * 文章标签
    */
//    private Integer label;
    private Label label;
    /**
    * 文章标题
    */
    private String title;
    /**
    * 文章内容
    */
    private String content;
    /**
    * 文章作者
    */
    private String author;
    /**
    * 文章发布状态
    */
    private Integer status;
    /**
    * 文章发布时间
    */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getLabel() {
//        return label;
//    }
//
//    public void setLabel(Integer label) {
//        this.label = label;
//    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}