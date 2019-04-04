package com.json;

import java.io.Serializable;
import java.util.List;

/**
 * 西医诊断项目简化实体
 * Created by wangzhengyun on 2017-11-09 14:30.
 */
public class WesternMedicineItemParam implements Serializable {

    /**
     * serialVersionUID
     **/
    private static final long serialVersionUID = -3884394888907248357L;
    //症状名称
    String smptomnames = "";
    //项目编码
    String itemCode;
    //项目名称
    String itemName;
    //2018-03-16添加icdcode
    String icdcode;
    //ICD10編碼
    private String icd10;
    //子项目集合
    List<WesternMedicineItemParam> childItem;
    //急重症标识
    boolean emergencyFlag = false;

    //排序
    private int sort;

    //是否存在可疑疾病
    boolean existSuspectDisease = false;

    //是否存在子级
    boolean existChildItem = false;

    //判斷條件/
    private String judgingCondition;
    
    //药物治疗中所需的药物类别[0:非药物治疗;1:药物治疗;]
    private int nineDrugType=0;

    public String getSmptomnames() {
        return smptomnames;
    }

    public void setSmptomnames(String smptomnames) {
        this.smptomnames = smptomnames;
    }

    boolean checked = false;
    

    public String getIcdcode() {
		return icdcode;
	}

	public void setIcdcode(String icdcode) {
		this.icdcode = icdcode;
	}

	public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<WesternMedicineItemParam> getChildItem() {
        return childItem;
    }

    public void setChildItem(List<WesternMedicineItemParam> childItem) {
        this.childItem = childItem;
    }

    public boolean isEmergencyFlag() {
        return emergencyFlag;
    }

    public void setEmergencyFlag(boolean emergencyFlag) {
        this.emergencyFlag = emergencyFlag;
    }

    public boolean isExistSuspectDisease() {
        return existSuspectDisease;
    }

    public void setExistSuspectDisease(boolean existSuspectDisease) {
        this.existSuspectDisease = existSuspectDisease;
    }

    public String getJudgingCondition() {
        return judgingCondition;
    }

    public void setJudgingCondition(String judgingCondition) {
        this.judgingCondition = judgingCondition;
    }

    public boolean isExistChildItem() {
        return existChildItem;
    }

    public void setExistChildItem(boolean existChildItem) {
        this.existChildItem = existChildItem;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
    
    public int getNineDrugType() {
		return nineDrugType;
	}

	public void setNineDrugType(int nineDrugType) {
		this.nineDrugType = nineDrugType;
	}

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }
}
