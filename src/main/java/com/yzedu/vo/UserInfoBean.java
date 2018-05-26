package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-21.
 * 用户详细信息的模型类
 */
@Data
public class UserInfoBean {
    
	private int user_id;          // user_id
    private String user_avatar;    // 用户头像
    
    private int school_id;	// 绑定学校id，没有绑定为null
    
    private String student_name;	// 如果绑定学生则对应学生姓名，否则为user_phone的值
    private int student_id;	// 学生id
    
    private String teacher_name;	//如果绑定教师则对应教师姓名，否则为user_phone的值
    private int teacher_id;	// 教师id
    
    private int user_type;	//	用户类型,1为学生，2为教师

}
