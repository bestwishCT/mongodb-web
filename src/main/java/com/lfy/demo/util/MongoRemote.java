package com.lfy.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cybermkd.mongo.kit.MongoKit;
import com.cybermkd.mongo.kit.MongoQuery;
import com.cybermkd.mongo.kit.MongoValidate;
import com.cybermkd.mongo.kit.page.MongoPaginate;
import com.cybermkd.mongo.plugin.MongoPlugin;
import com.mongodb.MongoClient;

public class MongoRemote {
	/**
	 * 远程连接
	 * @param args
	 */
	public static void main(String[] args) {

		// 客户端 链接
		// = <>
		// like
		// 分页
		// 全文搜索(建索引语句，查数据等)
		// 返回指定字段
		// in 查询
		// 有密码与无密码的连接
		MongoPlugin mongoPlugin = new MongoPlugin();
		mongoPlugin.add("39.105.72.48", 30000);
		// 数据库
		mongoPlugin.setDatabase("miner_data");
		// 授权账号 密码
		mongoPlugin.auth("miner_db_u", "shiye1805A");

		MongoClient client = mongoPlugin.getMongoClient();
		MongoKit.INSTANCE.init(client, mongoPlugin.getDatabase());
		//创建query条件，用于存放条件
		MongoQuery query = new MongoQuery();
		// 集合
		List<String> categoryList=new ArrayList<String>();
		categoryList.add("PrivateFundCompany");
//		List<JSONObject> obs = query.use("company_tag").eq("company_name", "广发银行股份有限公司深圳万象支行").projection("company_name").find();
		query.use("investor_statistic_bak").in("category", categoryList).descending("modify_time");
		//query,每页显示的条数，页码
		MongoPaginate page=new MongoPaginate(query,20,1);
		List<JSONObject> obs=page.find().getList();
		//统计数量
		long count=query.use("investor_statistic_bak").in("category", categoryList).count();
		System.out.println("统计条数："+count);
		// MongoPaginate page=new MongoPaginate(new MongoQuery().use("company_tag").eq("tag_id",
		// "0009").projection("company_name","reg_city","modify_time").descending("modify_time"),2,2);
		
		for (JSONObject ob : obs) {
			System.out.println(ob);
		}

		client.close();

	}

}
