package com.yzedu.service;

import com.yzedu.dao.InformationDao;
import com.yzedu.vo.InformationBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class InformationService {

    @Resource
    private InformationDao informationDao;

    public List<InformationBean> getInformationList(Integer schoolId){
        return informationDao.getInformationList(schoolId);
    }
}
