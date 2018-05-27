package com.yzedu.dao;

import com.yzedu.vo.AnnouncementBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface AnnouncementDao {

    List<AnnouncementBean> getannouncementList(@Param("schoolId") Integer schoolId);

}
