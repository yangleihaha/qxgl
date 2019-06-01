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
			//���۴����ļ�����������ͨ����������ֱ��ʹ��request.getParameter()
			//����Ҫʹ��fileupload�����ȡ��
			//����һ��DiskFileItemFactory
			//�������󴫵ݵ���Ϣ(�ļ�����ͨ����)�ֿ���������װ�����һ������FileItem����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//����FileUpload���������Ҫһ������Ĺ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			//upload���ʹ��factory�����������װ��list����,��������FileItem����,Ҳ��������Ĳ���
			//����Ϊһ��request
			//FileItem��������ೣ�÷���,�ο�web����
			List<FileItem> fis = upload.parseRequest(request);
			//���һ�����Զ�ȡ�ϴ��ļ����ݵ���������
			InputStream is = fis.get(0).getInputStream();
//			//����ȡ���ļ�,�ϴ���ָ��λ��
//			OutputStream os = new FileOutputStream("d:/yang/bbb.doc");
//			while(true) {
//				int i = is.read();
//				if(i==-1) break;
//				os.write(i);
//			}
//			os.flush();
			//����excel�ļ����ļ�����������������
			//����������һ���ϴ���������������һ��ȷ����xlsx�ļ�
			Workbook book = WorkbookFactory.create(is);
			//��ȡָ���Ĺ�����
			Sheet sheet = book.getSheetAt(0);
			//ѭ�����������ÿһ��(�±��0��ʼ)��Ϊ0��Ϊ��ͷ,����ѭ����1��ʼ
			//getLastRowNum()���һ�е����(�±�)
			for(int i = 1;i<=sheet.getLastRowNum();i++) {
				//�ڱ��л�ȡһ��
				Row row = sheet.getRow(i);
				//��ȡ���е�һ����Ԫ
				Cell c1 = row.getCell(0);
				Cell c2 = row.getCell(1);
				Cell c3 = row.getCell(2);
				//��ȡ��Ԫ�е�ֵ
				//ֻҪ�����д�Ķ������֣���ֻ�ܻ�ȡ���֣�ֻ�и�����һ�����֡�
				String uname = (int)c1.getNumericCellValue()+"";
				String upass = (int)c2.getNumericCellValue()+"";
				String truename = c3.getStringCellValue();
				//֮����Ҫ�Ĳ���
				User user = new User(null,uname,upass,truename);
				service.insert(user);
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("�����ɹ�!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

















