package cn.edu.lingnan.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Topic)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:20:58
 */
public class Topic implements Serializable {
    /**
    * 题目ID
    */
    private Integer id;
    /**
    * 题目内容
    */
    private String  topicContent;
    /**
    * 题目参考答案
    */
    private String referAnswer;
    /**
    * 题目创建时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date topicTime;
    /**
    * 题目操作用户
    */
    private String userOp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getReferAnswer() {
        return referAnswer;
    }

    public void setReferAnswer(String referAnswer) {
        this.referAnswer = referAnswer;
    }

    public Date getTopicTime() {
        return topicTime;
    }

    public void setTopicTime(Date topicTime) {
        this.topicTime = topicTime;
    }

    public String getUserOp() {
        return userOp;
    }

    public void setUserOp(String userOp) {
        this.userOp = userOp;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topicContent='" + topicContent + '\'' +
                ", referAnswer='" + referAnswer + '\'' +
                ", topicTime=" + topicTime +
                ", userOp='" + userOp + '\'' +
                '}';
    }
}