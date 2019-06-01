/**
 * 
 */
package com.xiudun.roleAction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xiudun.domain.Role;
import com.xiudun.service.roleService;

/**
 * @author Administrator
 *
 */
@WebServlet("/exportRole.do")
public class ExportRoleAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			XSSFWorkbook book = new XSSFWorkbook();
			Sheet sheet = book.createSheet();
			{
				Row row = sheet.createRow(0);
				Cell c1 = row.createCell(0);
				Cell c2 = row.createCell(1);
				
				c1.setCellValue("½ÇÉ«Ãû");
				c2.setCellValue("ÃèÊö");
			}
			List<Role> list = service.findAll();
			int i=1;
			for(Role r:list) {
				Row row = sheet.createRow(i);
				Cell c1 = row.createCell(0);
				Cell c2 = row.createCell(1);
				
				c1.setCellValue(r.getRname());
				c2.setCellValue(r.getDescription());
				i++;
			}
			FileOutputStream fos = new FileOutputStream("d:/yang/aa.xlsx");
			book.write(fos);
			fos.flush();
			
			arg1.setHeader("content-disposition", "attachment;filename=roles.xlsx");
			FileInputStream fis = new FileInputStream("d:/yang/aa.xlsx");
			while(true) {
				int b = fis.read();
				if(b==-1) break;
				arg1.getOutputStream().write(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}














