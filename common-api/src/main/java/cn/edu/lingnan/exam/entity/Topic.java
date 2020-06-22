package cn.edu.lingnan.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Topic)实体类
 *
 * @author makejava
 * @since 2020-06-18 20:59:31
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = -83185737920202407L;
    /**
    * 题目ID
    */
    private Integer id;
    /**
    * 题目内容
    */
    private String topicContent;

    private String labelName;

    public String getLabelName() {
        return labelName;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topicContent='" + topicContent + '\'' +
                ", labelName='" + labelName + '\'' +
                ", referAnswer='" + referAnswer + '\'' +
                ", topicTime=" + topicTime +
                ", userOp='" + userOp + '\'' +
                ", taotiid=" + taotiid +
                ", optiona='" + optiona + '\'' +
                ", optionb='" + optionb + '\'' +
                ", optionc='" + optionc + '\'' +
                ", optiond='" + optiond + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

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
    /**
    * 什么类型的题目
    */
    private Integer taotiid;
    /**
    * A选项
    */
    private String optiona;
    /**
    * b
    */
    private String optionb;
    
    private String optionc;
    /**
    * d
    */
    private String optiond;
    /**
    * 单选还是多选
    */
    private String type;


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

    public Integer getTaotiid() {
        return taotiid;
    }

    public void setTaotiid(Integer taotiid) {
        this.taotiid = taotiid;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}