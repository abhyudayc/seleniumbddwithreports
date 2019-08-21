package com.abhyuday.seleniumbddwithreports.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

	public static class CSVFileHandler {
		
		private String path = null;
		private PrintWriter pw = null;
		
		public CSVFileHandler(String path) {
			try {
				this.path = path;
				pw = new PrintWriter(new BufferedWriter(new FileWriter(path)));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void closeCSVFileSession() {
			pw.close();
		}
		
		public void readFromCSV () throws FileNotFoundException {
			Scanner scanner = new Scanner(new File(path));
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
					pw.println(lineWithComma.toString());
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
				pw.println(data);
				isWritten = true;
			} catch (Exception e) {
				e.printStackTrace();
				isWritten = false;
			}
			return isWritten;
		}
	}
	
	static class ExcelFileHandler {
		
	}
}
