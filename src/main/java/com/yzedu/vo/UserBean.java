package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-21.
 * 用户信息的模型类
 */
@Data
public class UserBean {
    
	private int user_id;          // user_id
    private String user_avatar;    // 用户头像
    private String user_phone;          // 用户手机号
    private String user_sex;            // 用户性别
    private int user_age;               // 年龄
    
 

}
