package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelHandling {
	
	public static String path = "C:\\Users\\1\\Desktop\\ExcelSheetData\\testdata.xlsx";
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String readData1(String sheet_name,int row_num,int cell_num)
	{
		
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			cell = wb.getSheet(sheet_name).getRow(row_num).getCell(cell_num);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		String data;
		//--------------------------------------------------
		try
		{
			 data =cell.getStringCellValue();
		}
		catch (Exception e)
		{
			double data01 = cell.getNumericCellValue();
			int data1 = (int)data01;
			data = String.valueOf(data1);
		}
		
		return data;
	}
	
	public static String readData(String sheet_name,int row_num,int cell_num)
	{
		
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			cell = wb.getSheet(sheet_name).getRow(row_num).getCell(cell_num);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		
		return data;
	}
	
	public static int getRowNumber(String sheet_name)
	{
		
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheet_name);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		int total_rows=sheet.getLastRowNum();
		return total_rows;
	}
	
	public static int getCellNumber(String sheet_name,int row_num)
	{
		
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheet_name);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		int total_cells = sheet.getRow(row_num).getLastCellNum();
		return total_cells;
	}
	
	
	public static void writeData(String sheet_name,int row_num,int cell_num,String status)
	{
		
		try 
		{
			file = new File(path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			row = wb.getSheet(sheet_name).getRow(row_num);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		row.createCell(cell_num).setCellValue(status);
		FileOutputStream fos;
		try 
		{
			fos = new FileOutputStream(file);
			wb.write(fos);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
