package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 课程资料的模型类
 */

@Data
public class CourseMaterialBean {
    
    private int course_material_id;         // 资料Id
    private String course_material_name;    // 资料名称
    private String course_material_url;     // 资料下载路径
    private String course_material_size;    // 资料大小

}
