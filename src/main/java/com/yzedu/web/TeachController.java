package com.yzedu.web;

import com.yzedu.obj.Teacher;
import com.yzedu.service.CourseService;
import com.yzedu.util.Constant;
import com.yzedu.vo.CourseBean;
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
@RequestMapping("/teach")
public class TeachController {

    @Resource
    private CourseService courseService;

    @ApiOperation("我的课程列表")
    @RequestMapping(value = "/MyCourse",method = RequestMethod.GET)
    public Map<String,Object>  getMyCourse(ModelAndView modelAndView,
                                           @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id){

        List<CourseBean> courseBeanList = courseService.getCourseList(teacher_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", courseBeanList );
        return  modelAndView.getModel();
    }
    @ApiOperation("新增一节课")
    @RequestMapping(value = "/AddLesson",method = RequestMethod.POST)
    public Map<String,Object>  getMyCourse(ModelAndView modelAndView,
                                           @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                           @ApiParam(value = "课程id")@RequestParam(required = true) Integer course_id,
                                           @ApiParam(value = "title")@RequestParam(required = true) String lesson_title,
                                           @ApiParam(value = "播放链接")@RequestParam(required = true) String video_url){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",Constant.AUTHORITY_CODE);
            modelAndView.addObject("message",Constant.AUTHORITY_MESSAGE);
            modelAndView.addObject("return_data",null );
        }
        courseService.addLesson(course_id,lesson_title,video_url);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","添加成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("删除一节课")
    @RequestMapping(value = "/DeleteLesson",method = RequestMethod.POST)
    public Map<String,Object>  DeleteLesson(ModelAndView modelAndView,
                                           @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                           @ApiParam(value = "一节课id")@RequestParam(required = true) Integer lesson_id){

        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","删除失败，权限不足");
            modelAndView.addObject("return_data",null );
        }
        courseService.deleteLessonId(lesson_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","删除成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("新增一个知识点")
    @RequestMapping(value = "/AddKnowledge",method = RequestMethod.POST)
    public Map<String,Object>  AddKnowledge(ModelAndView modelAndView,
                                            @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                            @ApiParam(value = "一节课id")@RequestParam(required = true) Integer lesson_id
                                            ,@ApiParam(value = "内容")@RequestParam(required = true) String knowledge_content,
                                            @ApiParam(value = "等级")@RequestParam(required = true) Integer knowledge_rank){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","添加失败，权限不足");
            modelAndView.addObject("return_data",null );
        }
        courseService.addKnowledge(lesson_id,knowledge_content,knowledge_rank);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","添加成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("删除一个知识点")
    @RequestMapping(value = "/DeleteKnowledge",method = RequestMethod.POST)
    public Map<String,Object>  DeleteKnowledge(ModelAndView modelAndView,
                                            @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                            @ApiParam(value = "知识id")@RequestParam(required = true) Integer knowledge_id){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","删除失败，权限不足");
            modelAndView.addObject("return_data",null );
        }
        courseService.deleteKnowledge(knowledge_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","删除成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("修改课程信息")
    @RequestMapping(value = "/ModifyCourse",method = RequestMethod.POST)
    public Map<String,Object>  ModifyCourse(ModelAndView modelAndView,
                                               @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                               @ApiParam(value = "课程id")@RequestParam(required = true) Integer course_id,
                                               @ApiParam(value = "课程名")@RequestParam(required = true) String course_name,
                                               @ApiParam(value = "课程课时")@RequestParam(required = true) Integer course_sum,
                                               @ApiParam(value = "课程人数")@RequestParam(required = true) Integer course_sum_student,
                                               @ApiParam(value = "课程简介")@RequestParam(required = true) String course_introduce){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9601);
            modelAndView.addObject("message","修改失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.modifyCourse(course_id,course_name,course_sum,course_sum_student,course_introduce);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","修改成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("新增课程资料")
    @RequestMapping(value = "/AddMaterial",method = RequestMethod.POST)
    public Map<String,Object>  AddMaterial(ModelAndView modelAndView,
                                            @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                            @ApiParam(value = "课程id")@RequestParam(required = true) Integer course_id,
                                            @ApiParam(value = "课程资料名")@RequestParam(required = true) String course_material_name,
                                            @ApiParam(value = "课程资料链接")@RequestParam(required = true) String course_material_url,
                                            @ApiParam(value = "课程资料大小")@RequestParam(required = true) String course_material_size){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9401);
            modelAndView.addObject("message","添加失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.addMaterial(course_id,course_material_name,course_material_url,course_material_size);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","添加成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("删除课程资料")
    @RequestMapping(value = "/DeleteMaterial",method = RequestMethod.POST)
    public Map<String,Object>  DeleteMaterial(ModelAndView modelAndView,
                                           @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                           @ApiParam(value = "资料id")@RequestParam(required = true) Integer material_id){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","删除失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.deleteMaterial(material_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","删除成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("修改课程封面")
    @RequestMapping(value = "/ModifyCourseCover",method = RequestMethod.POST)
    public Map<String,Object>  DeleteMaterial(ModelAndView modelAndView,
                                              @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                              @ApiParam(value = "课程id")@RequestParam(required = true) Integer course_id,
                                              @ApiParam(value = "课程封面")@RequestParam(required = true) String course_cover){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9601);
            modelAndView.addObject("message","修改失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.modifyCourseCover(course_id,course_cover);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","修改成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("我的实训列表")
    @RequestMapping(value = "/MyPracticalTraining",method = RequestMethod.GET)
    public Map<String,Object>  DeleteMaterial(ModelAndView modelAndView,
                                              @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id){
        List<CourseBean> courseBeanList = courseService.getMyPracticalTrainingList(teacher_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","修改成功！");
        modelAndView.addObject("return_data", courseBeanList);
        return  modelAndView.getModel();
    }
    @ApiOperation("新增一个实训")
    @RequestMapping(value = "/AddPractical",method = RequestMethod.POST)
    public Map<String,Object>  AddPractical(ModelAndView modelAndView,
                                              @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                            @ApiParam(value = "课程id")@RequestParam(required = true) Integer course_id,
                                            @ApiParam(value = "实训描述")@RequestParam(required = true) String practical_training_describe,
                                            @ApiParam(value = "实训计划")@RequestParam(required = true) String practical_training_plan){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9401);
            modelAndView.addObject("message","添加失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.addPractical(course_id,practical_training_describe,practical_training_describe);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","添加成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("删除一个实训任务")
    @RequestMapping(value = "/DeletePracticing",method = RequestMethod.POST)
    public Map<String,Object>  DeletePracticing(ModelAndView modelAndView,
                                            @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                            @ApiParam(value = "实训id")@RequestParam(required = true) Integer practical_training_id){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","删除失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.deletePracticing(practical_training_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","删除成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("我的全部任务列表")
    @RequestMapping(value = "/Mytask",method = RequestMethod.GET)
    public Map<String,Object>  Mytask(ModelAndView modelAndView,
                                                @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                                @ApiParam(value = "状态")@RequestParam(required = true) Integer state){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","删除失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.getMyTaskList(teacher_id,state);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","删除成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }

    @ApiOperation("发布新任务")
    @RequestMapping(value = "/NewTask",method = RequestMethod.POST)
    public Map<String,Object>  NewTask(ModelAndView modelAndView,
                                      @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                       @ApiParam(value = "课程id")@RequestParam(required = true) Integer course_id,
                                       @ApiParam(value = "任务名称")@RequestParam(required = true) String task_name,
                                       @ApiParam(value = "任务类型")@RequestParam(required = true) Integer task_type,
                                       @ApiParam(value = "任务开始时间")@RequestParam(required = true) String task_start_time,
                                       @ApiParam(value = "任务结束时间")@RequestParam(required = true) String task_end_time,
                                       @ApiParam(value = "任务是否发布")@RequestParam(required = true) Integer task_publish,
                                       @ApiParam(value = "任务链接")@RequestParam(required = true) String  task_link){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9401);
            modelAndView.addObject("message","添加失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.addNewTask(course_id,task_name,task_type,task_start_time,task_end_time,task_publish,task_link);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","添加成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }
    @ApiOperation("删除一个任务")
    @RequestMapping(value = "/DeleteTask",method = RequestMethod.POST)
    public Map<String,Object>  DeleteTask(ModelAndView modelAndView,
                                                @ApiParam(value = "教师id")@RequestParam(required = true) Integer teacher_id,
                                                @ApiParam(value = "任务id")@RequestParam(required = true) Integer task_id){
        Teacher teacher = courseService.getTeacherById(teacher_id);
        if(teacher == null){
            modelAndView.addObject("result_code",9501);
            modelAndView.addObject("message","删除失败，权限不足!");
            modelAndView.addObject("return_data",null );
        }
        courseService.deleteTask(task_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message","删除成功！");
        modelAndView.addObject("return_data", null);
        return  modelAndView.getModel();
    }

}
