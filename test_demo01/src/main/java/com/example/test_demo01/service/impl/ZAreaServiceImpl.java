package com.example.test_demo01.service.impl;

import com.example.test_demo01.domain.ZArea;
import com.example.test_demo01.domain.vo.ZAreaVO;
import com.example.test_demo01.mapper.ZAreaMapper;
import com.example.test_demo01.service.IZAreaService;
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
public class ZAreaServiceImpl implements IZAreaService
{
    @Autowired
    private ZAreaMapper zAreaMapper;



    /**
     * 查询地区列表
     * 
     * @param zArea 地区
     * @return 地区
     */
    @Override
    public List<ZAreaVO> selectZAreaList(ZArea zArea) {
        List<ZArea> list = zAreaMapper.selectZAreaList(zArea);

        // 找到目标对象
        ZArea targetZArea = list.stream()
                .filter(z -> "CN".equals(z.getId()))
                .findFirst()
                .orElse(null);

        if (targetZArea != null) {
            // 从原位置移除
            list.remove(targetZArea);
            // 添加到列表的第一个位置
            list.add(0, targetZArea);
        }

        List<ZAreaVO> voList = new ArrayList<>();

        BeanUtils.copyProperties(list, voList);

        // 处理地区树
        for (ZArea zArea1 : list) {
            // 父节点
            ZAreaVO zAreaVO1 = new ZAreaVO();
            BeanUtils.copyProperties(zArea1, zAreaVO1);
            //查询子节点是否为空
            //构建查询条件
            ZArea zAreaCheck = new ZArea();
            if(zArea1.getLevel() == null || zArea1.getLevel() == 0){
                zAreaCheck.setLevel(1L);
            }else{
                zAreaCheck.setLevel(zArea1.getLevel() + 1);
            }
            //查询子节点
            if(zAreaCheck.getLevel() == 1){
                zAreaCheck.setParentId(zArea1.getId());
            }
            if(zAreaCheck.getLevel() == 2){
                zAreaCheck.setParentId2(zArea1.getParentId());
                zAreaCheck.setParentId(zArea1.getId());
            }

            List<ZArea> list1 = zAreaMapper.selectZAreaList(zAreaCheck);
            if(list1.size() == 0){
                //zAreaVO1.setLeaf(false);
            }else {
                //zAreaVO1.setLeaf(true);
            }
            voList.add(zAreaVO1);
        }



        return voList;
    }

    @Override
    public List<ZArea> selectZAreaList_new(ZArea zArea) {
        return zAreaMapper.selectZAreaList(zArea);
    }


}
