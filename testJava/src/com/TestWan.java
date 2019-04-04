package com;
/*
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;*/

/**
 * Created by meridian on 2018/9/30.
 */
public class TestWan {
    public static void main(String[] args) throws  Exception{

        /*List<Integer> list = new ArrayList(){
            {
                add(new Integer("1"));
                add(new Integer("1"));
                add(new Integer("12"));
                add(new Integer("1"));
                add(new Integer("12"));
                add(new Integer("1"));
                add(new Integer("12"));
                add(new Integer("1"));
            }
        };
        System.out.println("------------->"+list.toString());*/
       /* Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ":" + v));
*/
        /*Student stu = new Student();
        stu.setSex(1);
        stu.setPhone("997757623e3");
        stu.setName("lisi");
        stu.setAge(2);
        MonitorEarlywarnOrAlarmParam p1 = new MonitorEarlywarnOrAlarmParam();
        p1.setOneMaxSymbol("<");
        p1.setOneMaxValue("324");
        stu.setParam(p1);
        Student stu1 = new Student();
        stu1.setSex(1);
        stu1.setPhone("9977576343");
        stu1.setName("zhangsan");
        stu1.setAge(2);
        MonitorEarlywarnOrAlarmParam p2 = new MonitorEarlywarnOrAlarmParam();
        p2.setOneMaxSymbol("<=");
        p2.setOneMaxValue("325");
        stu1.setParam(p2);
        Student stu2 = new Student();
        stu2.setSex(1);
        stu2.setPhone("");
        stu2.setName("wangwu");
        stu2.setAge(2);
        MonitorEarlywarnOrAlarmParam p3 = new MonitorEarlywarnOrAlarmParam();
        p3.setOneMaxSymbol(">");
        p3.setOneMaxValue("34");
        stu2.setParam(p3);
        //System.out.println(JSON.toJSONString(stu, true));
        Map<String, List<Student>> map = new HashMap<>();*/
      /*  map.put("boolean", true);
        map.put("string", "abc");
        map.put("int", 123);*/
      /*  List<Student> stuList = Lists.newArrayList();
        stuList.add(stu);
        stuList.add(stu1);
        stuList.add(stu2);
        map.put("array",stuList);*/
        /*Map<String, Object> subMap = new HashMap<>();
        subMap.put("key1", "value1");
        subMap.put("key2", "value2");
        map.put("map", subMap);*/

       // System.out.println(, true));
       /* String str = JSON.toJSONString(stuList,true);
        System.out.println(str);
        System.out.println("-----------------------");
        List<Student> s = JSONObject.parseArray(str, Student.class);
        for (Student su:s) {
            System.out.println(su.toString());
        }*/
/*
       String str = "用户**在";
        str = str.replace("**","张三");
        System.out.println(str);*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = null;
        Date date = sdf1.parse(time);*/

       /* Map<String,String> map = new HashMap();
        map.put("A","A:A1;A2-160;A3,B:78");*/
       /* map.put("B","A:A1;A2-160;A3,B:78");
        map.put("C","A:A1;A2-160;A3,B:78");
        map.put("D","A:A1;A2-160;A3,B:78");*/
        //System.out.println(map.values().stream().collect(Collectors.joining(",")));

        /*System.out.println(552/60);
        System.out.println(552%60);
        String ids = "1,2,3,4,";
        ids = "("+ids.substring(0,ids.length()-1)+")";
        System.out.println(ids);*/

        Integer i = null;
        int b = i;
    }
}
