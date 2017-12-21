package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	 public FileInputStream fileInput = null;
	 public FileOutputStream fileOutput =null;
	 public XSSFWorkbook wb = null;
	 public static XSSFSheet ws = null;
	
	 static{
		 
		 try(FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"//TestData//TestData.xlsx"); XSSFWorkbook wb = new XSSFWorkbook(fileInput)){
			 ws = wb.getSheet("TestData");
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }

	public List<String> getCellData(String TCID) throws IOException{
		String ActualStringValue = null;
		List<String> settingValues = null;
		//ReadExcelData();
		if(ws != null){
		int firstrow = ws.getFirstRowNum();
		int lastrow = ws.getLastRowNum();
		for(int i = firstrow+1; i <= lastrow; i++){
			ActualStringValue = ws.getRow(i).getCell(0).getStringCellValue();
			if(ActualStringValue.equalsIgnoreCase(TCID)){
	
				settingValues = new ArrayList<String>();
				DataFormatter formatter = new DataFormatter();
				Cell cell1 = ws.getRow(i).getCell(2);
				Cell cell2 = ws.getRow(i).getCell(3);
				Cell cell3 = ws.getRow(i).getCell(4);
				Cell cell4 = ws.getRow(i).getCell(5);
				Cell cell5 = ws.getRow(i).getCell(6);
				settingValues.add(formatter.formatCellValue(cell1));
				settingValues.add(formatter.formatCellValue(cell2));
				settingValues.add(formatter.formatCellValue(cell3));
				settingValues.add(formatter.formatCellValue(cell4));
				settingValues.add(formatter.formatCellValue(cell5));
			}
		}
		}
		return settingValues;
	}
	
	public void fnCloseReadExcel()
	{
		
		
		try {
			fileInput.close();
			wb.close();
			fileInput=null;
			wb=null;
			ws=null;
		} catch (IOException e) {
			System.out.println("fnCloseReadExcel--------------Failed");
			e.printStackTrace();
		}
		
	}
}
