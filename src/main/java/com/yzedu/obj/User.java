package com.yzedu.obj;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangbenben on 2018/5/27 0027
 */
@Data
public class User {

    private Integer user_id;

    private String user_account;

    private String user_password;

    private String user_phone;

    private String user_sex;

    private Integer user_age;

    private  String user_avatar;

    private Date gmt_create;

    private Date gmt_modified;

    public User(String user_account, String user_password, String user_phone, String user_sex, Integer user_age) {
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_sex = user_sex;
        this.user_age = user_age;
    }

    public User(Integer user_id, String user_phone, String user_sex, Integer user_age) {
        this.user_id = user_id;
        this.user_phone = user_phone;
        this.user_sex = user_sex;
        this.user_age = user_age;
    }

    public User(Integer user_id, String user_avatar) {
        this.user_id = user_id;
        this.user_avatar = user_avatar;
    }

    public User(){
        super();
    }
}
