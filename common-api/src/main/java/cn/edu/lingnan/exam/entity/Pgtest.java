package cn.edu.lingnan.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Pgtest)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:20:32
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Pgtest implements Serializable {
    private static final long serialVersionUID = 668532436819004649L;
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



}