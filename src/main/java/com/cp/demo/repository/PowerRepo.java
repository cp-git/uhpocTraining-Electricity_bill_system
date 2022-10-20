package com.cp.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cp.demo.dbhelper.DBManager;
import com.cp.demo.entity.Consumer;
import com.cp.demo.entity.Power;
import com.cp.demo.exception.CPException;

public class PowerRepo {
	
	Connection con=null;
	PreparedStatement psmt=null;
	DBManager dbManager=DBManager.getDBManager();
	Statement stmt=null;
	ResultSet rsobj;
	
	public int createpowerbill(Power power) throws CPException {
		con=dbManager.getConnection();
		
		String insertBillData="insert into power(reader_date,p_cmr,reader_name,cons_id) values(?,?,?,?)";
		try {
			
			psmt=con.prepareStatement(insertBillData);
			psmt.setString(1,power.getReadingDate());
			psmt.setInt(2, power.getPowerCmr());
			psmt.setString(3,power.getReaderName());
			psmt.setInt(4, power.getConsId());
			psmt.execute();
			
			
		}
		catch(Exception bb)
		{
			bb.printStackTrace();
		}
		finally {
			dbManager.closeConnection(con);
		}
		return getPowerConsumerId();
		
	}
	
	public int getPowerConsumerId() throws CPException {
		int billId=0;
		String getActiveBillId="Select max(p_id) from power";
		con=dbManager.getConnection();
		try {
			stmt=con.createStatement();
			rsobj=stmt.executeQuery(getActiveBillId);
			while(rsobj.next())
			{
				billId=rsobj.getInt(1);
			}
		}
		catch(Exception m)
		{
			m.printStackTrace();
		}
		finally {
			dbManager.closeConnection(con);
		}
		
	 return billId;
		
		
	}
	
	public List<Power> getDetailsPower() {
		List<Power> pw=new ArrayList<>();
		String myQuery="Select * from power";
			
			try {
				try {
					con=dbManager.getConnection();
				} catch (CPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				psmt=con.prepareStatement(myQuery);
				rsobj=psmt.executeQuery();
				while(rsobj.next())
				{
					int billId=rsobj.getInt("p_id");
					String readingDate=rsobj.getString("reader_date");
					int powerCmr=rsobj.getInt("p_cmr");
					String readerName=rsobj.getString("reader_name");
					int consId=rsobj.getInt("cons_id");
					
					
					Power pp=new Power(billId,readingDate,powerCmr,readerName,consId);
					pw.add(pp);
				}
				//System.out.println(pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				dbManager.closeConnection(con);
			}
			
			
		
		return pw;
		
	}
	
	public Power getConsumerById(int billId) {

		String getQuery = "SELECT * FROM power where p_id = ?";
		Power power=null;
	
		try {
			con = dbManager.getConnection();
			psmt = con.prepareStatement(getQuery);
			psmt.setInt(1, billId);
			 rsobj = psmt.executeQuery();

			while (rsobj.next()) {
				String readingDate=rsobj.getString("reader_date");
				int powerCmr=rsobj.getInt("p_cmr");
				String readerName=rsobj.getString("reader_name");
				int consId=rsobj.getInt("cons_id");
				
				
				 power=new Power(billId,readingDate,powerCmr,readerName,consId);
				
				 power.toString();
				 System.out.println(power);
			}
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.closeConnection(con);
		}
		return power;

		

	}
	
	public List<Power> getListPowerDetails(int consId) {
		ArrayList<Power> pwarray=new ArrayList<>();
		String getQuery = "SELECT * FROM power where cons_id = ?";
		Power power=null;
	
		try {
			con = dbManager.getConnection();
			psmt = con.prepareStatement(getQuery);
			psmt.setInt(1, consId);
			 rsobj = psmt.executeQuery();

			while (rsobj.next()) {
				int billId=rsobj.getInt("p_id");
				String readingDate=rsobj.getString("reader_date");
				int powerCmr=rsobj.getInt("p_cmr");
				String readerName=rsobj.getString("reader_name");
				
				
				
				 power=new Power(billId,readingDate,powerCmr,readerName,consId);
				 pwarray.add(power);
				
		
			}
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.closeConnection(con);
		}
		return pwarray;

		

	}
	
	
	public List<Power> getCmrPowerDetails(String readerDate) {
		ArrayList<Power> pwarray=new ArrayList<>();
		String getQuery = "SELECT(t2.p_cmr - t1.p_cmr) AS sub1\r\n"
				+ "FROM power t1 CROSS JOIN\r\n"
				+ "     power t2\r\n"
				+ "WHERE t1.reader_date=? AND t2.reader_date=?";
		Power power=null;
	
		try {
			con = dbManager.getConnection();
			psmt = con.prepareStatement(getQuery);
			psmt.setString(1, readerDate);
			 rsobj = psmt.executeQuery();

			while (rsobj.next()) {
				int billId=rsobj.getInt("p_id");
				String readingDate=rsobj.getString("reader_date");
				int powerCmr=rsobj.getInt("p_cmr");
				String readerName=rsobj.getString("reader_name");
				int consId=rsobj.getInt("cons_id");
				
				
				
				 power=new Power(billId,readingDate,powerCmr,readerName,consId);
				 pwarray.add(power);
				
		
			}
		} catch (CPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.closeConnection(con);
		}
		return pwarray;

		

	}
	
	

	
	
	

}
