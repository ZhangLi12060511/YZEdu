package com.yzedu.web;

import com.yzedu.obj.MyCourse;
import com.yzedu.service.SelectService;
import com.yzedu.util.Constant;
import com.yzedu.vo.MessageBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    private static final Logger logger = Logger.getLogger(CourseController.class);

    @Resource
    private SelectService selectService;


    @ApiOperation("报名选课")
    @RequestMapping(value = "/Select",method = RequestMethod.POST)
    public Map<String,Object> getAnnouncement(ModelAndView modelAndView, @ApiParam(value = "课程id") @RequestParam(required = true) Integer course_id,
                                              @ApiParam(value = "用户id") @RequestParam(required = true) Integer user_id){
        MyCourse myCourse = selectService.selectMyCourseByCouseIdAndUserId(course_id,user_id);
        if(myCourse != null){
            modelAndView.addObject("result_code", Constant.ELECTIVE_FAILURE_CODE);
            modelAndView.addObject("message", Constant.ELECTIVE_FAILURE_MESSAGE);
            modelAndView.addObject("return_data", null);
            return modelAndView.getModel();
        }
        try {
            //添加选课信息到myCourse
            MyCourse myCourse1 = new MyCourse();
            myCourse1.setCourse_id(course_id);
            myCourse1.setUser_id(user_id);
            selectService.addMycourse(myCourse1);
            //添加一条消息
            MessageBean messageBean = new MessageBean();
            String link = "course_id= "+course_id + "user_id= "+user_id;
            String courseName = selectService.selectCourseNameByCourseId(course_id);
            String content = "你成功报名了"+courseName+"的课程";
            messageBean.setMessage_content(content);
            messageBean.setMessage_link(link);
            messageBean.setMessage_type(1);
            messageBean.setUser_id(user_id);
            selectService.addMessage(messageBean);
        } catch (Exception e){
           logger.info("添加信息异常");
            modelAndView.addObject("result_code", Constant.ELECTIVE_FAILURE_CODE);
            modelAndView.addObject("message", Constant.ELECTIVE_FAILURE_MESSAGE);
            modelAndView.addObject("return_data", null);
            return modelAndView.getModel();
        }
        modelAndView.addObject("result_code", Constant.ELECTIVE_SUCCESS_CODE);
        modelAndView.addObject("message", Constant.ELECTIVE_SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", null);
        return modelAndView.getModel();
    }
    @ApiOperation("退选课程")
    @RequestMapping(value = "/Quit",method = RequestMethod.POST)
    public Map<String,Object> getQuit(ModelAndView modelAndView, @ApiParam(value = "课程id") @RequestParam(required = true) Integer course_id,
                                              @ApiParam(value = "用户id") @RequestParam(required = true) Integer user_id){
        try {
            //退选
            selectService.deleteMyCourseByCouseIdAndUserId(course_id,user_id);
            MyCourse myCourse = selectService.selectMyCourseByCouseIdAndUserId(course_id,user_id);
            if(myCourse != null){
                modelAndView.addObject("result_code", Constant.RETREAT_FAILURE_CODE);
                modelAndView.addObject("message", Constant.RETREAT_FAILURE_MESSAGE);
                modelAndView.addObject("return_data", null);
                return modelAndView.getModel();
            }
        } catch (Exception e){
            modelAndView.addObject("result_code", Constant.SERVER_EXCEPTION_CODE);
            modelAndView.addObject("message", Constant.SERVER_EXCEPTION_MESSAGE);
            modelAndView.addObject("return_data", null);
            return modelAndView.getModel();
        }
        modelAndView.addObject("result_code", Constant.RETREAT_SUCCESS_CODE);
        modelAndView.addObject("message", Constant.RETREAT_SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", null);
        return modelAndView.getModel();
    }


}
