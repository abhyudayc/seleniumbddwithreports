package com.abhyuday.seleniumbddwithreports.generators;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.abhyuday.seleniumbddwithreports.fileio.FileHandler.CSVFileHandler;

public class LogGenerator {

	private static String FILE_PATH = null;
	private static CSVFileHandler csvFileHandler = null;
	
	public static void openLogSession() {
		FILE_PATH = System.getProperty("user.dir") + "\\output\\logs\\logs.csv";
		String hostname = null;
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.err.println("Unable to fetch the hostname");
		}
		csvFileHandler = new CSVFileHandler(FILE_PATH, hostname, "Pre-Production");
		System.out.println("Session opened");
	}
	
	public static void log(String[] data) {
		StringBuilder logData = new StringBuilder();
		for(String datum: data) {
			logData.append(datum);
			logData.append(",");
		}
		logData.deleteCharAt(logData.length() - 1);
		csvFileHandler.writeToCSV(logData.toString() + "\n");
	}
	
	public static void closeLogSession() {
		csvFileHandler.closeCSVFileSession();
	}
}
