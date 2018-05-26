package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 成绩的模型类
 */

@Data
public class GradeBean {
    
	private int student_id; // 学生学号
	private String student_name; // 通过student_id找到学生姓名
	private String course_name; // 成绩所属课程（通过id(grade_course)查找课名）
	private int grade_mark; // 考试分数

}
