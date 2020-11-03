package com.lfy.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wanghaomiao.seimi.config.SeimiConfig;
import cn.wanghaomiao.seimi.core.Seimi;

import com.lfy.demo.domain.User;
import com.lfy.demo.service.UserService;

@Controller
@RequestMapping("/spider")
public class SpiderController {
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/getcontent", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> listAll() {
        System.out.println("开始爬取");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", "");
        SeimiConfig config = new SeimiConfig();
        config.setSeimiAgentHost("127.0.0.1");
        Seimi s = new Seimi(config);
        s.goRun("testCrawler");
        System.out.println("爬取结束");
        return map;
    }
}
