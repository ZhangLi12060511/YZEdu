package com.yzedu.vo;


import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 课程交流点赞的模型类
 */

@Data
public class CommunicationPraise {
    private int communication_praise_id;          // 点赞的id
    private int communication_praise_user_name;   // 点赞用户的用户名
    private int communication_id;          // 所属课程交流

}
