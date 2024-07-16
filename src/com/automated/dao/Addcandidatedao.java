package com.automated.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.automated.db.DbCon;
import com.automated.dto.Profilebean;

public class Addcandidatedao extends DbCon{

	public int addcandidates(Profilebean pb) {
		
		String candidatename=pb.getCandidatename();
		String desc=pb.getDesc();
		String topicname=pb.getTopicname();
		
		Connection con=getConnection();
		int cid=0;
		int i=0;
		try {
			
			PreparedStatement ps=con.prepareStatement("select max(CID) from CANDIDATEDETAILS");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				cid=rs.getInt(1);
				cid=cid+1;
			}
			
			
			
			PreparedStatement ps1=con.prepareStatement("insert into CANDIDATEDETAILS(CID,CANDIDATENAME,DESCRIPTION,UPLOADDATE,ACCESSPOINTS,TOPICNAME) values(?,?,?,?,?,?)");
			
			ps1.setInt(1, cid);
			ps1.setString(2, candidatename);
			ps1.setString(3, desc);
			Date d=new Date();
			long t=d.getTime();
			java.sql.Date date=new java.sql.Date(t);
			ps1.setDate(4, date);
			ps1.setInt(5, 0);
			ps1.setString(6, topicname);
			i=ps1.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Profilebean> viewcandidatedetails() {
		
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			
			PreparedStatement ps=con.prepareStatement("select CID,CANDIDATENAME,DESCRIPTION,UPLOADDATE,ACCESSPOINTS,TOPICNAME from CANDIDATEDETAILS");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidatename=rs.getString(2);
				String desc=rs.getString(3);
				Date date=rs.getDate(4);
				 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				    String d= df.format(date);
				    int accesspoint=rs.getInt(5);
					String topicname=rs.getString(6);
					
				    
				    pb.setCid(cid);
				    pb.setCandidatename(candidatename);
				    pb.setDesc(desc);
				    pb.setDate(d);
				    pb.setAccesspoint(accesspoint);
				    pb.setTopicname(topicname);
				    
				    
				    System.out.println("cid==>"+cid);
				    System.out.println("candidatename==>"+candidatename);
				    System.out.println("d==>"+d);
				    list.add(pb);
				    
				    System.out.println("list size==========>"+list.size());
				    
						
			}
				} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
public ArrayList<Profilebean> getcandidatenames() {
		
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			
			PreparedStatement ps=con.prepareStatement("select distinct(CANDIDATENAME) from CANDIDATEDETAILS");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				String candidatename=rs.getString(1);
				pb.setCandidatename(candidatename);
				   				    
				    
				    list.add(pb);
				    
						
			}
				} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	}
