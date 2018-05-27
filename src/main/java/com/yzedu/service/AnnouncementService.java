package com.yzedu.service;

import com.yzedu.dao.AnnouncementDao;
import com.yzedu.vo.AnnouncementBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class AnnouncementService {

    @Resource
    private AnnouncementDao announcementDao;

    public List<AnnouncementBean> getannouncementList( Integer schoolId){
        return announcementDao.getannouncementList(schoolId);
    }


}
