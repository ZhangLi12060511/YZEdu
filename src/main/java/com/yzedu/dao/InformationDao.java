package com.yzedu.dao;

import com.yzedu.vo.InformationBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface InformationDao {


    List<InformationBean> getInformationList(@Param("schoolId") Integer schoolId);
}
