package cn.edu.lingnan.exam.entity;

import java.io.Serializable;

/**
 * (Label)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:19:57
 */
public class Label implements Serializable {
    /**
    *  文章标签id
    */
    private Integer id;
    /**
    * 文章标签名
    */
    private String labelName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

}