package com.classmap;

/*import com.alibaba.fastjson.JSON;*/

/**
 * Created by meridian on 2018/12/10.
 */
public class ClassTest {
   /* public static void main(String[] args) {
        List<RobotFunction> functionList = Lists.newArrayList();
        RobotFunction rf1 = new RobotFunction();
        RobotFunction rf2 = new RobotFunction();
        RobotFunction rf3 = new RobotFunction();
        RobotFunction rf4 = new RobotFunction();
        RobotFunction rf5 = new RobotFunction();
        RobotFunction rf6 = new RobotFunction();
        rf1.setAndroid("fuPinModule");
        rf2.setAndroid("gwZhuanzhenModule");
        rf3.setAndroid("gwSuifangSerivceModule");
        rf4.setAndroid("onlyQuickUser");
        rf5.setAndroid("ytjQueryModule");
        rf6.setAndroid("familyDoctorSignServiceModule");
        rf1.setStatus(1);
        rf2.setStatus(1);
        rf3.setStatus(1);
        rf4.setStatus(1);
        rf5.setStatus(1);
        rf6.setStatus(1);
        functionList.add(rf1);
        functionList.add(rf2);
        functionList.add(rf3);
        functionList.add(rf4);
        functionList.add(rf5);
        functionList.add(rf6);
        Map<String,Object> funtionMap=functionList.stream().collect(Collectors.toMap(RobotFunction::getAndroid,RobotFunction::getStatus));
        for (Map.Entry<String,Object> entry:funtionMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        UserConfig userConfig = new UserConfig();
        setFieldValue(userConfig, funtionMap);
        System.out.println(userConfig.toString());
    }

    private static void setFieldValue(UserConfig userConfig, Map<String, Object> funtionMap) {
        Class cl = UserConfig.class;
        Method[] methods = cl.getDeclaredMethods();
        Field[] fields = cl.getDeclaredFields();
        for (Field field:fields){
           try {
               //属性对应的set方法名
               String fieldSetName = preSetName(field.getName());
               if(!checkSetMet(methods,fieldSetName)){
                   continue;
               }
                // 根据方法名和类型
               Method fieldSetMet = cl.getMethod(fieldSetName, field.getType());
               String value = funtionMap.get(field.getName()).toString();
               if(null != value && !"".equals(value)){
                   if(field.getType().equals("String")){
                       String fieldType = field.getType().getSimpleName();
                       if(fieldType.equals("String")){
                           fieldSetMet.invoke(userConfig,value);
                       }else if ("Date".equals(fieldType)) {
                           Date temp = parseDate(value);
                           fieldSetMet.invoke(userConfig, temp);
                       } else if ("Integer".equals(fieldType) || "int".equals(fieldType)) {
                           Integer intval = Integer.parseInt(value);
                           fieldSetMet.invoke(userConfig, intval);
                       } else if ("Long".equalsIgnoreCase(fieldType)) {
                           Long temp = Long.parseLong(value);
                           fieldSetMet.invoke(userConfig, temp);
                       } else if ("Double".equalsIgnoreCase(fieldType)) {
                           Double temp = Double.parseDouble(value);
                           fieldSetMet.invoke(userConfig, temp);
                       } else if ("Boolean".equalsIgnoreCase(fieldType)) {
                           Boolean temp = Boolean.parseBoolean(value);
                           *//*fieldSetMet.invoke(userConfig, temp);*//*
                       } else if("List".equalsIgnoreCase(fieldType)){
                           Type type=field.getGenericType();
                           if(type instanceof ParameterizedType){
                               //获取集合中的对象类型
                               Class clazz=(Class)((ParameterizedType) type).getActualTypeArguments()[0];
                              *//* List temp= JSON.parseArray(value,clazz);
                               fieldSetMet.invoke(userConfig, temp);
                           }*//*
                       } else {
                           System.out.println("not supper type" + fieldType);
                       }
                   }
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        }
    }
    //查看已有方法中是否存在某方法
    private static boolean checkSetMet(Method[] methods, String fieldSetName) {
        for (Method method:methods) {
            if(method.getName().equals(fieldSetName)){
                return true;
            }
        }
        return false;
    }
    private static Date parseDate(String datestr) {
        if (null == datestr || "".equals(datestr)) {
            return null;
        }
        try {
            String fmtstr = null;
            if (datestr.indexOf(':') > 0) {
                fmtstr = "yyyy-MM-dd HH:mm:ss";
            } else {
                fmtstr = "yyyy-MM-dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr);
            return sdf.parse(datestr);
        } catch (Exception e) {
            return null;
        }
    }
    //拼接属性对应的set方法名
    private static String preSetName(String name) {
        if(null == name || "".equals(name)){
            return null;
        }
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }*/
}
