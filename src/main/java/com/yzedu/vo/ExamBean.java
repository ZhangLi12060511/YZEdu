package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 课程考试列表的模型类
 */

@Data
public class ExamBean {
	
	private int course_id;
	private String course_name;	// 通过id找课名
	private String exam_start_time;
	private String exam_end_time;
	
}
