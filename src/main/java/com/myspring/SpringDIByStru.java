package com.myspring;
//基于构造函数的依赖注入
public class SpringDIByStru {
	private DogDi dogDi;
	private String str;
	public DogDi getDogDi() {
		return dogDi;
	}
	public void setDogDi(DogDi dogDi) {
		this.dogDi = dogDi;
	}
	public SpringDIByStru(String str){
		System.out.println("构造"+str);
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public SpringDIByStru(DogDi dogDi,String str){
		this.dogDi=dogDi;
		System.out.println("构造"+str);
	}
	public void diDesc(){
		dogDi.dogDidesc();
		System.out.println("di method");
	}
}
