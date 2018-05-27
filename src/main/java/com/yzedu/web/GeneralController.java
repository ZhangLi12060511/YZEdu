package com.yzedu.web;

import com.yzedu.obj.Student;
import com.yzedu.obj.Teacher;
import com.yzedu.obj.User;
import com.yzedu.service.GeneralService;
import com.yzedu.util.Constant;
import com.yzedu.util.MD5Tools;
import com.yzedu.vo.StudentBean;
import com.yzedu.vo.TeacherBean;
import com.yzedu.vo.UserBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhangbenben on 2018/5/27 0027
 */
@RestController
@RequestMapping("/general")
public class GeneralController {

    @Resource
    private GeneralService generalService;

    @ApiOperation("用户账号登录")
    @RequestMapping(value = "/AccountLogin",method = RequestMethod.POST)
    public Map<String,Object> AccountLogin(ModelAndView modelAndView,
                                           @ApiParam(value = "账号")@RequestParam(required = true) String user_account,
                                           @ApiParam(value = "密码")@RequestParam(required = true) String password,
                                           @ApiParam(value = "用户类型")@RequestParam(required = true) Integer user_type){
        UserBean userBean = generalService.selectByUserAccount(user_account);

        Integer userId = userBean.getUser_id();
        User user = generalService.selectByUserId(userId);
        String userPassword = user.getUser_password();
        String userAccount = user.getUser_account();
        StudentBean studentBean = generalService.studentLogin(userId);
        TeacherBean teacherBean =generalService.teacherLogin(userId);

        if(userBean == null){
            modelAndView.addObject("result_code",12101);
            modelAndView.addObject("message","登录失败，用户不存在");
            modelAndView.addObject("return_data", null);
            return  modelAndView.getModel();
        }
        if(user_type == 1){
            if(user_account.equals(userAccount) && password.equals(MD5Tools.MD5(userPassword))){
                if(studentBean == null){
                    modelAndView.addObject("result_code",80);
                    modelAndView.addObject("message","登录成功");
                    modelAndView.addObject("return_data", userBean);
                    return  modelAndView.getModel();
                }
                modelAndView.addObject("result_code",81);
                modelAndView.addObject("message","登录成功");
                modelAndView.addObject("return_data", studentBean);
                return  modelAndView.getModel();

            } else {
                modelAndView.addObject("result_code",12102);
                modelAndView.addObject("message","登录失败，用户名或密码错误");
                modelAndView.addObject("return_data", null);
                return  modelAndView.getModel();
            }
        } else if (user_type == 2) {
            if(user_account.equals(userAccount) && password.equals(MD5Tools.MD5(userPassword))){
                if(teacherBean == null){
                    modelAndView.addObject("result_code",80);
                    modelAndView.addObject("message","登录成功");
                    modelAndView.addObject("return_data", userBean);
                    return  modelAndView.getModel();
                }
                modelAndView.addObject("result_code",81);
                modelAndView.addObject("message","登录成功");
                modelAndView.addObject("return_data", teacherBean);
                return  modelAndView.getModel();

            } else {
                modelAndView.addObject("result_code",12102);
                modelAndView.addObject("message","登录失败，用户名或密码错误");
                modelAndView.addObject("return_data", null);
                return  modelAndView.getModel();
            }
        }
        return  modelAndView.getModel();
    }
    @ApiOperation("用户账号登录")
    @RequestMapping(value = "/SchoolLogin",method = RequestMethod.POST)
    public Map<String,Object> AccountLogin(ModelAndView modelAndView,
                                           @ApiParam(value = "账号")@RequestParam(required = true) String user_account,
                                           @ApiParam(value = "密码")@RequestParam(required = true) String password,
                                           @ApiParam(value = "用户类型")@RequestParam(required = true) Integer user_type,
                                           @ApiParam(value = "学校id")@RequestParam(required = true) Integer school_id){
        StudentBean studentBean = generalService.studentLoginBySchool(user_account,school_id);
        TeacherBean teacherBean = generalService.teacherLoginByschool(user_account,school_id);
        if(user_type == 1){
            if(studentBean == null){
                modelAndView.addObject("result_code",12101);
                modelAndView.addObject("message","登录失败，用户不存在");
                modelAndView.addObject("return_data", null);
                return  modelAndView.getModel();
            }
            Student student = generalService.selectByStudentNumber(user_account);
            String studentAccount = student.getStudent_number();
            String studentPassword = student.getStudent_password();

            if(studentAccount.equals(user_account) && studentPassword.equals(MD5Tools.MD5(password))){
                modelAndView.addObject("result_code",81);
                modelAndView.addObject("message","登陆成功");
                modelAndView.addObject("return_data", studentBean);
                return  modelAndView.getModel();
            } else {
                modelAndView.addObject("result_code",12102);
                modelAndView.addObject("message","登录失败，用户名或密码错误");
                modelAndView.addObject("return_data", null);
                return  modelAndView.getModel();
            }
        } else if(user_type == 2){
            if(teacherBean == null){
                modelAndView.addObject("result_code",12101);
                modelAndView.addObject("message","登录失败，用户不存在");
                modelAndView.addObject("return_data", null);
                return  modelAndView.getModel();
            }
            Teacher teacher = generalService.selectByTeacherNumber(user_account);
            String teacherAccount = teacher.getTeacher_number();
            String teacherPassword = teacher.getTeacher_password();

            if(teacherAccount.equals(user_account) && teacherPassword.equals(MD5Tools.MD5(password))){
                modelAndView.addObject("result_code",82);
                modelAndView.addObject("message","登陆成功");
                modelAndView.addObject("return_data", studentBean);
                return  modelAndView.getModel();
            } else {
                modelAndView.addObject("result_code",12102);
                modelAndView.addObject("message","登录失败，用户名或密码错误");
                modelAndView.addObject("return_data", null);
                return  modelAndView.getModel();
            }
        }
        return modelAndView.getModel();
    }
    @ApiOperation("用户账号登录")
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public Map<String,Object> AccountLogin(ModelAndView modelAndView,
                                           @ApiParam(value = "手机号")@RequestParam(required = true) String user_phone,
                                           @ApiParam(value = "密码")@RequestParam(required = true) String password,
                                           @ApiParam(value = "性别")@RequestParam(required = true) String user_sex,
                                           @ApiParam(value = "年龄")@RequestParam(required = true) Integer user_age){
        UserBean userBean = generalService.selectByPhone(user_phone);
        if(userBean == null){
            modelAndView.addObject("result_code",12301);
            modelAndView.addObject("message","注册失败，该手机号已被注册");
            modelAndView.addObject("return_data", null);
            return  modelAndView.getModel();
        }
        String account = generateAccount(user_phone);
        User user = new User(account,password,user_phone,user_sex,user_age);
        generalService.addUser(user);
        modelAndView.addObject("result_code",0);
        modelAndView.addObject("message","注册成功");
        modelAndView.addObject("return_data", null);
        return modelAndView.getModel();
    }

    @ApiOperation("修改个人信息")
    @RequestMapping(value = "/ModifyInfo",method = RequestMethod.GET)
    public Map<String,Object> ModifyInfo(ModelAndView modelAndView,
                                         @ApiParam(value = "用户id")@RequestParam(required = true) Integer user_id,
                                         @ApiParam(value = "手机号")@RequestParam(required = true) String user_phone,
                                         @ApiParam(value = "性别")@RequestParam(required = true) String user_sex,
                                         @ApiParam(value = "年龄")@RequestParam(required = true) Integer user_age){

        User user = new User(user_id,user_phone,user_sex,user_age);
        generalService.modifyInfo(user);
        modelAndView.addObject("result_code",0);
        modelAndView.addObject("message","修改成功");
        modelAndView.addObject("return_data", null);
        return modelAndView.getModel();
    }
    @ApiOperation("修改用户头像")
    @RequestMapping(value = "/ModifyAvatar",method = RequestMethod.GET)
    public Map<String,Object> ModifyAvatar(ModelAndView modelAndView,
                                           @ApiParam(value = "用户id")@RequestParam(required = true) Integer user_id,
                                           @ApiParam(value = "头像")@RequestParam(required = true) String user_avatar){

        User user = new User(user_id,user_avatar);
        generalService.modifyAvatar(user);
        modelAndView.addObject("result_code",0);
        modelAndView.addObject("message","修改成功");
        modelAndView.addObject("return_data", null);
        return modelAndView.getModel();
    }




    String generateAccount(String userPhone){
        int nums[]={6,1,3,5,0,4,7,8,9,2};
        char[] str = userPhone.toCharArray();
        String re = str[4]+"";
        for(int i=0;i<nums.length;i++){
            re+=str[nums[i]];
        }
        return re;



    }

}