package com.yzedu.dao;

import com.yzedu.vo.InformationBean;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/1/4 0004
 */
public interface PlatformDao {

    List<InformationBean> getInformations();

    List<String> getInformationImages(@Param("id") Integer id);



}
