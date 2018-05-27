package com.yzedu.web;

import com.yzedu.obj.MyCourse;
import com.yzedu.service.MyCourseService;
import com.yzedu.util.Constant;
import com.yzedu.util.PageModel;
import com.yzedu.vo.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@RestController
@RequestMapping("/learn")
public class LearnController {


    @Resource
    private MyCourseService myCourseService;

    @ApiOperation("我的课程列表")
    @RequestMapping(value = "/MyCourse", method = RequestMethod.GET)
    public Map<String, Object> getMyCourse(ModelAndView modelAndView,
                                           @ApiParam(value = "用户id") @RequestParam(required = true) Integer user_id,
                                           @ApiParam(value = "分页") @RequestParam(required = true) Integer page) {
        List<MyCourseBean> myCourseBeanList = myCourseService.getMyCourseList(user_id);

        //对List进行分页处理
        PageModel pageModel = new PageModel(myCourseBeanList, 12);
        List<InformationBean> sublist = pageModel.getObjects(page);

        modelAndView.addObject("result_code", Constant.SUCCESS_CODE);
        modelAndView.addObject("message", Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", sublist);
        return modelAndView.getModel();
    }

    @ApiOperation("错题列表")
    @RequestMapping(value = "/Mistake", method = RequestMethod.GET)
    public Map<String, Object> getMyCourse(ModelAndView modelAndView,
                                           @ApiParam(value = "用户id") @RequestParam(required = true) Integer user_id,
                                           @ApiParam(value = "分页") @RequestParam(required = true) Integer page,
                                           @ApiParam(value = "用户id") @RequestParam(required = true) Integer course_id) {
        List<MistakeBean> mistakeBeanList = myCourseService.getMistakeList(user_id, course_id);

        //对List进行分页处理
        PageModel pageModel = new PageModel(mistakeBeanList, 12);
        List<InformationBean> sublist = pageModel.getObjects(page);

        modelAndView.addObject("result_code", Constant.SUCCESS_CODE);
        modelAndView.addObject("message", Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", sublist);
        return modelAndView.getModel();
    }

    @ApiOperation("知识点列表")
    @RequestMapping(value = "/Knowledge", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(ModelAndView modelAndView,
                                            @ApiParam(value = "一门课id") @RequestParam(required = true) Integer lesson_id) {

        List<KnowledgeBean> knowledgeBeanList = myCourseService.getKnowledgeList(lesson_id);
        modelAndView.addObject("result_code", Constant.SUCCESS_CODE);
        modelAndView.addObject("message", Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", knowledgeBeanList);
        return modelAndView.getModel();
    }
   /* @ApiOperation("添加到错题")
    @RequestMapping(value = "/AddMistake",method = RequestMethod.GET)
    public Map<String,Object> AddMistake(ModelAndView modelAndView,
                                           @ApiParam(value ="一门课id") @RequestParam(required = true) Integer lesson_id){
        List<KnowledgeBean> knowledgeBeanList = myCourseService.getKnowledgeList(lesson_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",knowledgeBeanList);
        return modelAndView.getModel();
    }*/
   /*@ApiOperation("移除错题")
   @RequestMapping(value = "/AddMistake",method = RequestMethod.GET)
   public Map<String,Object> AddMistake(ModelAndView modelAndView,
                                        @ApiParam(value ="错题id") @RequestParam(required = true) Integer mistake_id){
       modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
       modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
       modelAndView.addObject("return_data",knowledgeBeanList);
       return modelAndView.getModel();
}*/
   @ApiOperation("课程资料列表")
   @RequestMapping(value = "/CourseMaterial",method = RequestMethod.GET)
   public Map<String,Object> AddMistake(ModelAndView modelAndView,
                                        @ApiParam(value = "课程id") @RequestParam(required = true) Integer course_id){

       List<CourseMaterialBean> courseMaterialBeanList = myCourseService.getCourseMaterialList(course_id);

       modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
       modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
       modelAndView.addObject("return_data",courseMaterialBeanList);
       return modelAndView.getModel();
   }
    @ApiOperation("实训任务列表")
    @RequestMapping(value = "/PracticalTraining",method = RequestMethod.GET)
    public Map<String,Object> getMyPracticalTraining(ModelAndView modelAndView,
                                                    @ApiParam(value ="课程id") @RequestParam(required = true) Integer course_id){
        List<PracticalTrainingBean> practicalTrainingBeanList = myCourseService.getPracticalTrainingList(course_id);

        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",practicalTrainingBeanList);
        return modelAndView.getModel();
    }
    @ApiOperation("我的实训列表")
    @RequestMapping(value = "/MyPracticalTraining",method = RequestMethod.GET)
    public Map<String,Object> getMyPracticalTraining(ModelAndView modelAndView,
                                                     @ApiParam(value = "分页") @RequestParam(required = true,defaultValue = "1") Integer page,
                                                     @ApiParam(value ="用户id") @RequestParam(required = true) Integer user_id){

        List<MyCourseBean> myCourseBeanList = myCourseService.getMyPracticalTrainingList(user_id);
        //对List进行分页处理
        PageModel pageModel = new PageModel(myCourseBeanList, 12);
        List<InformationBean> sublist = pageModel.getObjects(page);

        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",sublist);
        return modelAndView.getModel();
    }

    @ApiOperation("我的全部任务列表")
    @RequestMapping(value = "/Mytask",method = RequestMethod.GET)
    public Map<String,Object> getMytask(ModelAndView modelAndView,
                                        @ApiParam(value = "学号")@RequestParam(required = true) Integer student_id,
                                        @ApiParam(value = "任务状态")@RequestParam(required = true) Integer state){
       List<TaskBean> taskBeanList = myCourseService.getTask(student_id,state);

        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",taskBeanList);
        return modelAndView.getModel();
    }
    @ApiOperation("我的成绩列表")
    @RequestMapping(value = "/MyGrade",method = RequestMethod.GET)
    public Map<String,Object> getMytask(ModelAndView modelAndView,
                                        @ApiParam(value = "学号")@RequestParam(required = true) Integer student_id){
        List<GradeBean> gradeBeanList = myCourseService.getGrade(student_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",gradeBeanList);
        return modelAndView.getModel();
    }
    @ApiOperation("我的能力档案")
    @RequestMapping(value = "/MyAbility",method = RequestMethod.GET)
    public Map<String,Object> getMyAbility(ModelAndView modelAndView,
                                        @ApiParam(value = "学号")@RequestParam(required = true) Integer student_id){
        List<AbilityBean> abilityBeanList = myCourseService.getAbility(student_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",abilityBeanList);
        return modelAndView.getModel();
    }


}