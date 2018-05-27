package com.yzedu.service;

import com.yzedu.dao.AboutDao;
import com.yzedu.vo.SchoolBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class AboutService {

    @Resource
    private AboutDao aboutDao;

    public List<SchoolBean> getAboutList(Integer school_id){
        return aboutDao.getAboutList(school_id);
    }
}
