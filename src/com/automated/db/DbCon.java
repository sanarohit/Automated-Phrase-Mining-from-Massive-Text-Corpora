

package com.automated.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.automated.dbutill.DataObject;
import com.automated.dbutill.LoggerManager;


/**
 *
 * @author
 **/
public class DbCon extends DataObject implements DbInterface{
    
    Connection con;
    public DbCon() {
    }

    public Connection getConnection() 
    {
        try
        {
            if(con==null)
            {
                try 
                {
                   Properties p = getProperties();
                  
                   Class.forName(p.getProperty("driver"));
                   System.out.println("Driver loaded");
                   con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("duser"),p.getProperty("dpass"));
                   
                   
                   System.out.println("Connection established"+con);
                  
                  
                }
                catch (ClassNotFoundException cnf)
                {
                	LoggerManager.writeLogWarning(cnf);
                }
            }
        } 
        catch (SQLException sqlex) 
        {
        	
        	sqlex.printStackTrace();
        	LoggerManager.writeLogSevere(sqlex);
        }  
        return con;
    }
    public void close()
    {
        if(con!=null)
        {
            try {
                con.close();
            } catch (SQLException sqlex) {
            	LoggerManager.writeLogSevere(sqlex);
            }
        }
    }
}
