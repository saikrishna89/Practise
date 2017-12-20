package com.homedepot.renowalk.UtilManager;
 
import java.util.*;

import Exception.FilloException;
import Fillo.*;

public class FilloUtil {
	
	public static final String sFileLocation = "C:\\ParserSpace\\ComparisonBook.xlsx"; //This needs to be automatically found later
	
	public static List<List<String>> getBudgetRecordSet(String tableName) throws FilloException {
		List<List<String>> allRecords = new ArrayList<List<String>>();
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("C:\\ParserSpace\\ComparisonBook.xlsx");
		Recordset rS = connection.executeQuery("Select * from " + tableName);
		while (rS.next()) {
			List<String> record = new ArrayList<String>();
			record.add(rS.getField("GroupName"));
			record.add(rS.getField("ItemTitle"));
			record.add(rS.getField("ItemComments"));
			record.add(rS.getField("ItemQuantity"));
			record.add(rS.getField("ItemUnitPrice"));
			record.add(rS.getField("ItemTotalPrice"));
			allRecords.add(record);
		}
		rS.close();
		connection.close();
		return allRecords;
	}
	
	public static boolean insertBudgetRecordSet(String tableName, List<List<String>> records) throws FilloException {
		boolean b = true;
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(sFileLocation);
		try { 
			
			for (List<String> record : records) {
				String divider = "";
				String query;
				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO ");
				sb.append(tableName);
				sb.append(" (GroupName,ItemTitle,ItemComments,ItemQuantity,ItemUnitPrice,ItemTotalPrice) ");
				sb.append(" VALUES ");
				sb.append("(");
				for (String value : record) {
					sb.append(divider);
					sb.append("'" + value + "'");
					divider = ",";
				}
				sb.append(")");
				query = sb.toString();
				connection.executeUpdate(query);
			}
			
			} catch (Exception e) {
				b = false;
				e.printStackTrace();
			}
		connection.close();
		return b;
	}
	public static boolean insertComparison(List<String> input) throws FilloException {
		boolean b = true;
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(sFileLocation);
		try { 
			String divider = "";
			String query;
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO COMPARISONRESULTS ");
			if (input.size() == 6) {
				sb.append("(GroupNameiPad,ItemTitleiPad,GroupNameWeb,ItemTitleWeb,IsMatching,Comment)");
			}
			sb.append(" VALUES (");
			for (String value : input) {
				sb.append(divider);
				sb.append("'" + value + "'");
				divider = ",";
			}
			sb.append(")");
			query = sb.toString();
			connection.executeUpdate(query);
			} catch (Exception e) {
				b = false;
				e.printStackTrace();
			}
		connection.close();
		return b;
	}
	
	public static String compareRecords(List<String> ipadRec, List<String> webRec)
	{
		boolean b = false;
		String s = "";
		for (int i = 0; (i < ipadRec.size()) && (i < webRec.size()); i++) {
			if (ipadRec.get(i).equals(webRec.get(i))){
				b = true;
			} else {
				b = false;
				s = String.valueOf(b).concat("," + String.valueOf(i));
				break;
			}
		}
		if (b) {
			s = String.valueOf(b).concat(",None");
		}
		return s;
	}
}
