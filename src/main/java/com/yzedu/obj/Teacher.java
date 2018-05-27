package com.yzedu.obj;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Data
public class Teacher {

    private Integer teacher_id;

    private String teacher_name;

    private Integer school_id;

    private String teacher_number;

    private String teacher_password;

    private Integer user_id;

    private Date gmt_create;

    private Date gmt_modified;


}
