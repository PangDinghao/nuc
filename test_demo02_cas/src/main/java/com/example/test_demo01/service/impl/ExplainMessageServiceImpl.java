package com.example.test_demo01.service.impl;

import com.example.test_demo01.common.RESTTableResult;
import com.example.test_demo01.domain.ExplainMessage;
import com.example.test_demo01.mapper.ExplainMessageMapper;
import com.example.test_demo01.service.ExplainMessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 地区Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
@Service
public class ExplainMessageServiceImpl implements ExplainMessageService
{
    @Autowired
    private ExplainMessageMapper explainMessageMapper;


    @Override
    public RESTTableResult apply(int id) {
        //1.查询展会
        ExplainMessage explainMessage = explainMessageMapper.selectExplainMessage(id);
        //2.判断展会剩余报名人数是否存在
        if (explainMessage.getApplyNumber() >= explainMessage.getApplyNumberMax()){
            return RESTTableResult.fail("报名人数已满");
        }
        //3.报名
        int i = explainMessageMapper.applyExplain(explainMessage);

        if (i == 1){
            return RESTTableResult.success("报名成功");
        }else {
            return RESTTableResult.fail("报名失败");
        }
    }
}
