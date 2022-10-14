package com.cp.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cp.demo.entity.Department;
import com.cp.demo.exception.CPException;
import com.cp.inv.util.DBManager;

public class DepartmentRepository {
	DBManager dbManager = DBManager.getDBManager();
	Connection con=null;
	PreparedStatement psmt=null;
	ResultSet rsobj=null;
	Statement stmt=null;

	
	
	public int insertDepartment(Department department) throws CPException {
		
		String insertDepartment="Insert into department (dept_name,dept_city,dept_state) values (?,?,?)";
		
		con=dbManager.getConnection();
		
		try {
			psmt=con.prepareStatement(insertDepartment);
			
			psmt.setString(1, department.getDeptName());
			psmt.setString(2, department.getDeptCity());
			psmt.setString(3, department.getDeptState());
			
			psmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbManager.closeConnection(con);
			
		}
		
		
		return getLastDeptId();
		
	}



	public  int getLastDeptId() throws CPException {
		
		int deptId=0;
		String insertQuery="Select max(dept_id) from department";
		
		con=dbManager.getConnection();
		
		try {
			stmt=con.createStatement();
			rsobj=stmt.executeQuery(insertQuery);
			while(rsobj.next()) {
				deptId=rsobj.getInt(1);
				
			}
			System.out.println(deptId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally {
			dbManager.closeConnection(con);
			
		}
		// TODO Auto-generated method stub
		return deptId;
	}
	
	
	public List<Department> getdepartmentDetails(){
		List<Department> depts = new ArrayList<>();
		
		String myData="Select * from  department";
		try {
			con=dbManager.getConnection();
			psmt=con.prepareStatement(myData);
			rsobj=psmt.executeQuery();
			while(rsobj.next()) {
				int deptId=rsobj.getInt("dept_id");
				String deptName=rsobj.getString("dept_name");
				String deptCity=rsobj.getString("dept_city");
				String deptState=rsobj.getString("dept_state");
				
				Department dt =new Department(deptId,deptName,deptCity,deptState);
				depts.add(dt);
			}
			System.out.println(depts);
		}
		catch(Exception e) {
			
		}
		
		return depts;
		
	}
	

}
