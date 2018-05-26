package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 消息列表的模型类
 */

@Data
public class MessageBean {
   
	private int message_id; // 消息id
	private int message_type; // 消息类型
	private String message_content; // 消息内容
	private String message_link; // 消息关联内容
	private String message_date; // 消息创建日期（gmt_create）
	private int message_read; // 消息是否已读（1表示已读，0表示未读）

}
