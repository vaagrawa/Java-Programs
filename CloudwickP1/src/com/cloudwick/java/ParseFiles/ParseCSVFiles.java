package com.cloudwick.java.ParseFiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//Reference: http://kodejava.org/how-to-recursively-list-all-text-files-in-a-directory/

public class ParseCSVFiles {
	
	public static Path startDir = Paths.get("D:/ExcelDirectory/");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Files.walkFileTree(startDir, new FindCSVFiles());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static class FindCSVFiles extends SimpleFileVisitor<Path>{
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes atribute){
			if(file.toString().endsWith(".csv")){
			System.out.println(file.getFileName());
			
			
			//Read and append that CSV File
			ReadandAppend obj = new ReadandAppend();
			//obj.read();
			String output = obj.write( file);
			// Code to convert the output file into Excel File.
	//		System.out.println("The address of the output file: "+output);
			
	//		ConvertCSVtoExcel csvtoExcelobj = new ConvertCSVtoExcel();
//			csvtoExcelobj.csvtoExcel(output);
			}
		return FileVisitResult.CONTINUE;
		}
	}
}
