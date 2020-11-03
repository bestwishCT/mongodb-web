package com.lfy.demo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lfy.demo.dao.UserDao;
import com.lfy.demo.domain.User;
import com.lfy.demo.service.UserService;
import com.lfy.demo.util.WDWUtil;

@Service
public class UserServiceImpl implements UserService {
    //总行数
    private int totalRows = 0;  
    //总条数
    private int totalCells = 0; 
    //错误信息接收器
    private String errorMsg;
    //获取总行数
    public int getTotalRows()  { return totalRows;} 
    //获取总列数
    public int getTotalCells() {  return totalCells;} 
    //获取错误信息
    public String getErrorInfo() { return errorMsg; } 
    @Autowired
    UserDao userDao;
    public static int rowNums;
    public static int columnNums;
    public static List<String> titleList;

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }

    @Override
    public Integer insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public Integer update(User user) {
        return userDao.update(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }
    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath){
          if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){  
              errorMsg = "文件名不是excel格式";  
              return false;  
          }  
          return true;
    }
    
    //从流中获取excel数据
    public List<JSONObject> readExcels(InputStream is,String fileName){
    	List<JSONObject> list=new ArrayList<JSONObject>();
   		try {
   			// 建需要读取的excel文件写入stream
   			HSSFWorkbook workbook = new HSSFWorkbook(is);
   			// 指向sheet下标为0的sheet 即第一个sheet 也可以按在sheet的名称来寻找
   			HSSFSheet sheet = workbook.getSheetAt(0);
   			// 获取sheet1中的总行数
   			int rowTotalCount = sheet.getLastRowNum();
   			//获取总列数
   			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
   			//预先获取列集合
   			List<String> columnList=new ArrayList<String>();
   			//获取第一行 即标题
   			HSSFRow rowTitle = sheet.getRow(0);
   			for(int m=0;m<columnCount;m++){
   				columnList.add(rowTitle.getCell(m).toString());
   			}
   			if(fileName.contains("辅表")){
   				rowNums=rowTotalCount;
   				columnNums=columnCount;
   				titleList=columnList;
   			}
   			for (int i = 1; i <= rowTotalCount; i++) {
   				// 获取第i列的row对象
   				HSSFRow row = sheet.getRow(i);
   				
   				ArrayList<String> listRow = new ArrayList<String>();
   				JSONObject rowJson=new JSONObject();
   				for (int j = 0; j < columnCount; j++) {
   					//下列步骤为判断cell读取到的数据是否为null 如果不做处理 程序会报错
   					String cell = null;
   					//如果未null则加上""组装成非null的字符串
   					if(row.getCell(j) == null){
   						
   						cell = row.getCell(j)+"";
   						
   						listRow.add(cell);
   					//如果读取到额cell不为null 则直接加入	listRow集合
   					}else{
   						rowJson.put(columnList.get(j), row.getCell(j).toString());
   					}
    
   				}
   				list.add(rowJson);
   			}
    
   		} catch (FileNotFoundException e) {
    
   			e.printStackTrace();
   		} catch (IOException e) {
    
   			e.printStackTrace();
   		}finally{
           if(is !=null)
           {
               try{
                   is.close();
               }catch(IOException e){
                   is = null;    
                   e.printStackTrace();  
               }
           }
       }
       return list;
    }
}
