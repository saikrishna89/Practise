package com.homedepot.renowalk.UtilManager;

import java.sql.SQLException;
import java.util.Properties;

import com.homedepot.renowalk.TestDriver;
import com.homedepot.renowalk.ConfigManager.FileLocSetter;
import com.homedepot.renowalk.ConfigManager.SQLConfig;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.pool.OracleDataSource;

public class DBUtil{

	SQLConfig objSQLConfig= new SQLConfig();
	PropUtil objPropertiesUtility = new PropUtil();
	Properties prop = objPropertiesUtility.fnLoadObjects(FileLocSetter.sConfigPath, "global.properties");
	String sConnString = "jdbc:oracle:thin:"+prop.getProperty("atmUser")+"/"+prop.getProperty("atmPass")+"@"+prop.getProperty("atmHostName")+":"+prop.getProperty("atmPort")+"/"+prop.getProperty("atmSid");
	 
	public OracleConnection fnOpenDBConnection(String sConnString) throws Exception
		{
		 OracleConnection ocon=null;
		 TestDriver.rset = null;
			try {
				
				OracleDataSource ods = new OracleDataSource();
				System.out.println(sConnString);
				ods.setURL(sConnString);
				
				// connect to the database and turn off auto commit
				ocon = (OracleConnection)ods.getConnection();
				ocon.setAutoCommit(true);
				
			} catch (Exception e) {
				System.out.println("Function fnOpenDBConnection Failed");
				TestDriver.log.error("Function fnOpenDBConnection Failed ", e);
				throw(e);
			}	
			
			return ocon;
		}
	 
	 public void fnCloseDBConnection(OracleStatement stmt, OracleResultSet rset, OracleConnection ocon) throws Exception
		{
		 
			try {
				//stmt.close();
				if(rset!=null)
				{
					rset.close();
				}
				if(ocon!=null)
				{
					ocon.close();
				}
			} catch (Exception e) {
				System.out.println("Function fnCloseDBConnection Failed");
				TestDriver.log.error("Function fnCloseDBConnection Failed ", e);
				throw(e);
			}	
			
		}
	 
	 public OracleResultSet fnGetDBData(OracleConnection ocon,String sQuery) throws Exception
		{
		 
		 OracleResultSet rset = null;
		 try {
				// create the statement and execute the query
				OracleStatement stmt = (OracleStatement)ocon.createStatement();
				rset = (OracleResultSet)stmt.executeQuery(sQuery);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				TestDriver.log.error("Function fnGetDBData Failed ", e);
			}
		 return rset;
		}
	 
	 
	 
	 public Boolean fnUpdateDBData(OracleConnection ocon,String sQuery) throws Exception
		{
		 
		 boolean bUpdateResult = false;
			try {
				
				OracleStatement stmt = (OracleStatement)ocon.createStatement();
				stmt.executeQuery(sQuery);
				ocon.commit();
				bUpdateResult = true;
				
			} catch (Exception e) {
				bUpdateResult = false;
				System.out.println("Function fnUpdateDBData Failed");
				TestDriver.log.error("Function fnUpdateDBData Failed ", e);
				throw(e);
			}
			return bUpdateResult;	
			
		}
	 
}
