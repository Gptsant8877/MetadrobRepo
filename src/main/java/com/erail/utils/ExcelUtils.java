package com.erail.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static InputStream fis;
	public static Workbook wbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;

	public static String getCellValue(String fileName,String sheetName, int rowNo, int cellNo) {
		String cellValue = null;
		try {
		 fis = new FileInputStream(fileName);
		 wbook = new XSSFWorkbook(fis);
		 sheet = wbook.getSheet(sheetName);
		 row =  sheet.getRow(rowNo);
		 cell = row.getCell(cellNo);
		 cellValue = cell.getStringCellValue();
		wbook.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cellValue;
	}

	public static int getRowCount(String fileName, String sheetName) {
		int ttlRows = -1;
		try {
			fis = new FileInputStream(fileName);
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheet(sheetName);
			ttlRows = sheet.getLastRowNum() + 1;
			wbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ttlRows;
	}

	public static int getColumCount(String fileName, String sheetName) {
		int ttlCell = -1;
		try {
			fis = new FileInputStream(fileName);
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheet(sheetName);
			ttlCell = sheet.getRow(0).getLastCellNum();
			wbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ttlCell;
	}
	
	 public static void writeToExcel(String[] data, String filePath) throws IOException {
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Sheet1");
	        for (int i = 0; i < data.length; i++) {
	            Row row = sheet.createRow(i);
	            Cell cell = row.createCell(0);
	            cell.setCellValue(data[i]);
	        }
	        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
	            workbook.write(outputStream);
	        }
	        workbook.close();
	    }
	 
	 public static List<String> getCellValuesInList(String filePath) throws IOException {
	        List<String> data = new ArrayList<>();
	        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
	            Workbook workbook = new XSSFWorkbook(fileInputStream);
	            Sheet sheet = workbook.getSheetAt(0);
	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    data.add(cell.getStringCellValue());
	                }
	            }
	            workbook.close();
	        }
	        return data;
	    }

}
