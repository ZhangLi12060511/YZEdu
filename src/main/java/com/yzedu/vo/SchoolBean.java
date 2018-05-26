package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 院校的模型类
 * 直接获取school表对应内容
 */
@Data
public class SchoolBean {
	
	private int school_id; // 院校id
	private String school_code; // 院校代码
	private String school_name; // 院校名称
	private String school_badge; // 院校校徽图片路径
	private String school_introduce; // 院校介绍
	private String school_background; // 院校背景图片
	private String school_city; // 院校所在城市
	private String school_province; // 院校所在省份
	private int school_type; // 院校类型（1表示中小学，2表示高等院校，3表示培训机构）
	
}
