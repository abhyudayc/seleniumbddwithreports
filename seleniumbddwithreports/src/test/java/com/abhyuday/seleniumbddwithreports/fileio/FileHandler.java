package com.abhyuday.seleniumbddwithreports.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

	public static class CSVFileHandler {
		
		private String path = null;
		private BufferedWriter bw = null;
		
		public CSVFileHandler(String path) {
			try {
				this.path = path;
				bw = new BufferedWriter(new FileWriter(path));
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
	
	static class ExcelFileHandler {
		
	}
}
