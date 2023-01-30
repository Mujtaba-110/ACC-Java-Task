package com.example.joins.v1.model;

public class DeptEmpDto {
	private String empDept;
	private String empName;
	private String empEmail;
	
	public DeptEmpDto(String empDept, String empName, String empEmail) {
		super();
		this.empDept = empDept;
		this.empName = empName;
		this.empEmail = empEmail;
	}
	
	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "DeptEmpDto [empDept=" + empDept + ", empName=" + empName + ", empEmail=" + empEmail +"]";
	}
	
	

}
