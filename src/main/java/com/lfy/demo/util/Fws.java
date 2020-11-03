package com.lfy.demo.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cybermkd.mongo.kit.MongoKit;
import com.cybermkd.mongo.kit.MongoQuery;
import com.cybermkd.mongo.kit.aggregation.MongoAggregation;
import com.cybermkd.mongo.kit.page.MongoPaginate;
import com.cybermkd.mongo.plugin.MongoPlugin;
import com.mongodb.MongoClient;

public class Fws {
	public static void main(String[] args) {
		//客户端 链接
		//等于 <>
		//like 
		//分页
		//全文搜索(建立与搜索)
		//返回指定字段
		//时间格式区间判断
		//时间返回格式
		MongoPlugin mongoPlugin = new MongoPlugin();
		mongoPlugin.add("127.0.0.1", 27017);
		// 数据库
		mongoPlugin.setDatabase("mydbone");
		MongoClient client = mongoPlugin.getMongoClient();
		MongoKit.INSTANCE.init(client, mongoPlugin.getDatabase());
		MongoQuery query = new MongoQuery();
		// 集合
//		List<JSONObject> obs = query.use("company_tag").like("company_name", "广州").projection("company_name","reg_city").find();
		//多个关键词 用空格隔开  不包括的话前面用-分隔
		List<JSONObject> obs = query.use("company_tag").text("锡山区  -南山区").find();
		
		
		//		MongoPaginate page=new MongoPaginate(new MongoQuery().use("company_tag").eq("tag_id", "0009").projection("company_name","reg_city","modify_time").descending("modify_time"),2,2);
//		List<JSONObject> obs=page.find().getList();
		for (JSONObject ob : obs) {
			System.out.println(ob);
		}

		client.close();
	}
}
