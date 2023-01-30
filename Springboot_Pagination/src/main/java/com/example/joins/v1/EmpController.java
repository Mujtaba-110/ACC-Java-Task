package com.example.joins.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@Autowired
	private EmpServiceImpl empServiceImpl;
	
	@GetMapping("/emp/{pageno}/{pagesize}")
	public List<Emp> getPaginatedEmp(@PathVariable int pageno,@PathVariable int pagesize){
		return empServiceImpl.findEmpDataByPage(pageno, pagesize);
	}
	
	@GetMapping("/emp/{pageno}/{pagesize}/{sort}")
	public List<Emp> sortEmpData(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String sort){
		return empServiceImpl.sortEmpData(pageno, pagesize,sort);
	}
	
	@GetMapping("/emp/{role}")
	public List<Emp> getEmpDataByRole(@PathVariable String role){
		return empServiceImpl.findEmpDataByRole(role);
	}

}
