package com.classmap;

import lombok.Data;

/**
 * @author Dy
 */
@Data
public class RobotFunction  {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 修改时间
     */
    private java.util.Date updateTime;

    /**
     * 匹配终端 G:政府,B企业,GB两者
     */
    private String terminal;

    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能安卓标识
     */
    private String android;

    /**
     * 功能地址url
     */
    private String url;
    /**
     * 是否启用 0:默认;1:启用 2:禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 修改人id
     */
    private String updater;
    /**
     * 添加人id
     */
    private String creater;
}
