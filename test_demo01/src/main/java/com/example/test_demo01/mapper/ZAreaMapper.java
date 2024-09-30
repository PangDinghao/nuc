package com.example.test_demo01.mapper;

import com.example.test_demo01.domain.ZArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 地区Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
@Mapper
public interface ZAreaMapper 
{


    /**
     * 查询地区列表
     * 
     * @param zArea 地区
     * @return 地区集合
     */
    public List<ZArea> selectZAreaList(ZArea zArea);

    public int updateZArea(ZArea zArea);

}
