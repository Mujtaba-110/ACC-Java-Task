package com.demo.v1;

import java.util.List;

public interface EmpService {
	List<Emp> findAllData();
	Emp getEmpById(int id);
	void empSave(Emp emp);
	void delete(int id);
	Emp update(Emp emp,int eid);
}
