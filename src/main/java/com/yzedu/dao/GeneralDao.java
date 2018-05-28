package com.yzedu.dao;

import com.yzedu.obj.Student;
import com.yzedu.obj.Teacher;
import com.yzedu.obj.User;
import com.yzedu.vo.MessageBean;
import com.yzedu.vo.StudentBean;
import com.yzedu.vo.TeacherBean;
import com.yzedu.vo.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<MessageBean> getMessageList(@Param("user_id") Integer user_id);

    void updateMessage(@Param("messageId") Integer message_id,@Param("userId") Integer user_id);

    void clearMessage(@Param("userId") Integer user_id);

    void insertAdvice(@Param("advice_content") String advice_content);

    void bindUser(@Param("user_id") Integer user_id,@Param("input_id") String input_id);

    void bindTeacher(@Param("user_id") Integer user_id,@Param("input_id") Integer input_id);

    void unbindStudent(@Param("user_id") Integer user_id,@Param("input_id") Integer input_id);

    void unbindTeacher(@Param("user_id") Integer user_id,@Param("input_id") Integer input_id);

    Student selectByStudentId(@Param("student_id") String student_id);

    Teacher selectByTeacherId(@Param("teacher_id") String teacher_id);
}
