package com.example.joins.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.joins.v1.model.DeptEmpDto;
import com.example.joins.v1.repository.DeptRepository;
import com.example.joins.v1.repository.EmpRepository;

@Service
public class JoinQueryServiceImpl implements JoinQueryService {
	
	@Autowired
	private DeptRepository departmentRepository;
	@Autowired
	private EmpRepository employeeRepository;

	@Override
	public List<DeptEmpDto> getDeptEmployeesLeftJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataLeftJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	@Override
	public List<DeptEmpDto> getDeptEmployeesRightJoin() {
		List<DeptEmpDto> list = departmentRepository.fetchEmpDeptDataRightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	@Override
	public List<DeptEmpDto> getDeptEmployeesInnerJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataInnerJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	@Override
	public List<DeptEmpDto> getDeptEmployeesCrossJoin() {
		List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataCrossJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

}
