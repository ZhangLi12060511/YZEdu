package com.yzedu.service;

import com.yzedu.dao.MyCourseDao;
import com.yzedu.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class MyCourseService {

    @Resource
    private MyCourseDao myCourseDao;

    public List<MyCourseBean> getMyCourseList (Integer userId){
            return myCourseDao.getMyCourseList(userId);
    }

    public    List<MistakeBean> getMistakeList(@Param("userId") Integer userId, @Param("courseId") Integer courseId){
            return myCourseDao.getMistakeList(userId,courseId);
    }

    public List<KnowledgeBean> getKnowledgeList(Integer lessonId){
           return myCourseDao.getKnowledgeList(lessonId);
    }
    public List<CourseMaterialBean> getCourseMaterialList(@Param("courseId") Integer courseId){
           return myCourseDao.getCourseMaterialList(courseId);
    }

    public List<MyCourseBean> getMyPracticalTrainingList(@Param("userId") Integer userId){
           return myCourseDao.getMyPracticalTrainingList(userId);
    }

    public List<PracticalTrainingBean> getPracticalTrainingList(Integer courseId){
           return myCourseDao.getPracticalTrainingList(courseId);
    }
    public  List<TaskBean> getTask(Integer studentId,Integer state){
           return myCourseDao.getTask(studentId,state);
    }
    public  List<GradeBean> getGrade(Integer studentId){
           return myCourseDao.getGrade(studentId);
    }

    public List<AbilityBean> getAbility(Integer studentId){
           return myCourseDao.getAbility(studentId);
    }
}
