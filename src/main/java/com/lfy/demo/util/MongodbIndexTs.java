package com.lfy.demo.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cybermkd.mongo.kit.MongoKit;
import com.cybermkd.mongo.kit.index.MongoIndex;
import com.cybermkd.mongo.plugin.MongoPlugin;
import com.mongodb.MongoClient;

public class MongodbIndexTs {

	public static void main(String[] args) {
		MongoPlugin mongoPlugin = new MongoPlugin();
		mongoPlugin.add("127.0.0.1", 27017);
		// 数据库
		mongoPlugin.setDatabase("mydbone");
		MongoClient client = mongoPlugin.getMongoClient();
		MongoKit.INSTANCE.init(client, mongoPlugin.getDatabase());
		//Mongodb索引对象
		MongoIndex index=new MongoIndex("company_tag");
		index.text("reg_district").text("company_name").save();
		//增加索引
//		index.add(index).compound();
		
		
		
//		List<JSONObject> indexs=index.get();
//		for (JSONObject ob : indexs) {
//			System.out.println(ob);
//		}
	}

}
