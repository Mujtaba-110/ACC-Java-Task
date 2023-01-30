package com.example.joins.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.joins.v1.model.DeptEmpDto;
import com.example.joins.v1.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	@Query("SELECT new com.example.joins.v1.model.DeptEmpDto(d.name, e.ename, e.email) FROM Dept d INNER JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.example.joins.v1.model.DeptEmpDto(d.name, e.ename, e.email) "+ "FROM Dept d, Emp e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();
	
}
