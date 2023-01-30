package com.example.joins.v1;

import java.util.List;
import com.example.joins.v1.model.DeptEmpDto;

public interface JoinQueryService {
	List<DeptEmpDto> getDeptEmployeesLeftJoin();
	List<DeptEmpDto> getDeptEmployeesRightJoin();
	List<DeptEmpDto> getDeptEmployeesInnerJoin();
	List<DeptEmpDto> getDeptEmployeesCrossJoin();
}
