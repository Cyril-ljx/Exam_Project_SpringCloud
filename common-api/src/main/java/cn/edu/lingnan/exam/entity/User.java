package cn.edu.lingnan.exam.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-06-15 17:21:06
 */
public class User implements Serializable {
    private static final long serialVersionUID = 329125029044442635L;
    private Integer id;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", vercode='" + vercode + '\'' +
                ", phone='" + phone + '\'' +
                ", userType='" + userType + '\'' +
                ", tocheck=" + tocheck +
                '}';
    }

    public User(Integer id, String username, String password, String email, String name, String address, String vercode, String phone, String userType, Integer tocheck) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.vercode = vercode;
        this.phone = phone;
        this.userType = userType;
        this.tocheck = tocheck;
    }

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

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getTocheck() {
        return tocheck;
    }

    public void setTocheck(Integer tocheck) {
        this.tocheck = tocheck;
    }

}