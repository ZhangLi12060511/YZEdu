package com.yzedu.dao;

import com.yzedu.obj.Teacher;
import com.yzedu.vo.CourseBean;
import com.yzedu.vo.TaskBean;
import com.yzedu.vo.TeacherBean;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface CourseDao {

    List<CourseBean> getCourseList(@Param("teacherId")Integer teacherId);

    void addLesson(@Param("courseId") Integer courseId
            ,@Param("lessonTitle") String lessonTitle,@Param("videoUrl") String videoUrl);

    Teacher getTeacherById(@Param("teacherId") Integer teacherId);

    void deleteLessonId(@Param("lessonId") Integer lessonId);

    void addKnowledge(@Param("lessonId") Integer lessonId,@Param("knowledgeContent") String knowledgeContent,
                        @Param("knowledgeRank") Integer knowledgeRank);

    void deleteKnowledge(@Param("knowledgeId") Integer knowledgeId);

    void modifyCourse(@Param("courseId") Integer courseId,@Param("courseName") String courseName,
                      @Param("courseSum") Integer courseSum,@Param("courseSumStudent") Integer courseSumStudent,
                      @Param("courseIntroduce") String courseIntroduce);

    void addMaterial(@Param("courseId") Integer courseId,@Param("courseMaterialName") String courseMaterialName,
                     @Param("courseMaterialUrl") String courseMaterialUrl,
                     @Param("courseMaterialSize") String courseMaterialSize);

    void deleteMaterial(@Param("materialId") Integer materialId);

    void modifyCourseCover(@Param("courseId") Integer courseId , @Param("courseCover") String courseCover);

     List<CourseBean> getMyPracticalTrainingList(@Param("teacherId") Integer teacherId);

     void addPractical(@Param("courseId") Integer courseId,@Param("practicalTrainingDescribe") String practicalTrainingDescribe,
                       @Param("practicalTrainingPlan") String practicalTrainingPlan);

     void deletePracticing(@Param("practicalTrainingId") Integer practicalTrainingId);

     List<TaskBean> getMyTaskList(@Param("teacherId") Integer teacherId , @Param("state") Integer state);

     void addNewTask(@Param("courseId") Integer courseId,@Param("task_name") String task_name,
                    @Param("task_type") Integer task_type,@Param("task_start_time") String task_start_time,
                    @Param("task_end_time") String task_end_time, @Param("task_publish") Integer task_publish,
                    @Param("task_link") String task_link);

     void deleteTask(@Param("task_id") Integer task_id);
}
