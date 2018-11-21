/**
 * 
 */
package com.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


import com.bean.Patient;
import com.bean.User;

/**
 * @author 石可旺
 *
 */
public class Export extends HttpServlet {
    static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter outs = response.getWriter();
    
		// 1.创建一个workbook，对应一个Excel文件
	      HSSFWorkbook wb = new HSSFWorkbook();
	      // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
	      HSSFSheet sheet = wb.createSheet("user表");
	      // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
	      HSSFRow row = sheet.createRow((int) 0);
	      // 4.创建单元格，设置值表头，设置表头居中
	      HSSFCellStyle style = wb.createCellStyle();
	      // 居中格式
	      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	 
	      // 设置表头
	      HSSFCell cell = row.createCell(0);
	      cell.setCellValue("姓名");
	      cell.setCellStyle(style);
	 
	      cell = row.createCell(1);
	      cell.setCellValue("电话");
	      cell.setCellStyle(style);
	 
	      cell = row.createCell(2);
	      cell.setCellValue("注册时间");
	      cell.setCellStyle(style);
//	 
//	      cell = row.createCell(3);
//	      cell.setCellValue("表头4");
//	      cell.setCellStyle(style);
//	 
//	      cell = row.createCell(4);
//	      cell.setCellValue("表头5");
//	      cell.setCellStyle(style);
	      
	      List<User> list=(List) request.getSession().getAttribute("xiajiList");
	      for (int i = 0; i < list.size(); i++) {
	          row = sheet.createRow((int) i + 1);
//	          List lists= list.get(i);
	          // 创建单元格，设置值
	          row.createCell(0).setCellValue(list.get(i).getUname());
	          row.createCell(1).setCellValue(list.get(i).getLoginName());
	          row.createCell(2).setCellValue(list.get(i).getStarttime());
	        }
	      
	      
	      String fileName = "user";
	      ByteArrayOutputStream os = new ByteArrayOutputStream();
	      wb.write(os);
	      byte[] content = os.toByteArray();
	      InputStream is = new ByteArrayInputStream(content);
	      // 设置response参数，可以打开下载页面
	      response.reset();
	      response.setContentType("application/vnd.ms-excel;charset=utf-8");
	      response.setHeader("Content-Disposition", "attachment;filename="
	          + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	      ServletOutputStream out = response.getOutputStream();
	      BufferedInputStream bis = null;
	      BufferedOutputStream bos = null;
	 
	      try {
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(out);
	        byte[] buff = new byte[2048];
	        int bytesRead;
	        // Simple read/write loop.
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	          bos.write(buff, 0, bytesRead);
	        }
	      } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	      } finally {
	        if (bis != null)
	          bis.close();
	        if (bos != null)
	          bos.close();
	      }
	      
	      
            outs.close();
           }     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}