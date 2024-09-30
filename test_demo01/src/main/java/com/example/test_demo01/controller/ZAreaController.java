package com.example.test_demo01.controller;


import com.example.test_demo01.common.RESTTableResult;
import com.example.test_demo01.domain.ZArea;
import com.example.test_demo01.domain.vo.ZAreaVO;
import com.example.test_demo01.service.IZAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 地区Controller
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
@RestController
@RequestMapping("/system/area")
public class ZAreaController
{
    @Autowired
    private IZAreaService zAreaService;

    /**
     * 查询地区列表
     */
    @GetMapping("/list")
    public List list(ZArea zArea)
    {

        System.out.println("开始查询");
        long startTime = System.currentTimeMillis(); // 记录开始时间

        List<ZArea> list = zAreaService.selectZAreaList_new(zArea);

        long endTime = System.currentTimeMillis(); // 记录结束时间
        long duration = endTime - startTime; // 计算执行时间

        System.out.println("查询结束");
        System.out.println("查询时间是 " + duration + " milliseconds.");

        return list;
    }

}
