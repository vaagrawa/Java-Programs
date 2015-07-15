package com.cloudwick.java.ParseFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opencsv.CSVReader;

//Reference: http://thinktibits.blogspot.com/2012/12/Convert-CSV-to-XLS-Using-Java-POI-OpenCSV-Example.html

public class ConvertCSVtoExcel {

	public void csvtoExcel(String inputFile) {
		try {
			CSVReader readin = new CSVReader(new FileReader(inputFile));

			// Create new workbook
			
			HSSFWorkbook output_workbook = new HSSFWorkbook();
			HSSFSheet output_sheet = output_workbook.createSheet();
			Map<String,Object[]> excel_data = new HashMap<String, Object[]>();
			while(readin.readNext()!=null)
			{
			excel_data.put(Integer.toSt, arg1)	
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
