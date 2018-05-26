package com.yzedu.service;

import com.yzedu.dao.BannerDao;
import com.yzedu.vo.BannerBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class BannerService {

    @Resource
    private BannerDao bannerDao;

    public List<BannerBean> getBannerList(Integer schoolId){

        return bannerDao.getBannerList(schoolId);

    }

}
