package com.hwadee.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.order.pojo.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}