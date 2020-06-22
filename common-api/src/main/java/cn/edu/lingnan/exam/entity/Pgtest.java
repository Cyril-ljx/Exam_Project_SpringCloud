package cn.edu.lingnan.exam.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Pgtest)实体类
 *
 * @author makejava
 * @since 2020-06-19 11:56:04
 */
public class Pgtest implements Serializable {
    private static final long serialVersionUID = -88672932851879191L;
    /**
    * 评测ID
    */
    private Integer id;
    /**
    * 多选
    */
    private Integer checkScores;
    /**
    * 单选分数
    */
    private Integer radioScores;
    /**
    * 评测时间
    */
    private Date pgtestTime;
    /**
    * 评测用户
    */
    private String userOp;
    
    private Integer taotiid;
    /**
    * 总分
    */
    private Integer total;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckScores() {
        return checkScores;
    }

    public void setCheckScores(Integer checkScores) {
        this.checkScores = checkScores;
    }

    public Integer getRadioScores() {
        return radioScores;
    }

    public void setRadioScores(Integer radioScore) {
        this.radioScores = radioScore;
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

    public Integer getTaotiid() {
        return taotiid;
    }

    public void setTaotiid(Integer taotiid) {
        this.taotiid = taotiid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pgtest{" +
                "id=" + id +
                ", checkScores=" + checkScores +
                ", radioScores=" + radioScores +
                ", pgtestTime=" + pgtestTime +
                ", userOp='" + userOp + '\'' +
                ", taotiid=" + taotiid +
                ", total=" + total +
                '}';
    }
}