package com.cp.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cp.demo.entity.Consumer;
import com.cp.demo.exception.CPException;
import com.cp.inv.util.DBManager;


public class ConsumerRepository {
	
	Connection con=null;
	PreparedStatement psmt=null;
	DBManager dbManager=DBManager.getDBManager();
	Statement stmt=null;
	ResultSet rsobj=null;
	
	
	
	public int createConsumer(Consumer consumer) throws CPException {
	    String insertConsumer="insert into consumer (cons_name,cons_number,cons_address1,cons_address2,cons_city,cons_phone,dept_id) values(?,?,?,?,?,?,?)";
	    
	    con=dbManager.getConnection();
	    
	    try {
			psmt=con.prepareStatement(insertConsumer);
			psmt.setString(1,consumer.getConsName());
			psmt.setInt(2,consumer.getConsNumber());
			psmt.setString(3, consumer.getConsAddress1());
			psmt.setString(4,consumer.getConsAddress2());
			psmt.setString(5,consumer.getConsCity());
			psmt.setInt(6,consumer.getConsPhone());
			psmt.setInt(7,consumer.getDeptId());
			psmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block p
			e.printStackTrace();
		}
	    finally {
	    	dbManager.closeConnection(con);
	    	
	    }
	    
		return getlastConsumerId();
		
	}
	
	public int getlastConsumerId() throws CPException {
		int consId=0;
		String getActiveId="Select max(cons_id) from consumer";
		con=dbManager.getConnection();
		
		try {
			stmt=con.createStatement();
			rsobj=stmt.executeQuery(getActiveId);
			while(rsobj.next()) {
				consId=rsobj.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbManager.closeConnection(con);
		}
		
		
		return consId;
		
	}
	
	
	public List<Consumer> getDetailsConsumer() {
		List<Consumer> mycons=new ArrayList<>();
		String getdata="Select * from consumer";
		
		
		try {
			con=dbManager.getConnection();
			psmt=con.prepareStatement(getdata);
			rsobj=psmt.executeQuery();
			while(rsobj.next())
			{
				int consId=rsobj.getInt("cons_id");
				String consName=rsobj.getString("cons_name");
				int consNumber=rsobj.getInt("cons_number");
				String consAddress1=rsobj.getString("cons_address1");
				String consAddress2=rsobj.getString("cons_address2");
				String consCity=rsobj.getString("cons_city");
				int deptId=rsobj.getInt("dept_id");
				
				Consumer consumer=new Consumer(consId,consName,consNumber,consAddress1,consAddress2,consCity,deptId);
				mycons.add(consumer);
			}
			
		//	System.out.println(mycons);
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}finally {
			dbManager.closeConnection(con);
			
		}
		
		
		
		return mycons;
		
	}
	
	public Consumer getConsumerById(int consId) {

		String getQuery = "SELECT * FROM consumer where cons_id = ?";
		Consumer consumer=null;
	
		try {
			con = dbManager.getConnection();
			psmt = con.prepareStatement(getQuery);
			psmt.setInt(1, consId);
			 rsobj = psmt.executeQuery();

			while (rsobj.next()) {
				String consName=rsobj.getString("cons_name");
				int consNumber=rsobj.getInt("cons_number");
				String consAddress1=rsobj.getString("cons_address1");
				String consAddress2=rsobj.getString("cons_address2");
				String consCity=rsobj.getString("cons_city");
				int deptId=rsobj.getInt("dept_id");
				
				 consumer=new Consumer(consId,consName,consNumber,consAddress1,consAddress2,consCity,deptId);
				consumer.toString();
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
		return consumer;

		

	}

}
