package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 18-4-9.
 * 教师用户信息的模型类
 */
@Data
public class TeacherBean {
	private int user_id;                // 用户id
    private String user_phone;          // 教师绑定用户手机号
    private String user_sex;            // 用户性别
    private int user_age;               // 年龄
    private String user_avatar;         // 用户头像
    
    private String teacher_id;          // 教师id
    private String teacher_name;        // 教师姓名
    private String teacher_number;		// 教师工号
    
    private int school_id;					// 学校id
    private String school_name;		// 学校名称

}
