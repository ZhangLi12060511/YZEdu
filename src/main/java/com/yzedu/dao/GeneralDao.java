package com.yzedu.dao;

import com.yzedu.obj.Student;
import com.yzedu.obj.Teacher;
import com.yzedu.obj.User;
import com.yzedu.vo.StudentBean;
import com.yzedu.vo.TeacherBean;
import com.yzedu.vo.UserBean;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangbenben on 2018/5/27 0027
 */
public interface GeneralDao {

    StudentBean studentLogin(@Param("user_id") Integer user_id);

    TeacherBean teacherLogin(@Param("user_id") Integer user_id);

    UserBean selectByUserAccount(@Param("user_account") String user_account);

    User selectByUserId(@Param("user_id") Integer user_id);

    StudentBean studentLoginBySchool(@Param("user_account") String user_account,@Param("school_id") Integer school_id);

    TeacherBean teacherLoginByschool(@Param("user_account") String user_account , @Param("school_id") Integer school_id);

    Student selectByStudentNumber(@Param("student_number") String student_number);

    Teacher selectByTeacherNumber(@Param("teacher_number") String teacher_number);

    UserBean selectByPhone(@Param("user_phone") String user_phone);

    void addUser(User user);

    void modifyInfo(User user);

    void modifyAvatar(User user);

}
