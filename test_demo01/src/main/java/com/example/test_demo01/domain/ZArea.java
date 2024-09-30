package com.example.test_demo01.domain;

import lombok.Data;

/**
 * 地区对象 z_area
 * 
 * @author ruoyi
 * @date 2024-07-04
 */
@Data
public class ZArea
{
    private static final long serialVersionUID = 1L;

    /** 城市代码 */
    private String id;

    /** 语言类型 */

    private String languageType;

    /** 地区名称 */
    private String areaName;

    /** 父级 */

    private String parentId;

    /** 爷级 */

    private String parentId2;

    /** 太爷爷级 */

    private String parentId3;

    /** 级别 */
    private Long level;

    private int leaf;

}
