package com.yzedu.dao;

import com.yzedu.vo.BannerBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface BannerDao {

    List<BannerBean> getBannerList(@Param("schoolId") Integer schoolId);


}
