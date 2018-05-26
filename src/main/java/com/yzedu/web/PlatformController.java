package com.yzedu.web;

import com.yzedu.service.PlatformService;
import com.yzedu.util.Constant;
import com.yzedu.util.PageModel;
import com.yzedu.vo.InformationBean;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private String message;

    @RequestMapping("/Information")
    public Map<String,Object> getInformation(@ApiParam(value = "分页")@RequestParam(required = true,defaultValue = "1") Integer page,
                                             ModelAndView modelAndView){
        List<InformationBean> ibs = platformService.getInformations();
        //使用工具类，对List进行分页处理
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

}
