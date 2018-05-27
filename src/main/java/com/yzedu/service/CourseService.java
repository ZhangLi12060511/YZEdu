package com.yzedu.service;

import com.yzedu.dao.CourseDao;
import com.yzedu.obj.Teacher;
import com.yzedu.vo.CourseBean;
import com.yzedu.vo.TaskBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class CourseService {

    @Resource
    public CourseDao courseDao;

    public List<CourseBean> getCourseList(Integer teacherId){
        return courseDao.getCourseList(teacherId);
    }

    public void addLesson(Integer courseId
            , String lessonTitle, String videoUrl){
          courseDao.addLesson(courseId,lessonTitle,videoUrl);
    }

    public Teacher getTeacherById(@Param("teacherId") Integer teacherId){
          return courseDao.getTeacherById(teacherId);
    }
    public void deleteLessonId(@Param("lessonId") Integer lessonId){
          courseDao.deleteLessonId(lessonId);
    }

    public void addKnowledge(Integer lessonId, String knowledgeContent,
                            Integer knowledgeRank){
           courseDao.addKnowledge(lessonId,knowledgeContent,knowledgeRank);
    }

    public  void deleteKnowledge(Integer knowledgeId){
            courseDao.deleteKnowledge(knowledgeId);
    }

    public  void modifyCourse(@Param("courseId") Integer courseId,@Param("courseName") String courseName,
                                  @Param("courseSum") Integer courseSum,@Param("courseSumStudent") Integer courseSumStudent,
                                  @Param("courseIntroduce") String courseIntroduce){
             courseDao.modifyCourse(courseId,courseName,courseSum,courseSumStudent,courseIntroduce);
    }

    public void addMaterial(@Param("courseId") Integer courseId,@Param("courseMaterialName") String courseMaterialName,
                            @Param("courseMaterialUrl") String courseMaterialUrl,
                            @Param("courseMaterialSize") String courseMaterialSize){
             courseDao.addMaterial(courseId,courseMaterialName,courseMaterialUrl,courseMaterialSize);
    }

    public void  deleteMaterial(Integer materialId){
             courseDao.deleteMaterial(materialId);
    }

    public void modifyCourseCover( Integer courseId , String courseCover){
            courseDao.modifyCourseCover(courseId,courseCover);
    }

    public List<CourseBean> getMyPracticalTrainingList(Integer teacherId){
            return courseDao.getMyPracticalTrainingList(teacherId);
    }
    public void addPractical(Integer courseId, String practicalTrainingDescribe,
                                  String practicalTrainingPlan){
            courseDao.addPractical(courseId,practicalTrainingDescribe,practicalTrainingPlan);
    }
    public void deletePracticing(Integer practicalTrainingId){
            courseDao.deletePracticing(practicalTrainingId);
    }
    public  List<TaskBean> getMyTaskList(Integer teacherId ,  Integer state){
            return courseDao.getMyTaskList(teacherId,state);
    }
    public void addNewTask(Integer courseId, String task_name,
                            Integer task_type, String task_start_time,
                            String task_end_time,Integer task_publish,
                            String task_link){
            courseDao.addNewTask(courseId,task_name,task_type,task_start_time,task_end_time,task_publish,task_link);
    }

    public void  deleteTask(Integer task_id){
            courseDao.deleteTask(task_id);
    }

}
