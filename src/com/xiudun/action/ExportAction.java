/**
 * 
 */
package com.xiudun.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xiudun.domain.User;
import com.xiudun.service.Service;

/**
 * @author Administrator
 *
 */
public class ExportAction extends HttpServlet{
	private Service service = new Service();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = service.findAll();
		//创建2003.xls版本
		//HSSFWorkbook book = new HSSFWorkbook();
		//创建2007.xlsx版本工作簿
		XSSFWorkbook book = new XSSFWorkbook();
		//创建工作表
		Sheet sheet = book.createSheet();
		{	//创建行(下标0开始)
			Row row = sheet.createRow(0);
			//创建单元(列)(下标0开始)
			Cell c1 = row.createCell(0);
			Cell c2 = row.createCell(1);
			Cell c3 = row.createCell(2);
			//向单元中装数据
			c1.setCellValue("账号");
			c2.setCellValue("密码");
			c3.setCellValue("真实姓名");
		}
		
		int i=1;
		//循环user把user中的数据装入表中
		for(User user:list) {
			Row row = sheet.createRow(i);
			Cell c1 = row.createCell(0);
			Cell c2 = row.createCell(1);
			Cell c3 = row.createCell(2);
			
			c1.setCellValue(user.getCname());
			c2.setCellValue(user.getCpass());
			c3.setCellValue(user.getTruename());
			i++;
		}
		//获取一个输出流指向一个文件
		FileOutputStream fos = new FileOutputStream("d:/yang/aa.xlsx");
		//将存在工作簿中的数据通过输出流写入文件
		book.write(fos);
		//或者关闭一下,不然数据写不进去文件
		fos.flush();
		//浏览器识别的东西会直接响应到浏览器,浏览器不识别的会形成一个独立的文件
		//content-disposition:指定响应内容的位置
		//第二个参数默认inline 把响应的内容显示到浏览器窗口里
		//attachment;filename=users.xlsx:附加到一个独立的文件上,文件名为...
		//告诉浏览器将响应的内容写成一个独立的文件。
		response.setHeader("content-disposition", "attachment;filename=users.xlsx");
		/*下载文件，响应文件内容*/
		//获取服务器上的要下载的文件
		FileInputStream fis = new FileInputStream("d:/yang/aa.xlsx");
		//读文件并响应给浏览器
		while(true) {
			int b = fis.read();
			if(b==-1) break;
			//响应给浏览器
			response.getOutputStream().write(b);
		}
	}
}













