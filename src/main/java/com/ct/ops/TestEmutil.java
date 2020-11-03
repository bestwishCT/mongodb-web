package com.ct.ops;

public class TestEmutil {
public static void main(String[] args) {
	System.out.println("开始####################");
	String productLabel="生物制品#血液制品#免疫球蛋白类制品#<em>静注人免疫球蛋白</em>#|生物制品#血液制品#凝血因子类制品#人凝血因子制品..";
	String reg="\\|";
	String hitRedFlg="<em>";
	String returnStr="";
	String [] prodarr=productLabel.split(reg);
	for(String pro:prodarr){
		if(pro.contains(hitRedFlg)){
			returnStr=pro;
			break;
		}
	}
	System.out.println(returnStr);
	System.out.println("结束####################");
}
}
