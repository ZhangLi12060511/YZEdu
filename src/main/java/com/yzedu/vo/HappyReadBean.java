package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 悦读信息的模型类
 * 基本信息直接从happy_read读取
 */
@Data
public class HappyReadBean {

	private int happy_read_id;	// 悦读id
	private String happy_read_title;// 悦读标题
	private String happy_read_content; // 悦读文字内容
	private String happy_link; // 悦读链接地址
	private String happy_read_img; // 封面图片
	
}
