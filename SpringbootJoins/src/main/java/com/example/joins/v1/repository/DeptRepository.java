package com.example.joins.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.joins.v1.model.Dept;
import com.example.joins.v1.model.DeptEmpDto;

public interface DeptRepository extends JpaRepository<Dept,Integer> {
	@Query("SELECT new com.example.joins.v1.model.DeptEmpDto(d.name, e.ename, e.email) FROM Dept d LEFT JOIN Emp e ON d.id = e.department")
	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.example.joins.v1.model.DeptEmpDto(d.name, e.ename, e.email) FROM Dept d RIGHT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataRightJoin();

}
