package com.example.joins.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer>,JpaRepository<Emp, Integer> {
	@Query("SELECT new com.example.joins.v1.Emp(e.eid, e.ename, e.email, e.dept_id, e.role) FROM Emp e WHERE role = :empRole")
	List<Emp> findEmpDataByRole(@Param("empRole") String empRole);
}
