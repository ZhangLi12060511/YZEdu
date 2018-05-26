package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 公告数据的模型类
 * 直接从公告表（announcement）读
 */

@Data
public class AnnouncementBean {
	
    private int announcement_id;            // 公告id
    private String announcement_title;      // 公告标题
    private String announcement_content;    // 公告内容
    private int announcement_stick;         // 是否置顶
    private String announcement_date;       // 公告日期

}
