package com.cp.demo.contoller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cp.demo.exception.CPException;
import com.cp.inv.util.DBManager;

public class DemoController {

	public DemoController() {

	}

	public void CreatConnection() {
		DBManager dbm = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			dbm = DBManager.getDBManager();
			con = dbm.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT count(*) FROM information_schema.tables WHERE table_schema = 'public';");
			if (rs.next())
				System.out.println(rs.getInt(1));
		} catch (CPException exp) {
			exp.printStackTrace();
		} catch (Exception exp1) {
			exp1.printStackTrace();
		} finally {
			dbm.closeConnection(con);
			try {
				rs.close();
				st.close();
			} catch (Exception exp) {

			}
		}

	}
}
