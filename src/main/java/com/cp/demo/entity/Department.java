package com.cp.demo.entity;

public class Department {
	private int  deptId;
	private String deptName;
	private String deptCity;
	private String deptState;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(String deptName, String deptCity, String deptState) {
		super();
		this.deptName = deptName;
		this.deptCity = deptCity;
		this.deptState = deptState;
	}
	public Department(int deptId, String deptName, String deptCity, String deptState) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptCity = deptCity;
		this.deptState = deptState;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptCity() {
		return deptCity;
	}
	public void setDeptCity(String deptCity) {
		this.deptCity = deptCity;
	}
	public String getDeptState() {
		return deptState;
	}
	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptCity=" + deptCity + ", deptState="
				+ deptState + "]";
	}
	
	

}
