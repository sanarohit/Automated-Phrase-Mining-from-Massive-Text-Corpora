package com.automated.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.automated.db.DbCon;
import com.automated.dto.Profilebean;



public class ChangepasswordDao extends DbCon{

	public int changepassword(Profilebean dto) {
		int i=0;
		Connection con=null;
		con=getConnection();
		String userid=dto.getLoginid();
		String oldpassword=dto.getPassword();
		String password=dto.getNewpassword();
		
		try
		{
		
		PreparedStatement ps=con.prepareStatement("select password from USERINFO where LOGINID='"+userid+"' and PASSWORD='"+oldpassword+"'");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			if(rs.getString(1).equals(oldpassword)){
					
				try
				{
				
				PreparedStatement pstmt=con.prepareStatement("update USERINFO set password=? where LOGINID=? ");
				pstmt.setString(1, password);
				pstmt.setString(2, userid);
				 i=pstmt.executeUpdate();
				if(i!=0){
					return i;
				}
				
				}catch (Exception e) {
					
				e.printStackTrace();
					
				}
				
				
			}else{
				
				return i;
				
			}	
			
		}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		
		
		return i;
	}

	public int adminchangepassword(Profilebean dto) {


		
		int i=0;
		Connection con=null;
		con=getConnection();
		String userid=dto.getLoginid();
		String oldpassword=dto.getPassword();
		String password=dto.getNewpassword();	
		
		try
		{
		
		PreparedStatement ps=con.prepareStatement("select password from USERINFO where LOGINID='"+userid+"' and PASSWORD='"+oldpassword+"'");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			if(rs.getString(1).equals(oldpassword)){
					
				try
				{
				
				PreparedStatement pstmt=con.prepareStatement("update USERINFO set password=? where LOGINID=? ");
				pstmt.setString(1, password);
				pstmt.setString(2, userid);
				 i=pstmt.executeUpdate();
				if(i!=0){
					return i;
				}
				
				}catch (Exception e) {
					
				e.printStackTrace();
					
				}			
				
				
			}else{
				
				return i;
				
			}
		
		}
		}catch(Exception e){
			
			e.printStackTrace();
		}	
		
		return i;
	}

	public int updateoldpassword(Profilebean dto) throws SQLException {
		int k=0;
		int oid=0; 
		Connection con=null;
		con=getConnection();
		String userid=dto.getLoginid();
		String oldpassword=dto.getPassword();
				
		
		PreparedStatement ps=con.prepareStatement("select max(O_ID) from OLDPASSWORD_TABLE");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			oid=rs.getInt(1);
			oid=oid+1;
		}		
				try
				{
				
				PreparedStatement pstmt=con.prepareStatement("insert into OLDPASSWORD_TABLE(O_ID,LOGINID,OLDPASSWORD) values(?,?,?)");
				pstmt.setInt(1, oid);
				pstmt.setString(2, userid);
				pstmt.setString(3, oldpassword);
				 k=pstmt.executeUpdate();
			
		}
				catch (Exception e) {
					e.printStackTrace();
				}
		
		return k;
		
	}
	}

