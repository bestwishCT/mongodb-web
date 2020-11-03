package com.lfy.demo.crawlers;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import org.seimicrawler.xpath.JXDocument;

import java.util.List;
@Crawler(name = "testCrawler")
public class TestCrawler extends BaseSeimiCrawler {
    @Override
    public String[] startUrls() {
        return new String[]{"http://www.cninfo.com.cn/new/commonUrl?url=disclosure/list/notice#szse/1"};
    }

    @Override
    public void start(Response response) {
        JXDocument doc = response.document();
        try {
        	//Jsoup x path
            List<Object> urls = doc.sel("//a[@class='p-hover']/@href");
            logger.info("{}", urls.size());
            for (Object s:urls){
                push(Request.build(s.toString(),TestCrawler::getTitle));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getTitle(Response response){
        JXDocument doc = response.document();
        try {
            logger.info("url:{} {}", response.getUrl(), doc.sel("//h1[@class='postTitle']/a/text()|//a[@id='cb_post_title_url']/text()"));
            //do something
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
