package com.example.test_demo01;

import com.example.test_demo01.domain.ZArea;
import com.example.test_demo01.domain.vo.ZAreaVO;
import com.example.test_demo01.mapper.ZAreaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestDemo01ApplicationTests {
    @Autowired
    ZAreaMapper zAreaMapper;

    List<String> lsit = new ArrayList<>();

    @Test
    void testdemo01() {

        List<ZArea> zAreas = zAreaMapper.selectZAreaList(new ZArea());
        for(ZArea zArea : zAreas) {
            // 父节点
            ZArea zArea_new = new ZAreaVO();
            BeanUtils.copyProperties(zArea, zArea_new);
            //查询子节点是否为空
            //构建查询条件
            ZArea zAreaCheck = new ZArea();
            //一级地区
            if(zArea.getLevel() == null || zArea.getLevel() == 0){
                zAreaCheck.setLevel(1L);
            }else{
                zAreaCheck.setLevel(zArea.getLevel() + 1);
            }

            //查询子节点
            if(zAreaCheck.getLevel() == 1){
                zAreaCheck.setParentId(zArea.getId());
            }
            if(zAreaCheck.getLevel() == 2){
                zAreaCheck.setParentId2(zArea.getParentId());
                zAreaCheck.setParentId(zArea.getId());
            }

            List<ZArea> areaChildList = zAreaMapper.selectZAreaList(zAreaCheck);
            if(areaChildList.size() == 0){
                zArea_new.setLeaf(0);
            }else {
                zArea_new.setLeaf(1);
            }

            //更新子节点
            zAreaMapper.updateZArea(zArea_new);

        }


    }

}
