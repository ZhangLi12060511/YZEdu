package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 综合实训的模型类
 * 实训的是和Lesson同一个层次的，由于课程类型不同，具体内容不同
 */
@Data
public class PracticalTrainingBean {
    
	private int practical_training_id;          // 实训_id
	private String practical_training_describe;	//任务描述
	private String practical_training_plan;	//实训计划

}
