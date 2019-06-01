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
		//����2003.xls�汾
		//HSSFWorkbook book = new HSSFWorkbook();
		//����2007.xlsx�汾������
		XSSFWorkbook book = new XSSFWorkbook();
		//����������
		Sheet sheet = book.createSheet();
		{	//������(�±�0��ʼ)
			Row row = sheet.createRow(0);
			//������Ԫ(��)(�±�0��ʼ)
			Cell c1 = row.createCell(0);
			Cell c2 = row.createCell(1);
			Cell c3 = row.createCell(2);
			//��Ԫ��װ����
			c1.setCellValue("�˺�");
			c2.setCellValue("����");
			c3.setCellValue("��ʵ����");
		}
		
		int i=1;
		//ѭ��user��user�е�����װ�����
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
		//��ȡһ�������ָ��һ���ļ�
		FileOutputStream fos = new FileOutputStream("d:/yang/aa.xlsx");
		//�����ڹ������е�����ͨ�������д���ļ�
		book.write(fos);
		//���߹ر�һ��,��Ȼ����д����ȥ�ļ�
		fos.flush();
		//�����ʶ��Ķ�����ֱ����Ӧ�������,�������ʶ��Ļ��γ�һ���������ļ�
		//content-disposition:ָ����Ӧ���ݵ�λ��
		//�ڶ�������Ĭ��inline ����Ӧ��������ʾ�������������
		//attachment;filename=users.xlsx:���ӵ�һ���������ļ���,�ļ���Ϊ...
		//�������������Ӧ������д��һ���������ļ���
		response.setHeader("content-disposition", "attachment;filename=users.xlsx");
		/*�����ļ�����Ӧ�ļ�����*/
		//��ȡ�������ϵ�Ҫ���ص��ļ�
		FileInputStream fis = new FileInputStream("d:/yang/aa.xlsx");
		//���ļ�����Ӧ�������
		while(true) {
			int b = fis.read();
			if(b==-1) break;
			//��Ӧ�������
			response.getOutputStream().write(b);
		}
	}
}













