package com.automated.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.automated.db.DbCon;
import com.automated.dto.Profilebean;

public class Viewuserrequestdao extends DbCon {

	public ArrayList<Profilebean> viewrequestedusers() {
		
		Connection con=getConnection();
		ArrayList<Profilebean> list= new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT LOGINID,USERNAME,EMAIL,MOBILE,GENDER,ADDRESS FROM USERINFO WHERE ROLE=? AND STATUS=?");
			ps.setString(1, "User");
			ps.setString(2, "Pending");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Profilebean pb=new Profilebean();
				String loginid=rs.getString(1);
				String username=rs.getString(2);
				String email=rs.getString(3);
				String mobile=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				
				pb.setLoginid(loginid);
				pb.setUsername(username);
				pb.setEmail(email);
				pb.setMobileno(mobile);
				pb.setGender(gender);
				pb.setAddress(address);
				
				
				list.add(pb);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}

}