package com.ct.ops;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyun.opensearch.OpenSearchClient;
import com.aliyun.opensearch.sdk.generated.OpenSearch;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
public class Hot {
    private static final String accesskey = "Omj6NGMiparyzKbh";
    private static final String secret = "Cr9vwie6tITVFVKO7XpJlqtn2HQ9n7";
    private static final String host = "http://opensearch-cn-beijing.aliyuncs.com";
    private static final String appName = "seeyii_search";
    private static final String HOT_API_PATH = "/apps/seeyii_search/actions/hot";
    public static void main(String[] args) {
        OpenSearch openSearch = new OpenSearch(accesskey, secret, host);
        // Create OpenSearchClient
        OpenSearchClient client = new OpenSearchClient(openSearch);
        String requestPath = HOT_API_PATH.replaceAll(("\\{seeyii_search\\}"), appName);
        Map<String, String> params = new HashMap<>();
        params.put("model_name", "hot_model");//设置模型名称
        params.put("sort_type", "uv");//查询pv最高的底纹
        params.put("hit", "10");//设置查询的热词数据条数
        try {
            String response = client.call(requestPath, params, OpenSearchClient.METHOD_GET);
            System.out.println(JSON.toJSONString(response));
        } catch (OpenSearchClientException e) {
            e.printStackTrace();
        }
    }
}
