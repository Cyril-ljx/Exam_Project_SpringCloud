package cn.edu.lingnan.exam.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Pgtest)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:20:32
 */
public class Pgtest implements Serializable {
    private static final long serialVersionUID = 668532436819004649L;
    /**
    * 评测ID
    */
    private Integer id;
    /**
    * 评测结果
    */
    private String pgtestResult;
    /**
    * 评测分数
    */
    private Integer pgtestScore;
    /**
    * 评测时间
    */
    private Date pgtestTime;
    /**
    * 评测用户
    */
    private String userOp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPgtestResult() {
        return pgtestResult;
    }

    public void setPgtestResult(String pgtestResult) {
        this.pgtestResult = pgtestResult;
    }

    public Integer getPgtestScore() {
        return pgtestScore;
    }

    public void setPgtestScore(Integer pgtestScore) {
        this.pgtestScore = pgtestScore;
    }

    public Date getPgtestTime() {
        return pgtestTime;
    }

    public void setPgtestTime(Date pgtestTime) {
        this.pgtestTime = pgtestTime;
    }

    public String getUserOp() {
        return userOp;
    }

    public void setUserOp(String userOp) {
        this.userOp = userOp;
    }

}