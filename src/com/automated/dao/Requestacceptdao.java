package com.automated.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.automated.db.DbCon;
import com.automated.dto.Profilebean;

public class Requestacceptdao extends DbCon {

	public int requestaccept(Profilebean pb) {
		
		int i=0;
		String loginid=pb.getLoginid();
		String status=pb.getStatus();
		Connection con=getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update USERINFO set STATUS=? where LOGINID=?");
			
			ps.setString(1, "Active");
			ps.setString(2, loginid);
			
			 i=ps.executeUpdate();
			 
		} catch (SQLException e) {
			
			e  .printStackTrace();
		}
		return i;
	}

}
