package com.yzedu.service;

import com.yzedu.dao.GeneralDao;
import com.yzedu.obj.Student;
import com.yzedu.obj.Teacher;
import com.yzedu.obj.User;
import com.yzedu.vo.StudentBean;
import com.yzedu.vo.TeacherBean;
import com.yzedu.vo.UserBean;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangbenben on 2018/5/27 0027
 */
@Service
public class GeneralService {

    @Resource
    private GeneralDao generalDao;

    public StudentBean studentLogin(Integer user_id){
           return generalDao.studentLogin(user_id);

    }

    public TeacherBean teacherLogin(Integer user_id){
        return generalDao.teacherLogin(user_id);
    }
    public UserBean selectByUserAccount(String user_account){
        return generalDao.selectByUserAccount(user_account);
    }
    public StudentBean studentLoginBySchool(String user_account,
                                             Integer school_id){
        return generalDao.studentLoginBySchool(user_account,school_id);
    }

    public TeacherBean teacherLoginByschool(String user_account , Integer school_id){
        return generalDao.teacherLoginByschool(user_account,school_id);
    }

    public  User selectByUserId(Integer user_id){
        return generalDao.selectByUserId(user_id);
    }
   public Student selectByStudentNumber(String student_number){
        return generalDao.selectByStudentNumber(student_number);
   }

   public Teacher selectByTeacherNumber(String teacher_number){
       return generalDao.selectByTeacherNumber(teacher_number);
   }
    public UserBean selectByPhone(String user_phone){
       return generalDao.selectByPhone(user_phone);
    }

    public void addUser(User user){
            generalDao.addUser(user);
    }
    public  void modifyInfo(User user){
            generalDao.modifyInfo(user);
    }
    public void modifyAvatar(User user){
        generalDao.modifyAvatar(user);
    }

}
