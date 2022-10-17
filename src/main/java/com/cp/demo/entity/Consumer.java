package com.cp.demo.entity;

public class Consumer {

	private int consId;
	private String consName;
	private int consNumber;
	private String consAddress1;
	private String consAddress2;
	private String consCity;
	private int consPhone;
	private int deptId;

	

	
	public Consumer(int consId, String consName, int consNumber, String consAddress1, String consAddress2,
			String consCity, int consPhone) {
		super();
		this.consId = consId;
		this.consName = consName;
		this.consNumber = consNumber;
		this.consAddress1 = consAddress1;
		this.consAddress2 = consAddress2;
		this.consCity = consCity;
		this.consPhone = consPhone;
		;
	}
	

	public Consumer(String consName, int consNumber, String consAddress1, String consAddress2, String consCity,
			int consPhone, int deptId) {
		super();
		this.consName = consName;
		this.consNumber = consNumber;
		this.consAddress1 = consAddress1;
		this.consAddress2 = consAddress2;
		this.consCity = consCity;
		this.consPhone = consPhone;
		this.deptId = deptId;
	}

	

	

	public int getConsId() {
		return consId;
	}
	public void setConsId(int consId) {
		this.consId = consId;
	}
	public String getConsName() {
		return consName;
	}
	public void setConsName(String consName) {
		this.consName = consName;
	}
	public int getConsNumber() {
		return consNumber;
	}
	public void setConsNumber(int consNumber) {
		this.consNumber = consNumber;
	}
	public String getConsAddress1() {
		return consAddress1;
	}
	public void setConsAddress1(String consAddress1) {
		this.consAddress1 = consAddress1;
	}
	public String getConsAddress2() {
		return consAddress2;
	}
	public void setConsAddress2(String consAddress2) {
		this.consAddress2 = consAddress2;
	}
	public String getConsCity() {
		return consCity;
	}
	public void setConsCity(String consCity) {
		this.consCity = consCity;
	}
	public int getConsPhone() {
		return consPhone;
	}
	public void setConsPhone(int consPhone) {
		this.consPhone = consPhone;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Consumer [consId=" + consId + ", consName=" + consName + ", consNumber=" + consNumber
				+ ", consAddress1=" + consAddress1 + ", consAddress2=" + consAddress2 + ", consCity=" + consCity
				+ ", consPhone=" + consPhone + ", deptId=" + deptId + "]";
	}
	
	
	
	
	
	
}
