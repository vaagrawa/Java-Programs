package com.cloudwick.java.ParseFiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ParseExcelFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path startDir = Paths.get("D:/ExcelDirectory/");
		try {
			Files.walkFileTree(startDir, new FindExcelFiles());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static class FindExcelFiles extends SimpleFileVisitor<Path>{
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes atribute){
			if(file.toString().endsWith(".xlsx")){
			System.out.println(file.getFileName());
			}
		return FileVisitResult.CONTINUE;
		}
	}
}
