package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 18-3-26.
 * 存放直播间对象的类
 */

@Data
public class LiveRoomBean {
	
    private int live_room_id;           // 直播间id
    private String teacher_name;        // 教师姓名(通过teacher_id找到)
    private String live_room_name;      // 直播间名
    private String live_room_number;    // 直播间号码
    private String live_room_image;     // 直播间封面图片路径
    private int live_room_state;        // 直播间状态

}
