package com.example.joins.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.joins.v1.model.DeptEmpDto;

@RestController
public class JoinQueryController {
	@Autowired
	private JoinQueryServiceImpl joinQueryService;

	@GetMapping("/dept/emp/left")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesLeftJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/emp/right")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesRightJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesRightJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/emp/inner")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesInnerJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/emp/cross")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesCrossJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesCrossJoin(), HttpStatus.OK);
	}

}
