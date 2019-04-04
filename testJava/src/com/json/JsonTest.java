package com.json;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meridian on 2018/12/17.
 */
public class JsonTest {
    public static void main(String[] args) {
        String jsonstr = "[{\"childItem\":[{\"childItem\":[{\"childItem\":[],\"smptomnames\":\"\",\"itemCode\":\"9.1.29\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"室内常通风，保持空气清新\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"}],\"smptomnames\":\"\",\"itemCode\":\"9.1\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"一般治疗\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"},{\"childItem\":[{\"childItem\":[],\"smptomnames\":\"\",\"itemCode\":\"9.2.2.1\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"红霉素\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"}],\"smptomnames\":\"\",\"itemCode\":\"9.2\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"抗感染药\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"},{\"childItem\":[{\"childItem\":[],\"smptomnames\":\"\",\"itemCode\":\"9.4.2.3.1\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"盐酸氨溴索(沐舒坦)\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"},{\"childItem\":[],\"smptomnames\":\"\",\"itemCode\":\"9.4.2.3.2\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"乙酰半胱氨酸(痰易净)\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"},{\"childItem\":[],\"smptomnames\":\"\",\"itemCode\":\"9.4.7.3.1\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"氨茶碱\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"}],\"smptomnames\":\"\",\"itemCode\":\"9.4\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"对症治疗\",\"existChildItem\":false,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"}],\"smptomnames\":\"\",\"itemCode\":\"6.14\",\"sort\":0,\"existSuspectDisease\":false,\"nineDrugType\":0,\"itemName\":\"百日咳\",\"existChildItem\":true,\"emergencyFlag\":false,\"judgingCondition\":\"\",\"checked\":false,\"icdcode\":\"\"}]";
        JSONArray jsonArray = JSONArray.fromObject(jsonstr);
        Map<String, Class<WesternMedicineItemParam>> classMap = new HashMap<String, Class<WesternMedicineItemParam>>();
        classMap.put("childItem", WesternMedicineItemParam.class);
        List<WesternMedicineItemParam> itemparamList =new ArrayList<WesternMedicineItemParam>();
        itemparamList = JSONArray.toList(jsonArray, WesternMedicineItemParam.class, classMap);
    }
}
