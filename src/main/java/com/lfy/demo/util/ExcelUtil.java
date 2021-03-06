package com.lfy.demo.util;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.Iterator;
public class ExcelUtil {

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,List<String> title,List<JSONObject> content, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.size();i++){
            cell = row.createCell(i);
            cell.setCellValue(title.get(i));
            cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<content.size();i++){
        	row = sheet.createRow(i + 1);
        	JSONObject obj=content.get(i);
        	Iterator iterator = obj.keys();
        	while (iterator.hasNext()) {
        		String key = (String) iterator.next();
        		for(int j=0;j<title.size();j++){
        			if(title.get(j).equals(key)){
            			row.createCell(j).setCellValue(obj.getString(key));
            		}
        		}
        	}
        }
        return wb;
    }
}
