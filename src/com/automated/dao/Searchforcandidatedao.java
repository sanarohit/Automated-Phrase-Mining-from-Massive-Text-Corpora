package com.automated.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import com.automated.db.DbCon;
import com.automated.dto.Profilebean;

public class Searchforcandidatedao extends DbCon{

	public ArrayList<Profilebean> searchcondidates(String candidatename) {
		
		int count=0;
		int k=0;
		int j=0;
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select CID,CANDIDATENAME,DESCRIPTION,UPLOADDATE,TOPICNAME,ACCESSPOINTS  from CANDIDATEDETAILS where CANDIDATENAME=?");
			PreparedStatement ps5=con.prepareStatement("select count(CANDIDATENAME)  from CANDIDATEDETAILS");
			ResultSet rs7=ps5.executeQuery();
			while (rs7.next()) {
				
				count=rs7.getInt(1);
				 
				}
			ps.setString(1, candidatename);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				String desc=rs.getString(3);
				Date d=rs.getDate(4);
				DateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
				String date=sd.format(d);
				int accesspoint=rs.getInt(6);
				String topicname=rs.getString(5);				
				
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setDesc(desc);
				pb.setDate(date);
				pb.setAccesspoint(accesspoint);
				pb.setTopicname(topicname);		
				
				pb.setCount(count);
				System.out.println("size===>"+list.size());
				System.out.println("Count======>"+count);
				
				list.add(pb);
				
				
				PreparedStatement ps6=con.prepareStatement("insert into positive(pid,candidatename) values(?,?)");
				PreparedStatement ps7=con.prepareStatement("select max(pid) from positive");
				ResultSet rs8=ps7.executeQuery();
				while (rs8.next()) {
					
					k=rs8.getInt(1);
					k=k+1;
					 
					}
				ps6.setInt(1, k);
				ps6.setString(2,candidate);
				ps6.executeUpdate();
				
				PreparedStatement ps8=con.prepareStatement("select distinct(CANDIDATENAME) from CANDIDATEDETAILS where CANDIDATENAME !=?");
				ps8.setString(1, candidatename);
				ResultSet rs9=ps8.executeQuery();
				while (rs9.next()) {
					
					String cname=rs9.getString(1);
					 
					
				
				PreparedStatement ps9=con.prepareStatement("select max(nid)  from NEGATIVE");
				ResultSet rs1=ps9.executeQuery();
				while (rs1.next()) {
					
					j=rs1.getInt(1);
					 j=j+1;
					}
				PreparedStatement ps1=con.prepareStatement("insert into negative(nid,candidatename) values(?,?)");
				ps1.setInt(1, j);
				ps1.setString(2,cname);
				ps1.executeUpdate();
				} 
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public int storehistory(int cid, String userid) {
		System.out.println("my cid------>"+cid);

		int i=0;
		int hid=0;
		int accesspoint=0;
		Connection con=getConnection();
		
		
		try {
			PreparedStatement ps1=con.prepareStatement("Select max(hid) from HISTORY_TABLE ");
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				hid=rs1.getInt(1);
				hid=hid+1;
				
			}
			
			
			PreparedStatement ps2=con.prepareStatement("Select max(ACCESSPOINTS) from CANDIDATEDETAILS where CID=? ");
			ps2.setInt(1, cid);
			ResultSet rs2=ps2.executeQuery();
			while (rs2.next()) {
				accesspoint=rs2.getInt(1);
				accesspoint=accesspoint+1;
				
			}
			
			
			PreparedStatement ps3=con.prepareStatement("update CANDIDATEDETAILS set ACCESSPOINTS=? where cid=? ");
			ps3.setInt(1, accesspoint);
			ps3.setInt(2, cid);
			ps3.executeUpdate();
			
						
			PreparedStatement ps=con.prepareStatement("insert into HISTORY_TABLE(HID,CID,USERID,SEARCHDATE) values(?,?,?,?)");
			ps.setInt(1, hid);
			ps.setInt(2, cid);
			ps.setString(3, userid);
			java.util.Date d=new java.util.Date(); 
			long t=d.getTime();
			java.sql.Date date=new java.sql.Date(t);
			ps.setDate(4, date);
			
				ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Profilebean> searchhistory(String userid) {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				Date d1=rs.getDate(3);
				DateFormat sd1=new SimpleDateFormat("dd/MM/yyyy");
				String date1=sd1.format(d1);
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setSearchdate(date1);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Profilebean> phraseminig(String userid) {

		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				Date d1=rs.getDate(3);
				DateFormat sd1=new SimpleDateFormat("dd/MM/yyyy");
				String date1=sd1.format(d1);
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setSearchdate(date1);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Profilebean> getphrasemining(int cid2) {
	
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select distinct(c.CID),c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,c.TOPICNAME from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and C.CID=?");
			
			ps.setInt(1, cid2);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				String desc=rs.getString(3);
				Date d1=rs.getDate(4);
				DateFormat sd1=new SimpleDateFormat("dd/MM/yyyy");
				String date1=sd1.format(d1);
				String topicname=rs.getString(5);
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setDesc(desc);
				pb.setSearchdate(date1);
				pb.setTopicname(topicname);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Profilebean> transactiondetails() {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.TOPICNAME,h.SEARCHDATE,h.USERID from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID order by h.SEARCHDATE asc");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				String topicname=rs.getString(3);
				Date d1=rs.getDate(4);
				DateFormat sd1=new SimpleDateFormat("dd/MM/yyyy");
				String date1=sd1.format(d1);
				String userid=rs.getString(5);
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setTopicname(topicname);
				pb.setSearchdate(date1);
				pb.setLoginid(userid);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Profilebean> getphraseminingdetails() {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,h.SEARCHDATE,c.TOPICNAME,h.USERID from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID order by h.SEARCHDATE asc");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				Date d1=rs.getDate(3);
				DateFormat sd1=new SimpleDateFormat("dd/MM/yyyy");
				String date1=sd1.format(d1);
				String topicname=rs.getString(4);
				String userid=rs.getString(5);
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setSearchdate(date1);
				pb.setTopicname(topicname);
				pb.setLoginid(userid);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Profilebean> getaccesspoints() {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select CANDIDATENAME,sum(ACCESSPOINTS) from CANDIDATEDETAILS group by CANDIDATENAME ");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				
				String candidate=rs.getString(1);
				int accesspoint=rs.getInt(2);
				pb.setCandidatename(candidate);
				pb.setAccesspoint(accesspoint);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Profilebean> getautophraseminingdetails(int cid3) {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select distinct(c.CID),c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and C.CID=?");
			
			ps.setInt(1, cid3);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid=rs.getInt(1);
				String candidate=rs.getString(2);
				String desc=rs.getString(3);
				Date d1=rs.getDate(4);
				DateFormat sd1=new SimpleDateFormat("dd/MM/yyyy");
				String date1=sd1.format(d1);
				pb.setCid(cid);
				pb.setCandidatename(candidate);
				pb.setDesc(desc);
				pb.setSearchdate(date1);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<Profilebean> getdetails(int cid) {
		
		
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select CID,CANDIDATENAME,DESCRIPTION,UPLOADDATE,TOPICNAME,ACCESSPOINTS  from CANDIDATEDETAILS where CID=?");
			
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				int cid1=rs.getInt(1);
				String candidate=rs.getString(2);
				String desc=rs.getString(3);
				Date d=rs.getDate(4);
				DateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
				String date=sd.format(d);
				int accesspoint=rs.getInt(6);
				String topicname=rs.getString(5);
				
				
				pb.setCid(cid1);
				pb.setCandidatename(candidate);
				pb.setDesc(desc);
				pb.setDate(date);
				pb.setAccesspoint(accesspoint);
				pb.setTopicname(topicname);		
				
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				 
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Profilebean> positivepool() {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select CANDIDATENAME,count(CANDIDATENAME) from POSITIVE group by CANDIDATENAME");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				
				String candidate=rs.getString(1);
				int ppoolcount=rs.getInt(2);
				pb.setCandidatename(candidate);
				pb.setPpoolcount(ppoolcount);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Profilebean> negativepool() {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			/*PreparedStatement ps=con.prepareStatement("select c.CID,c.CANDIDATENAME,c.DESCRIPTION,c.UPLOADDATE,h.SEARCHDATE from CANDIDATEDETAILS c,HISTORY_TABLE h where c.CID=h.CID and h.USERID=? order by h.SEARCHDATE asc");*/
			PreparedStatement ps=con.prepareStatement("select CANDIDATENAME,count(CANDIDATENAME) from NEGATIVE group by CANDIDATENAME");
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				Profilebean pb=new Profilebean();
				
				String candidate=rs.getString(1);
				int npoolcount=rs.getInt(2);
				pb.setCandidatename(candidate);
				pb.setNpoolcount(npoolcount);
				
				list.add(pb);
				//System.out.println("details===>"+cid+"\n"+candidate+"\n "+desc+"\n "+date);
				
			}			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	}
