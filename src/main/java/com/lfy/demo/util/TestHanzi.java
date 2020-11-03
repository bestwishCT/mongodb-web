package com.lfy.demo.util;

public class TestHanzi {

	public static void main(String[] args) {
		//和合数据科技(深圳)有限公司     
		//和合数据科技（深圳）有限公司
		String c1="和合数据科技(深圳)有限公司";
		String c2="和合数据科技（深圳）有限公司";
		if(c2.contains("(")){
			System.out.println(c2+"包含英文括弧");
		}
		if(c2.contains("（")){
			System.out.println(c2+"包含中文括弧");
		}
	}

}
