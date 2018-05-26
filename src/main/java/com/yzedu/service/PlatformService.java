package com.yzedu.service;

import com.yzedu.dao.PlatformDao;
import com.yzedu.vo.InformationBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/1/4 0004
 */
@Service
public class PlatformService {

    @Resource
    private PlatformDao platformDao;

    public  List<InformationBean> getInformations(){
        return platformDao.getInformations();
    }

}
