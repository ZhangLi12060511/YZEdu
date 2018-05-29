package com.yzedu.service;

import com.yzedu.dao.GeneralDao;
import com.yzedu.obj.Student;
import com.yzedu.obj.Teacher;
import com.yzedu.obj.User;
import com.yzedu.vo.MessageBean;
import com.yzedu.vo.StudentBean;
import com.yzedu.vo.TeacherBean;
import com.yzedu.vo.UserBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<MessageBean> getMessageList(Integer user_id){
        return generalDao.getMessageList(user_id);
    }

    public void updateMessage(Integer message_id, Integer user_id){
        generalDao.updateMessage(message_id,user_id);
    }

    public void clearMessage(Integer user_id){
        generalDao.clearMessage(user_id);
    }

    public void insertAdvice(String advice_content){
        generalDao.insertAdvice(advice_content);
    }

    public void unbindStudent(Integer user_id, Integer input_id){
        generalDao.unbindStudent(user_id,input_id);
    }

    public void unbindTeacher(Integer user_id,Integer input_id){
        generalDao.unbindTeacher(user_id,input_id);
    }

    public Student selectByStudentId(String student_id){
        return generalDao.selectByStudentId(student_id);
    }

    public Teacher selectByTeacherId(String teacher_id){
        return generalDao.selectByTeacherId(teacher_id);
    }

    public void bindUser(Integer user_id,String input_id){
        generalDao.bindUser(user_id,input_id);
    }

    

}
