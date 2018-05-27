package com.yzedu.dao;

import com.yzedu.obj.MyCourse;
import com.yzedu.vo.CourseBean;
import com.yzedu.vo.MessageBean;
import com.yzedu.vo.MyCourseBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
public interface SelectDao {

    public MyCourse selectMyCourseByCouseIdAndUserId(@Param("courseId") Integer courseId,
                                                     @Param("userId") Integer userId);

    public  void addMycourse(MyCourse myCourse);

    public void  addMessage(MessageBean messageBean);

    public String selectCourseNameByCourseId(@Param("courseId") Integer courseId);

    public void deleteMyCourseByCouseIdAndUserId(@Param("courseId") Integer courseId,
                                                 @Param("userId") Integer userId);

    public List<CourseBean> getcourseBeanList(@Param("userId") Integer userId);

}
