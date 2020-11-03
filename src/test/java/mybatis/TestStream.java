package mybatis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.sf.json.JSONObject;

public class TestStream {
    public static void main(String[] args) {
//        问题：如何去掉List集合中重复的元素
        List<String> words = Arrays.asList("a","b","c","c","d","e","e","g","f");

        //        方案一：使用set集合
        Set<String> set = new HashSet<>();
        for (String word : words){
            set.add(word);

        }
        for (String word : set){
            System.out.println(word);
        }

        System.out.println("--------------------");
        //        方案二：通过jdk8提供的stream流的方式去重
        words.stream()//将list集合准换成stream流
                .distinct()//去重
                .collect(Collectors.toList())//将流转化为list集合
                .forEach(System.out::println);//循环打印
        
        
        
        
        
        List<List<JSONObject>> fw=new ArrayList<List<JSONObject>>();
        
        List<JSONObject> ls1=new ArrayList<JSONObject>();
        JSONObject ob1=new JSONObject();
        ob1.put("compName", "北京金堤科技有限公司");
        ob1.put("type", "N100");
        ls1.add(ob1);
        JSONObject ob2=new JSONObject();
        ob2.put("type", "A0100");
        ob2.put("ratio", 100);
        ls1.add(ob2);
        JSONObject ob3=new JSONObject();
        ob3.put("compName", "北京天眼查科技有限公司");
        ob3.put("type", "N100");
        ls1.add(ob3);
        fw.add(ls1);//add
        List<JSONObject> ls3=new ArrayList<JSONObject>();
        JSONObject ob3_1=new JSONObject();
        ob3_1.put("compName", "北京金堤科技有限公司");
        ob3_1.put("type", "N100");
        ls3.add(ob3_1);
        JSONObject ob3_2=new JSONObject();
        ob3_2.put("type", "AB100");
        ob3_2.put("ratio", 100);
        ls3.add(ob3_2);
        JSONObject ob3_3=new JSONObject();
        ob3_3.put("compName", "北京天眼查科技有限公司");
        ob3_3.put("type", "N100");
        ls3.add(ob3_3);
        fw.add(ls3);//add
        
        List<JSONObject> ls2=new ArrayList<JSONObject>();
        JSONObject ob2_1=new JSONObject();
        ob2_1.put("compName", "北京金堤科技有限公司");
        ob2_1.put("type", "N100");
        ls2.add(ob2_1);
        JSONObject ob2_2=new JSONObject();
        ob2_2.put("type", "A0100");
        ob2_2.put("ratio", 100);
        ls2.add(ob2_2);
        JSONObject ob2_3=new JSONObject();
        ob2_3.put("compName", "北京天眼查科技有限公司");
        ob2_3.put("type", "N100");
        ls2.add(ob2_3);
        fw.add(ls2);//add
        System.out.println(fw);
        System.out.println("===========================成败在此一举===============");
        fw.stream()//将list集合准换成stream流
        .distinct()//去重
        .collect(Collectors.toList())//将流转化为list集合
        .forEach(System.out::println);//循环打印
        
        
        
    }
}