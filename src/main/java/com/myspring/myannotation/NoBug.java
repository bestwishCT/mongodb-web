package com.myspring.myannotation;

public class NoBug {
    @JieCha
    public void suanShu(){
        System.out.println("1234567890");
    }
    @JieCha
    public void jiafa(){
        System.out.println("1+1="+1+1);
    }
    @JieCha
    public void jiefa(){
        System.out.println("1-1="+(1-1));
    }
    @JieCha
    public void chengfa(){
        System.out.println("3 x 5="+ 3*5);
    }
    @JieCha
    public void chufa(){
        System.out.println("6 / 0="+ 6 / 0);
    }
    public void ziwojieshao(){
        System.out.println("我写的程序没有 bug!");
    }
}
