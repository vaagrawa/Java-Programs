package com.cloudwick.java.ParseFiles;

//Referenec: http://www.codingforums.com/java-and-jsp/147387-merge-csv-files-specified-folder-using-java.html
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ReadandAppend {

	public String write(Path file) {

		// create output file if one doesnt exist

		File fileOut = new File("Output.csv");
		if (fileOut.exists()) {
			System.out.println(" Output File already exists");
		} else {
			try {
				fileOut.createNewFile();
				System.out.println("New output File Created at"
						+ fileOut.getAbsolutePath());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fileOut, true));
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(file.toFile()));
				System.out.println("Reading: " + file.toFile().getName()
						+ "File");
				String text = null;
				while ((text = in.readLine()) != null) {
					out.write(text);
					out.newLine();
					out.flush();
				}
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return fileOut.getAbsolutePath();
		
		

	}
}
