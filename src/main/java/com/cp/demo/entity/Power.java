package com.cp.demo.entity;

import java.sql.Date;

public class Power {
	
	private int billId;
	private  String readingDate;
	private int powerCmr;
	private String readerName;
	private int consId;
	
	public Power() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Power(int billId, String readingDate, int powerCmr, String readerName, int consId) {
		super();
		this.billId = billId;
		this.readingDate = readingDate;
		this.powerCmr = powerCmr;
		this.readerName = readerName;
		this.consId = consId;
	}




	public Power(String readingDate, int powerCmr, String readerName, int consId) {
		super();
		this.readingDate = readingDate;
		this.powerCmr = powerCmr;
		this.readerName = readerName;
		this.consId = consId;
	}

	
	

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(String readingDate) {
		this.readingDate = readingDate;
	}

	public int getPowerCmr() {
		return powerCmr;
	}

	public void setPowerCmr(int powerCmr) {
		this.powerCmr = powerCmr;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public int getConsId() {
		return consId;
	}

	public void setConsId(int consId) {
		this.consId = consId;
	}

	@Override
	public String toString() {
		return "Power [billId=" + billId + ", readingDate=" + readingDate + ", powerCmr=" + powerCmr + ", readerName="
				+ readerName + ", consId=" + consId + "]";
	}
	
	
	
	

	
	
	

}
