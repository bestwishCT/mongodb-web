package com.lfy.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lfy.demo.domain.User;
import com.lfy.demo.service.UserService;
import com.lfy.demo.service.impl.UserServiceImpl;
import com.lfy.demo.util.ExcelUtil;

@Controller
@RequestMapping("/parseExcel")
public class ParseExcelDataController {
	public static List<JSONObject> zb=new ArrayList<JSONObject>();
	public static List<JSONObject> fb=new ArrayList<JSONObject>();
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> listAll() {
        List<User> users = userService.listAll();
        System.out.println(users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 4);
        map.put("data", users);
        return map;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> add(@RequestBody User user) {
        int result = userService.insert(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
           map.put("status", 1);
        } else {
           map.put("status", 0);
        }
        return map;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    private Map<String, Object> deleteById(@PathVariable("id") int id) {
        int result = userService.deleteById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
           map.put("status", 1);
        } else {
           map.put("status", 0);
        }
        return map;
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    private Map<String, Object> update(@RequestBody User user) {
        int result = userService.update(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result > 0) {
           map.put("status", 1);
        } else {
           map.put("status", 0);
        }
        return map;
    }
    /**
     * 下载
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportData")
    public String daoChu(HttpServletResponse response){
    	//获取数据fb
    	//标题
    	List<String> title=UserServiceImpl.titleList;
    	//excel文件名
    	String fileName = "结果表"+System.currentTimeMillis()+".xls";
    	//sheet名
    	String sheetName = "datasheet";
    	//创建HSSFWorkbook 
    	HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, fb, null);
         try {
             /**
              * 弹出下载选择路径框
              */
//             response.setContentType("application/octet-stream");
//             response.setHeader("Content-disposition", "attachment;"+fileName+"=Opinion.xls");//默认Excel名称
             response.setContentType("application/octet-stream;charset=ISO8859-1");
             response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
             response.flushBuffer();
             wb.write(response.getOutputStream());
//             wb.write(new FileOutputStream(new File("E://daochu/a.xls")));
         } catch (IOException e) {
             e.printStackTrace();
         }
         finally {

         }
         return "index";
     }
    /**
     * 读取
     * @param file
     * @param request
     * @param relationfield
     * @param populatefield
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    @ResponseBody
	public JSONObject loadExcel(MultipartFile file, HttpServletRequest request,String relationfield,String populatefield) throws IOException {
//    	System.out.println("关联字段"+relationfield+":填充字段"+populatefield);
    	String [] popuStr=populatefield.split("\\|");
    	JSONObject data = new JSONObject();
		JSONObject srcObj = new JSONObject();
		srcObj.put("src", "www.pipiwiki.top");
		InputStream ips = null;
		File file1 = null;
		file1 = File.createTempFile("temp", null);
		file.transferTo(file1);
		ips = new FileInputStream(file1);
		file1.deleteOnExit();
		// -------------------------------读取excel第一行 如何想读取全部excel就再加一重for循环
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size = file.getSize();
		if (fileName == null || ("").equals(fileName) && size == 0){
			data.put("code", 3);
			data.put("msg", "success");
			data.put("data", "");
		}
		// 批量导入。参数：文件名，文件。
		if (fileName.contains("主表")) {
			zb = userService.readExcels(ips,fileName);
		}
		if (fileName.contains("辅表")) {
			fb = userService.readExcels(ips,fileName);
		}
		if (zb.size() > 0 && fb.size() > 0) {
			for (JSONObject zbObj : zb) {
				String name = zbObj.getString(relationfield);//关联字段
				for (JSONObject fbObj : fb) {
					if(name.equals(fbObj.getString(relationfield))){
						for(String cusKey:popuStr){
							if(zbObj.containsKey(cusKey)){
								fbObj.put(cusKey, zbObj.getString(cusKey));
							}
						}
						break;
					}
				}

			}
			data.put("code", 1);
			data.put("msg", "success");
			data.put("data", srcObj);
		}
		return data;
	}
}
