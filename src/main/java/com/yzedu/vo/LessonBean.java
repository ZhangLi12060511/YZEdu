package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 一节课的模型类
 */

@Data
public class LessonBean {
    private int lesson_id;              // 一节课id
    private int course_id;              // 所属课程id
    private String lesson_title;        // 一节课标题
    private String lesson_video_url;    // 视频路径

}
