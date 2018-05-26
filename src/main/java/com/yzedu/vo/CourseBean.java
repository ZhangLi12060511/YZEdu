package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 课程信息的模型类
 * 基本信息从课程表读取，教师通过id找到教师名
 */

@Data
public class CourseBean{
    
	private int course_id;              // 课程id
    private String course_code;         // 课程代码
    private String course_name;         // 课程名称
    private String course_introduce;    // 课程介绍
    private String course_teacher;      // 课程教师(通过teacher_id找到这个教师的teacher_name)
    private int course_sum_student;     // 课程容量人数
    private int course_learn_student;   // 课程学习人数
    private String course_cover;        // 课程封面途径
    private int course_sum;             // 总课时
    private int course_type;            // 课程类型
    private double course_price;        // 课程价格(数据库中设置的是decimal格式)
    private int course_finish;          // 已完成课时
    
}
