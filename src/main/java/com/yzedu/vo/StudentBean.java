package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 18-4-9.
 * 学生用户信息的模型类
 */
@Data
public class StudentBean{
    private int user_id;                // 用户id
    private String user_phone;          // 学生绑定用户手机号
    private String user_sex;            // 用户性别
    private int user_age;               // 年龄
    private String user_avatar;         // 用户头像
    
    private String student_id;          // 学生id
    private String student_name;        // 学生姓名
    private String student_number;		// 学生学号
    
    private int school_id;					// 学校id
    private String school_name;		// 学校名称
    
}
