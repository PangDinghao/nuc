package com.example.test_demo01.mapper;

import com.example.test_demo01.domain.ExplainMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 地区Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
@Mapper
public interface ExplainMessageMapper
{



    public int applyExplain(ExplainMessage explainMessage);

    public ExplainMessage selectExplainMessage(int id);


}
