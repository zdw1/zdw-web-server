package com.zdw.snail.model;

import lombok.Data;

@Data
public class UserEntity {
    /**
     * id
     */
    private int id;
    /**
     * 姓名
     */
    private String loginName;
    /**
     * 登录名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
}
