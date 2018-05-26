package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 2018-05-22.
 * 直播公告数据的模型类
 * 直接从公告表（live_announcement）读
 */

@Data
public class LiveAnnouncementBean {
	
    private int live_announcement_id;            // 公告id
    private String live_announcement_content;    // 公告内容
    private int live_announcement_stick;         // 是否置顶
    private String live_announcement_date;       // 公告日期(gmt_create)

}
