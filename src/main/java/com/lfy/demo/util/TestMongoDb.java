package com.lfy.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class TestMongoDb {

	public static void main(String[] args) {
		//数据库
		String dbName = "mydbone";
		String collName = "company_tag";
		// 获取客户端->获取指定数据库->获取指定集合
		MongoCollection<Document> coll = MongoUtil.instance.getCollection(dbName, collName);
		//存储集合MongoCursor
		//其通过collection类的find方法获取查询结果并通过.iterator()方法返回该MongoCursor类
		//获取 company_name等于
//		BasicDBObject dbObject = new BasicDBObject("$eq", "江苏恒兴新材料科技股份有限公司");
//		// 指定判别的字段
//		BasicDBObject identification = new BasicDBObject("company_name",dbObject);
		
		// 使用List来连接需要用逻辑关联词串联起来的条件语句
//		List<DBObject> criteria = new ArrayList<>();
		BasicDBList criteria = new BasicDBList(); 
		//reg_capital>=1200
		criteria.add(new BasicDBObject("reg_capital", new BasicDBObject("$gte",1200)));
		//company_name='江苏恒兴新材料科技股份有限公司'
		criteria.add(new BasicDBObject("company_name", new BasicDBObject("$eq","江苏恒兴新材料科技股份有限公司")));
		
		
		//AND连接
		MongoCursor<Document> tCursor = coll.find(new BasicDBObject("$and", criteria)).iterator();
		// 数据处理
		while (tCursor.hasNext()) {
			org.bson.Document _doc = (Document) tCursor.next();
			System.out.println(_doc.toString());
		}
		// 关闭
		MongoUtil.instance.close();

	}

}
