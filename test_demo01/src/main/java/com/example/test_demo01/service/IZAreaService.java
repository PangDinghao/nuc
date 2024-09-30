package com.example.test_demo01.service;


import com.example.test_demo01.domain.ZArea;
import com.example.test_demo01.domain.vo.ZAreaVO;

import java.util.List;

/**
 * 地区Service接口
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
public interface IZAreaService
{

    /**
     * 查询地区列表
     * 
     * @param zArea 地区
     * @return 地区集合
     */
    public List<ZAreaVO> selectZAreaList(ZArea zArea);
    public List<ZArea> selectZAreaList_new(ZArea zArea);

}
