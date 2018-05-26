package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 错题的模型类
 */
@Data
public class MistakeBean {
    
	private int mistake_id; // 错题id

	// 这些内容是通过错题表中的exam_item_id找到对应的题目
	private String exam_item_question; // 题目问题
	private int exam_item_type; // 题型（1表示选择题；2表示填空题；3表示主观题）
	private String exam_item_option1; // 如果是选择题，则为选项1，否则为null
	private String exam_item_option2; // 选项2
	private String exam_item_option3; // 选项3
	private String exam_item_option4; // 选项4
	private String exam_item_answer; // 客观题的答案

	private String student_answer; // 学生选择的答案
	private String mistake_note; // 错题笔记
	

}
