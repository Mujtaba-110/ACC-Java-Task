package com.demo.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	@Autowired
	EmpServiceImpl empService;
	EmpRepository empRepository;
	@GetMapping("/emp")
	private List<Emp> getAllEmp(){
		return empService.findAllData();
	}
	
	@GetMapping("/emp/{eid}")
	private Emp getEmp(@PathVariable("eid")int eid) {
		return empService.getEmpById(eid);
	}
	
	@DeleteMapping("/emp/{eid}")
	private String deleteEmp(@PathVariable("eid")int eid) {
		empService.delete(eid);
		return "Record Deleted";
	}
	
	@PostMapping("/emp")
	private String saveEmp(@RequestBody Emp emp) {
		empService.empSave(emp);
		return "Record Inserted";
	}
	
	@PutMapping("/emp/{eid}")
	private Emp update(@RequestBody Emp emp,@PathVariable("eid")int eid) {
		return empService.update(emp, eid);
	}
	
	

}
