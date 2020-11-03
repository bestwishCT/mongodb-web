package com.lfy.demo.util;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;

public class MongoDemo {

	public static void main(String[] args) {

		//数据库
		String dbName = "mydbone";
		String collName = "company_tag";
		// 获取客户端->获取指定数据库->获取指定集合
		MongoCollection<Document> collection = MongoUtil.instance.getCollection(dbName, collName);
		FindIterable<Document> findIterable = collection.find(new Document()).projection(Projections.fields(Projections.include("reg_capital", "company_name"),Projections.excludeId()));
		MongoCursor<Document> tCursor = findIterable.iterator();
		// 数据处理
				while (tCursor.hasNext()) {
					org.bson.Document _doc = (Document) tCursor.next();
					System.out.println(_doc.toString());
				}
				// 关闭
				MongoUtil.instance.close();
	}

}
