package com.demo.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpRepository empRepository;
	
	@Override
	public List<Emp> findAllData() {
		List<Emp> emp=new ArrayList<Emp>();
		empRepository.findAll().forEach(newemp->emp.add(newemp));
		return emp;
	}
	
	@Override
	public Emp getEmpById(int id) {
		return empRepository.findById(id).get();
	}
	
	@Override
	public void empSave(Emp emp) {
		empRepository.save(emp);
	}
	
	@Override
	public void delete(int id) {
		empRepository.deleteById(id);
	}
	
	@Override
	public Emp update(Emp emp,int eid) {
		Emp emp_record = empRepository.findById(eid).get();
		if (Objects.nonNull(emp.getEid())) {
        	emp_record.setEid(emp.getEid());
		}
		if (Objects.nonNull(emp.getEname()) && !"".equalsIgnoreCase( emp.getEname())) {
			emp_record.setEname(emp.getEname());
	    }
		if (Objects.nonNull(emp.getEmail()) && !"".equalsIgnoreCase( emp.getEmail())) {
			emp_record.setEmail(emp.getEmail());
		}
		
		return empRepository.save(emp_record);
	}

}
