package com.automated.db;

import java.sql.Connection;

/**
 *
 * @author drdtl007
 */
public interface DbInterface 
{
    public Connection getConnection();   
    public void close();
}
