package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 我的课程列表的模型类
 */
@Data
public class MyCourseBean {
	
	private int course_id;	// 课程id
	// 通过course_id找到course表中的数据,可以直接封装为一个VO类
    private String course_name;         // 课程名称
    private int course_sum_student;     // 课程容量人数
    private int course_learn_student;   // 课程学习人数
    private String course_cover;        // 课程封面途径
    private int course_sum;             // 总课时
    private double course_price;        // 课程价格(数据库中设置的是decimal格式)
	
    private int learn_state;	// 学习状态（1表示学习中，2表示已结束） 
    
}
