package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 18-4-9.
 * 课程交流评论的模型类
 */

@Data
public class CommunicationComment {
    private int communication_comment_id;             // 课程交流评论id
    private String communication_comment_name;        // 课程交流评论者的对应学生名(dynamic_comment.author=student.user_id,再找学生名)
    private String communication_comment_avatar;      // 课程交流评论者的对应学生的头像(dynamic_comment.author=student.user_id,在找用户头像)
    private int communication_id;              // 对应的课程交流
    private int communication_reply_user;             // 要回复的用户对应的学生名(dynamic_comment.author=student.user_id,再找学生名),如果没有为null
    private String communication_comment_content;     // 评论的内容
    private String communication_comment_date;        // 发表时间(对应gmt_create)

}
