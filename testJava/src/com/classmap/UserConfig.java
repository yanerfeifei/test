package com.classmap;

import java.io.Serializable;

import lombok.Data;

/**
 * 功能说明：用户登陆时，需要更新的配置文件实体封装类
 * 相关的模块均默认开启 如需要关闭，请通过disable方法禁用
 * @author xiaoyu
 * @date 2018/6/13
 */
@Data
public class UserConfig implements Serializable {

    /**
     * 家庭医生签约服务模块是否启用 Android通过此模块来配置启用
     * 1:启用 2:禁用
     * 默认：启用
     */
    private int familyDoctorSignServiceModule = 1;

    /**
     * 公卫随访管理模块是否启用  Android通过此模块来配置启用
     * 1:启用 2:禁用
     * 默认：启用
     */
    private int gwSuifangSerivceModule = 1;

    /**
     * 一体机查询模块是否启用  Android通过此模块来配置启用
     * 1:启用 2:禁用
     * 默认：启用
     */
    private int ytjQueryModule = 1;

    /**
     * 转诊服务模块是否启用  Android通过此模块来配置启用
     * 1:启用 2:禁用
     * 默认：启用
     */
    private int gwZhuanzhenModule = 1;

    /**
     * 扶贫动态模块是否启用  Android通过此模块来配置启用
     * 1:启用 2:禁用
     * 默认：启用
     */
    private int fuPinModule = 1;

    /**
     * 是否仅开通快速创建的用户（公卫帐号搜索的功能不展示了）
     * 1:启用 2:禁用
     * 默认： 禁用
     */
    private int onlyQuickUser = 2;
    /**
     * 人脸识别模块是否启用  Android通过此模块来配置启用
     * 1:启用 2:禁用
     * 默认：启用
     */
    private int faceRecognition= 1;

}
