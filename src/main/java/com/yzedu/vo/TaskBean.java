package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 任务的模型类
 * （老师和学生查找方法不同，返回结果一样）
 */
@Data
public class TaskBean {
	
	private int task_id;	// 任务id
	private int task_state;	// 任务状态（1表示未开始；2表示进行中；3表示批改中；4表示已完成；5表示已结束）
	private String task_name;	// 任务名称
	private String task_start_time;	// 任务开始时间
	private String task_end_time;	// 任务结束时间
	private String task_publish;	// 发布者（通过id找到teacher表的老师）	
	private String task_link;	//任务链接（具体一个综合练习或者实训）
	private String task_date;	//任务发布日期（gmt_create）
	private int task_type;	// 任务类型（1表示练习任务；2表示实训任务）
	
}
