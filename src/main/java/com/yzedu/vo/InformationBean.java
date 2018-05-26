package com.yzedu.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by shaoxin on 2018-5-20.
 * 显示资讯列表的模型类
 * 基本属性从资讯表（platform_information或school_information）里面取内容
 * informations_images从对应的platform_image或school_image中读取输入该资讯的图片
 */

@Data
public class InformationBean {
	
    private String information_title;   // 资讯标题
    private String information_content; // 资讯内容
    private String information_date;    // 资讯日期(直接取字符串)
    private String information_cover;   // 资讯封面图片路径(如果没有设为null)
    private String information_author;  // 资讯作者（如果没有设为null）
    private int information_image_count; // 包含图片的数量
    private List<String> information_images; // 包含的图片列表，存放每张图片的图片路径


}
