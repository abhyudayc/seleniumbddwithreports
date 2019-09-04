package com.abhyuday.seleniumbddwithreports.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandler {

	public static class CSVFileHandler {
		
		private BufferedWriter bw = null;
		
		public CSVFileHandler(String path, String hostname, String env) {
			try {
				bw = new BufferedWriter(new FileWriter(path));
				bw.append("hostname: " + hostname + ", environment: " + env + "\n");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void closeCSVFileSession() {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("null")
		public boolean writeToCSV (List<List<String>> data) {
			boolean isWritten = false;
			try {
				for (List<String> line: data) {
					StringBuilder lineWithComma = null;
					for (String word: line) {
						lineWithComma.append(word);
						lineWithComma.append(",");
					}
					lineWithComma.deleteCharAt(lineWithComma.length() - 1);
					lineWithComma.append("\r\n");
					bw.write(lineWithComma.toString());
				}
				isWritten = true;
			} catch (Exception e) {
				isWritten = false;
			}
			return isWritten;
		}

		public boolean writeToCSV (String data) {
			boolean isWritten = false;
			try {
				bw.append(data);
				isWritten = true;
			} catch (Exception e) {
				e.printStackTrace();
				isWritten = false;
			}
			return isWritten;
		}
	}
	
	public static class ExcelFileHandler {
		private static XSSFWorkbook workbook;
		private static XSSFSheet sheet;
		
		public static void init() throws IOException {
			workbook = new XSSFWorkbook("C:\\Users\\Abhyuday\\Desktop\\testdata.xlsx");
			sheet = workbook.getSheet("preprod_data");
		}
		
		public static List<Map<String, String>> getData() {
			List<Map<String, String>> data = new ArrayList();
			Iterator<Row> rowIterator = sheet.rowIterator();
			int rowCount = 0;
			List<String> headings = new ArrayList();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				int cellCounter = 0;
				rowCount++;
				Iterator<Cell> cellIterator = row.cellIterator();
				Map<String, String> dataMap = new HashMap<String, String>(); 
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch(cell.getCellTypeEnum()) {
					case STRING:
						if(rowCount == 1) {
							headings.add(cell.getStringCellValue());
						}
						else {
							dataMap.put(headings.get(cellCounter++), cell.getStringCellValue());
						}
						break;
					case BLANK:
						if(rowCount == 1) {
							headings.add("");
						}
						else {
							dataMap.put(headings.get(cellCounter++), "");
						}
						break;
					case NUMERIC:
						if(rowCount == 1) {
							headings.add(cell.getNumericCellValue() + "");
						}
						else {
							dataMap.put(headings.get(cellCounter++), cell.getNumericCellValue() + "");
						}
						break;
					default:
						if(rowCount == 1) {
							headings.add(cell.getNumericCellValue() + "");
						}
						else {
							dataMap.put(headings.get(cellCounter++), cell.getStringCellValue() + "");
						}
						break;
							
					}
				}
				data.add(dataMap);
			}
			return data;
		}
	}
}
