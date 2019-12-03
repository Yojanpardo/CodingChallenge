package com.yojanpardo.controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.yojanpardo.interfaces.CreateFile;
import com.yojanpardo.interfaces.ReadQulifierFile;
/**
 * 
 * @author yojan
 * This class contains the methods to handle the files in the project 
 */
public class Files implements CreateFile, ReadQulifierFile{
	/**
	 * method to create a file, receives:
	 * @param String name: it's the name that will be used in the new file
	 * @param ArrayList<String> data: it's the array with the information that will contain the file
	 * @param String lineSeparator: it's the separator that will be used to separate each line
	 */
	@Override
	public void createFile(String name, String[] data, String lineSeparator) {
		String fileSeparator = System.getProperty("file.separator");
		String path = "files" + fileSeparator + name;
		File file = new File(path);
		try {
			if(file.createNewFile()) {
				System.out.println("File '" + path + "' created successfully!");
				PrintWriter writer = new PrintWriter(path,"UTF-8");
				for (String line : data) {
					writer.println(line);
				}
				writer.close();
			} else {
				System.out.println("File '" + path + "' already exists");
			}
		}catch(Exception ex) {
			System.out.println("Error creating the new file: " + ex);
		}
	}
	
	/**
	 * it's used to read a file that contains a qualification for industries, current role, etc.
	 * @param String filePath: it's the relative path that contains the qualification for each category
	 * @param cellSeparator: it's the value used to divide each cell in the file 
	 */
	@Override
	public ArrayList<String[]> readQualifierFile(String filePath, String cellSeparator) {
		File file = new File(filePath);
		BufferedReader br = null;
		ArrayList<String[]> scores = new ArrayList<String[]>();
		try {
			br = new BufferedReader(new FileReader(file));
			String dirtyScore;
			while ((dirtyScore = br.readLine()) != null) {
				String[] cleanScore = dirtyScore.split("\t");
				scores.add(cleanScore);
			}
		}catch(Exception ex) {
			System.out.println("Error trying to read the file: " + ex);
		}
		
		
		return scores;
	}
}
