package com.yzedu.service;

import com.yzedu.dao.HappyReadDao;
import com.yzedu.vo.HappyReadBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangbenben on 2018/5/26 0026
 */
@Service
public class HappyReadService {

    @Resource
    public HappyReadDao happyReadDao;

    public List<HappyReadBean> getHappyReadList(){

        return happyReadDao.getHappyReadList();
    }
}
