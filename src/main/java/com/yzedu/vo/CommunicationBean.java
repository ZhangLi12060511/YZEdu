package com.yzedu.vo;

import lombok.Data;

import java.util.List;


/**
 * Created by shaoxin on 2018-05-20.
 * 课程交流的模型类
 */

@Data
public class CommunicationBean {
	private int communication_id; // 课程交流的id
	private int lesson_id; // 所属一节课的课程交流
	private String communication_author_name; // 发言者学生名(通过author找到student表对应user_id的student_name)
	private String communication_author_avatar; // 发言者头像(通过author找到user表对应user_id的user_avatar)
	private String communication_content; // 发言内容
	private List<DynamicImage> list_images; // 属于这条课程交流的图片列表 可以是空列表{},但不能为null
	private List<DynamicComment> list_comments; // 属于这条课程交流的评论列表,可以是空列表{},但不能为null
	private List<DynamicPraise> list_praises; // 属于这条课程交流的点赞列表 可以是空列表{},但不能为null
	private String dynamic_date; // 发布时间,(对应gmt_create)

}
