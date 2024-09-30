package com.example.test_demo01.service;


import com.example.test_demo01.common.RESTTableResult;
import com.example.test_demo01.domain.ExplainMessage;
import com.example.test_demo01.mapper.ExplainMessageMapper;

import java.util.List;

/**
 * 地区Service接口
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
public interface ExplainMessageService
{
    public RESTTableResult apply(int id);
}
