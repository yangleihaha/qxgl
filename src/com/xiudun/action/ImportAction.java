/**
 * 
 */
package com.xiudun.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.xiudun.domain.User;
import com.xiudun.service.Service;

/**
 * @author Administrator
 *
 */
public class ImportAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//无论传递文件参数还是普通参数都不能直接使用request.getParameter()
			//都需要使用fileupload组件获取。
			//创建一个DiskFileItemFactory
			//负责将请求传递的信息(文件，普通参数)分开，重新组装，组成一个个的FileItem对象。
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//创建FileUpload组件对象，需要一个上面的工厂参数
			ServletFileUpload upload = new ServletFileUpload(factory);
			//upload组件使用factory将请求参数组装成list集合,集合里存放FileItem对象,也就是请求的参数
			//参数为一个request
			//FileItem对象还有许多常用方法,参考web宝典
			List<FileItem> fis = upload.parseRequest(request);
			//获得一个可以读取上传文件内容的输入流。
			InputStream is = fis.get(0).getInputStream();
//			//将获取的文件,上传到指定位置
//			OutputStream os = new FileOutputStream("d:/yang/bbb.doc");
//			while(true) {
//				int i = is.read();
//				if(i==-1) break;
//				os.write(i);
//			}
//			os.flush();
			//根据excel文件或文件输入流创建工作簿
			//参数可以是一个上传的输入流或者是一个确定的xlsx文件
			Workbook book = WorkbookFactory.create(is);
			//获取指定的工作表
			Sheet sheet = book.getSheetAt(0);
			//循环工作表里的每一行(下标从0开始)因为0行为表头,所以循环从1开始
			//getLastRowNum()最后一行的序号(下标)
			for(int i = 1;i<=sheet.getLastRowNum();i++) {
				//在表中获取一行
				Row row = sheet.getRow(i);
				//获取行中的一个单元
				Cell c1 = row.getCell(0);
				Cell c2 = row.getCell(1);
				Cell c3 = row.getCell(2);
				//获取单元中的值
				//只要表格中写的都是数字，就只能获取数字，只有浮点型一种数字。
				String uname = (int)c1.getNumericCellValue()+"";
				String upass = (int)c2.getNumericCellValue()+"";
				String truename = c3.getStringCellValue();
				//之后想要的操作
				User user = new User(null,uname,upass,truename);
				service.insert(user);
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("操作成功!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

















