package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 2018-5-20.
 * 课程交流图片的模型类
 */

@Data
public class CommunicationImage{
    private int communication_image_id;           // 图片id
    private int communication_id;          // 所属学友圈动态id
    private String communication_image_url;       // 图片路径

}
