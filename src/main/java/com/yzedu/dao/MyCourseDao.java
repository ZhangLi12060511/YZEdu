package com.yzedu.dao;

import com.yzedu.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface MyCourseDao {

    List<MyCourseBean> getMyCourseList (@Param("userId") Integer userId);

    List<MistakeBean> getMistakeList(@Param("userId") Integer userId,@Param("courseId") Integer courseId);

    List<KnowledgeBean> getKnowledgeList(@Param("lessonId") Integer lessonId);

    List<CourseMaterialBean> getCourseMaterialList(@Param("courseId") Integer courseId);

    List<MyCourseBean> getMyPracticalTrainingList(@Param("userId") Integer userId);

    List<PracticalTrainingBean> getPracticalTrainingList(@Param("courseId") Integer courseId);

    List<TaskBean> getTask(@Param("studentId") Integer studentId,@Param("state") Integer state);

    List<GradeBean> getGrade(@Param("studentId") Integer studentId);

    List<AbilityBean> getAbility(@Param("studentId") Integer studentId);

}
