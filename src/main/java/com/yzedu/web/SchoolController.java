package com.yzedu.web;

import com.yzedu.service.AboutService;
import com.yzedu.service.AnnouncementService;
import com.yzedu.service.InformationService;
import com.yzedu.util.Constant;
import com.yzedu.util.PageModel;
import com.yzedu.vo.AnnouncementBean;
import com.yzedu.vo.InformationBean;
import com.yzedu.vo.SchoolBean;
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
@RequestMapping("/school")
public class SchoolController {

    @Resource
    private AboutService aboutService;

    @Resource
    private InformationService informationService;

    @Resource
    private AnnouncementService announcementService;

    @ApiOperation("院校基本信息")
    @RequestMapping(value = "/About",method = RequestMethod.GET)
    public Map<String,Object> getAbout(ModelAndView modelAndView,
                                       @ApiParam(value = "学校id") @RequestParam(required = true,defaultValue = "1") Integer school_id){

        List<SchoolBean> schoolBeanList = aboutService.getAboutList(school_id);

        modelAndView.addObject("result_code",Constant.SUCCESS_CODE);
        modelAndView.addObject("message",Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data",schoolBeanList);
        return modelAndView.getModel();

    }
    @ApiOperation("院校资讯列表")
    @RequestMapping(value = "/Information",method = RequestMethod.GET)
    public Map<String,Object> getInformation(ModelAndView modelAndView,
                                       @ApiParam(value = "学校id") @RequestParam(required = true) Integer school_id,
                                       @ApiParam(value = "分页") @RequestParam(required = true,defaultValue = "1") Integer page ) {

        List<InformationBean> informationBeanList = informationService.getInformationList(school_id);
        //对List进行分页处理
        PageModel pageModel = new PageModel(informationBeanList, 12);
        List<InformationBean> sublist = pageModel.getObjects(page);
        for(InformationBean ib: informationBeanList){
            if(ib.getInformation_images()!=null) {
                ib.setInformation_cover(ib.getInformation_images().get(0));
                ib.setInformation_image_count(ib.getInformation_images().size());
            }
        }
        modelAndView.addObject("result_code", Constant.SUCCESS_CODE);
        modelAndView.addObject("message", Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", sublist);
        return modelAndView.getModel();
    }
    @ApiOperation("院校公告列表")
    @RequestMapping(value = "/Announcement",method = RequestMethod.GET)
    public Map<String,Object> getAnnouncement(ModelAndView modelAndView, @ApiParam(value = "学校id") @RequestParam(required = true) Integer school_id,
                                              @ApiParam(value = "分页") @RequestParam(required = true,defaultValue = "1") Integer page){

        List<AnnouncementBean> announcementBeanList =announcementService.getannouncementList(school_id);
        //对List进行分页处理
        PageModel pageModel = new PageModel( announcementBeanList , 12);
        List<InformationBean> sublist = pageModel.getObjects(page);

        modelAndView.addObject("result_code", Constant.SUCCESS_CODE);
        modelAndView.addObject("message", Constant.SUCCESS_MESSAGE);
        modelAndView.addObject("return_data", sublist);
        return modelAndView.getModel();

    }
}
