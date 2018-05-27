package com.yzedu.obj;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangbenben on 2018/5/27 0027
 */
@Data
public class Student {

    private Integer student_id;

    private String student_name;

    private String student_number;

    private Integer school_id;

    private Integer faculty_id;

    private Integer class_id;

    private String student_password;

    private  Integer user_id;

    private Date gmt_create;

    private Date gmt_modified;

}
