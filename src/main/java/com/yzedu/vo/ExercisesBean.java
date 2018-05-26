package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 综合练习的模型类
 */

@Data
public class ExercisesBean {
	
	private int lesson_id;
	private String course_name;	// 通过id找lesson_title
	private int exercises_state;
	
}
