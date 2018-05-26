package com.yzedu.web;

import com.yzedu.service.*;
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
 * @author zhangbenben on 2018/1/4 0004
 */
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Resource
    private PlatformService platformService;

    @Resource
    private BannerService bannerService;

    @Resource
    private SchoolsService schoolsService;

    @Resource
    private ShowCourseService showCourseService;

    @Resource
    private HappyReadService happyReadService;


    @RequestMapping("/Information")
    public Map<String,Object> getInformation(@ApiParam(value = "分页")@RequestParam(required = true,defaultValue = "1") Integer page,
                                             ModelAndView modelAndView){
        List<InformationBean> ibs = platformService.getInformations();
        //对List进行分页处理
        PageModel pageModel=new PageModel(ibs,2);
        List<InformationBean> sublist = pageModel.getObjects(page);
        for(InformationBean ib: ibs){
            if(ib.getInformation_images()!=null) {
                ib.setInformation_cover(ib.getInformation_images().get(0));
                ib.setInformation_image_count(ib.getInformation_images().size());
            }
        }
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",sublist);
        return  modelAndView.getModel();
    }
    @ApiOperation("查看banner列表")
    @RequestMapping(value = "/Banner",method = RequestMethod.GET)
    public Map<String,Object> getBanners(@ApiParam(value = "院校id")@RequestParam Integer school_id,
                                         ModelAndView modelAndView){

        List<BannerBean> bannerBeanList = bannerService.getBannerList(school_id);
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",bannerBeanList);
        return modelAndView.getModel();
    }
    @ApiOperation("所有院校列表")
    @RequestMapping(value = "/Schools",method = RequestMethod.GET)
    public Map<String,Object> getSchools(ModelAndView modelAndView){

        List<SchoolBean> schoolBeanList = schoolsService.getSchools();
        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",schoolBeanList);
        return modelAndView.getModel();
    }
    @ApiOperation("展示课程列表")
    @RequestMapping(value = "/ShowCourse",method = RequestMethod.GET)
    public Map<String,Object> getSchools(ModelAndView modelAndView,
                                         @ApiParam(value = "分页")@RequestParam(required = true,defaultValue = "1") Integer page){

        List<CourseBean> courseBeanList = showCourseService.showCourseList();
        //对List进行分页处理
        PageModel pageModel=new PageModel(courseBeanList,2);
        List<InformationBean> sublist = pageModel.getObjects(page);

        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",sublist);
        return modelAndView.getModel();
    }
    @ApiOperation("每日悦读内容")
    @RequestMapping(value = "/HappyRead",method = RequestMethod.GET)
    public Map<String,Object> getHappyRead(ModelAndView modelAndView){

        List<HappyReadBean> happyReadBeanList = happyReadService.getHappyReadList();

        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",happyReadBeanList);
        return modelAndView.getModel();
    }

}
