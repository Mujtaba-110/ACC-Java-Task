package com.example.joins.v1;

import java.util.List;

public interface EmpService {
	List<Emp> findEmpDataByPage(int pageno,int pagesize);
	List<Emp> sortEmpData(int pageno,int pagesize,String sort);
	List<Emp> findEmpDataByRole(String role);
}
