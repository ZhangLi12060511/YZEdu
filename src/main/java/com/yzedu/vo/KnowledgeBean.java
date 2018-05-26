package com.yzedu.vo;

import lombok.Data;

/**
 * Created by shaoxin on 2018-05-20.
 * 知识点的模型类
 */

@Data
public class KnowledgeBean {
    
	private int knowledge_id;               // 知识点Id
    private String knowledge_content;       // 知识点内容
    private int knowledge_rank;             // 知识点重要级别

}
