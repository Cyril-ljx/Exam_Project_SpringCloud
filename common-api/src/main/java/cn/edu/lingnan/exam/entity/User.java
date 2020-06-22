package cn.edu.lingnan.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:21:06
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private Integer id;

    private String username;
    
    private String password;
    
    private String email;
    
    private String name;
    
    private String address;

    private String vercode;
    
    private String phone;
    /**
    * 用户类型名
    */
    private String userType;
    /**
    * 用户类型
    */
    private Integer tocheck;


}