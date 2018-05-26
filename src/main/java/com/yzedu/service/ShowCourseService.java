package com.yzedu.service;

import com.yzedu.dao.ShowCourseDao;
import com.yzedu.vo.CourseBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class ShowCourseService {
    @Resource
    private ShowCourseDao showCourseDao;

    public List<CourseBean> showCourseList(){
       return showCourseDao.showCourseList();

    }
}
