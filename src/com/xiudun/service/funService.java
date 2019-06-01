/**
 * 
 */
package com.xiudun.service;

import java.util.List;

import com.xiudun.dao.funDao;
import com.xiudun.domain.Function;

/**
 * @author Administrator
 *
 */
public class funService {
	private funDao dao = new funDao();
	public List<Function> findAllFun(){
		return dao.findAllFun();
	}
	public void save(Function f) {
		dao.save(f);
	}
	public List<Function> parentFunctions(){
		return dao.parentFunctions();
	}
	public List<Function> linkFunctions(int rno){
		return dao.linkFunctions(rno);
	}
	
	public void saveRoleFunctions(int rno,int[] fnos) {
		dao.removeRoleFunctions(rno);
		if(fnos!=null && fnos.length>0 ) {
			for(int i=0;i<fnos.length;i++) {
				dao.saveRoleFunctions(rno, fnos[i]);
			}
		}
	}
	public List<Function> currentFunctions(int cno){
		return dao.currentFunctions(cno);
	}
	
	public void updateParentFun(String fname,int fno) {
		dao.updateParentFun(fname, fno);
	}
}
