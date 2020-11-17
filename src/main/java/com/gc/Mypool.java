package com.gc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mypool {
	public static void main(String[] args) {
		ExecutorService es=Executors.newCachedThreadPool();
		ExecutorService es1=Executors.newSingleThreadExecutor();
		ExecutorService es2=Executors.newCachedThreadPool();
		
		ConcurrentHashMap<String, Object> chs=new ConcurrentHashMap<String, Object>();
		ThreadLocal<String> s=new ThreadLocal<String>();
	}

}
