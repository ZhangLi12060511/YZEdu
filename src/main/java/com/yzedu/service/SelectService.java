package com.yzedu.service;

import com.yzedu.dao.SelectDao;
import com.yzedu.obj.MyCourse;
import com.yzedu.vo.CourseBean;
import com.yzedu.vo.MessageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class SelectService {

    @Resource
    SelectDao selectDao;

    public MyCourse selectMyCourseByCouseIdAndUserId(Integer courseId , Integer userId){
        return selectDao.selectMyCourseByCouseIdAndUserId(courseId,userId);
    }

    public void addMycourse(MyCourse myCourse){
        selectDao.addMycourse(myCourse);
    }

    public void addMessage(MessageBean messageBean){
        selectDao.addMessage(messageBean);
    }

    public String selectCourseNameByCourseId(Integer courseId){
        return selectDao.selectCourseNameByCourseId(courseId);
    }
    public void deleteMyCourseByCouseIdAndUserId(@Param("courseId") Integer courseId,
                                                 @Param("userId") Integer userId){
        selectDao.deleteMyCourseByCouseIdAndUserId(courseId,userId);

    }
    public List<CourseBean> getcourseBeanList(@Param("userId") Integer userId){
        return selectDao.getcourseBeanList(userId);
    }



}
