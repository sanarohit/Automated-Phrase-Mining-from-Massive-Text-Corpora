package com.automated.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.automated.db.DbCon;
import com.automated.dto.Profilebean;


public class Logindao extends DbCon {

	public ArrayList<Profilebean> datauserlogin(Profilebean pb) {
		Connection con=null;
		//int i=0;
		Profilebean pb1=null;
		
		
		
		String uid=pb.getLoginid();
		String password=pb.getPassword();
				
		con=getConnection();
	
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select role,username,STATUS from USERINFO  where LOGINID=? and password=? ");
			ps.setString(1, uid);
			ps.setString(2, password);
						
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				pb1=new Profilebean();
				String role=rs.getString(1);
				String username= rs.getString(2);
				String status= rs.getString(3);
				
				
				pb1.setRole(role);
				pb1.setUsername(username);
				pb1.setStatus(status);
				
					
				list.add(pb1);
				
				
			}
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
		
	}

	public ArrayList<Profilebean> transportuserlogin(Profilebean pb) {
		Connection con=null;
		//int i=0;
		Profilebean pb1=null;
		
		
		
		String uid=pb.getLoginid();
		String password=pb.getPassword();
		
		
		con=getConnection();
	
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select role,username,STATUS from USERINFO  where LOGINID=? and password=? ");
			ps.setString(1, uid);
			ps.setString(2, password);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				pb1=new Profilebean();
				String role=rs.getString(1);
				String username= rs.getString(2);
				String status= rs.getString(3);
							
				
				pb1.setRole(role);
				pb1.setUsername(username);
				pb1.setStatus(status);
									
				list.add(pb1);
				
				
			}
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	

}
