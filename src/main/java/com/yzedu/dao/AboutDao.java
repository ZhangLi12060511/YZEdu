package com.yzedu.dao;

import com.yzedu.vo.SchoolBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface AboutDao {

    List<SchoolBean> getAboutList(@Param("schoolId") Integer school_id);

}
