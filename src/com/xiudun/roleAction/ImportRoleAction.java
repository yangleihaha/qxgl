/**
 * 
 */
package com.xiudun.roleAction;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

import com.xiudun.domain.Role;
import com.xiudun.service.roleService;

/**
 * @author Administrator
 *
 */
@WebServlet("/importRole.do")
public class ImportRoleAction extends HttpServlet{
	private roleService service = new roleService();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> fis = upload.parseRequest(arg0);
			InputStream is = fis.get(0).getInputStream();
			
			Workbook book =  WorkbookFactory.create(is);
			Sheet sheet = book.getSheetAt(0);
			for(int i = 1;i<=sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i);
				Cell c1 = row.getCell(0);
				Cell c2 = row.getCell(1);
				
				String rname = c1.getStringCellValue();
				String description = c2.getStringCellValue();
				
				Role r = new Role(null,rname,description);
				service.saveRole(r);
			}
			arg1.sendRedirect("role/roleIndex.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}













