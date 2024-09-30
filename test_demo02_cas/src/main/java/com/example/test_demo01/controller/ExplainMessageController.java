package com.example.test_demo01.controller;


import com.example.test_demo01.common.RESTTableResult;
import com.example.test_demo01.domain.ExplainMessage;
import com.example.test_demo01.service.ExplainMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地区Controller
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
@RestController
@RequestMapping("/explain")
public class ExplainMessageController
{
    @Autowired
    private ExplainMessageService explainMessageService;

    /**
     * 查询地区列表
     */
    @GetMapping("/apply")
    public RESTTableResult apply(int id)
    {
        RESTTableResult apply = explainMessageService.apply(id);

        return apply;
    }

}
