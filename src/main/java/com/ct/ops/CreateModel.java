package com.ct.ops;
/**
 * 开放搜索相关
 */
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.opensearch.model.v20171225.*;
import com.aliyuncs.profile.DefaultProfile;
public class CreateModel {
	public static void main(String[] args) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "Omj6NGMiparyzKbh", "Cr9vwie6tITVFVKO7XpJlqtn2HQ9n7");
		IAcsClient client = new DefaultAcsClient(profile);
		CreateModelRequest request = new CreateModelRequest();
		request.setAppGroupIdentity("seeyii_search");//应用名称
		//opensearch_slave
		// type为算法类型：热词设置为hot，底纹设置为hint；modelName为模型名称：自定义，由英文数字、字母、下换线组成，非纯数字，不超过30个字符
		//热词模型
//        String content = "{\"type\": \"hot\",\"name\": \"hot_model\"}";
		//底纹
		String content = "{\"type\": \"hint\",\"name\": \"hint_model\"}";
		//创建完成后 延迟几分钟
		request.setHttpContent(content.getBytes(), "UTF-8", FormatType.JSON);
		try {
			HttpResponse response = client.doAction(request);
			System.out.println(response.getHttpContentString());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}