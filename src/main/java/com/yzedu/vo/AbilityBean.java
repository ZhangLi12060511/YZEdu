package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 能力档案的模型类
 */

@Data
public class AbilityBean {
    
	private int student_id;
	
	// 6大评分方向
	private int ability_theory;
	private int ability_practice;
	private int ability_language;
	private int ability_innovate;
	private int ability_think;
	private int ability_teamwork;

}
