package com.gc;

public class YingYongJishuSuanFa {
    public Object instance = null;
    public static void main(String[] args) {
    	YingYongJishuSuanFa a = new YingYongJishuSuanFa();
    	YingYongJishuSuanFa b = new YingYongJishuSuanFa();
        a.instance = b;
        b.instance = a;
        a = null;
        b = null;
    }
}
