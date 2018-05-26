package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 轮播图的模型类
 * 直接获取banner表对应内容
 */

@Data
public class BannerBean {
    
	private int banner_id;          // banner_id
    private String banner_image;    // banner图片路径
    private int banner_type;        // banner广告类型
    private String banner_link;     // banner链接内容

}
