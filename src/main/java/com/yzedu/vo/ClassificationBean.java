package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-5-20.
 * 课程分类的模型类
 */

@Data
public class ClassificationBean {
	
    private int classification_id;          // 分类id
    private String classification_name;     // 分类名
    private int classification_own;         // 所属分类

}
