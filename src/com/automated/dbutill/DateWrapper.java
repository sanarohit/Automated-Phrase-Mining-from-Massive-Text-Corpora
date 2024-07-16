/*
 * DateWrapper.java
 *
 * Created on December 8, 2007, 11:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.automated.dbutill;

import java.util.Date;

/**
 *
 * @author drdtl007
 */
public class DateWrapper {
    
    static String month[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    /** Creates a new instance of DateWrapper */
    public DateWrapper() 
    {
        
    }
    @SuppressWarnings("deprecation")
	public static String parseDate(Date date)
    {
    	int monthid=date.getMonth();
        String newdate=date.getDate()+"-"+month[monthid]+"-"+(date.getYear()+1900);
        System.out.println("new date=="+newdate);
        return newdate;
    }
    public static String parseDate(String date)
    {
    	int monthid=Integer.parseInt(date.substring(date.indexOf("-")+1,date.lastIndexOf("-")));
        String newdate=date.substring(0,date.indexOf("-"))+"-"+month[monthid-1]+"-"+(date.substring(date.lastIndexOf("-")+1,date.length()));
        return newdate;
    }     
    public static String parseDate(java.sql.Date date)
    {
    	String olddate=date.toString();
    	String newdate=olddate.substring(olddate.lastIndexOf("-")+1, olddate.length())+"-"+olddate.substring(olddate.indexOf("-")+1, olddate.lastIndexOf("-"))+"-"+olddate.substring(0,olddate.indexOf("-"));
		return newdate;
    	
    }
}
