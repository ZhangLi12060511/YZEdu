package com.yzedu.service;

import com.yzedu.dao.SchoolsDao;
import com.yzedu.vo.SchoolBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class SchoolsService {

    @Resource
    private SchoolsDao schoolsDao;

    public List<SchoolBean> getSchools(){
        return schoolsDao.getSchools();
    }
}
