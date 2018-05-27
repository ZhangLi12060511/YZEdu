package com.yzedu.obj;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Data
public class MyCourse {

    private Integer mycourse_id;

    private Integer user_id;

    private Integer course_id;

    private Byte learn_state;

    private Date gmt_create;

    private  Date gmt_modified;



}
