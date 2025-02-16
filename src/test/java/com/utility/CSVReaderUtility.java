package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.Users;

public class CSVReaderUtility {

	public static Iterator<Users> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "//testdata//" +fileName);
		FileReader fileReader = null;
		CSVReader csvReader;// it will skip the the column
		String[] line;//it will give in string or String array
		List<Users> userList = null ;
		Users userData;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);// heap memory
//			csvReader.readNext();//reading the col Names------Row1
//			csvReader.readNext();//Row2
//			csvReader.readNext();//Row3
			csvReader.readNext();
			//line= csvReader.readNext();//if no row or if we reached  the end of the CSV file readNext() returns you null
		
			
		    userList = new ArrayList<Users>();
			
			//never create List or Array list in loops
			while((line=csvReader.readNext())!=null){
				//initializing and checking null as well with above while loop
				userData = new Users(line[0], line[1]);
					userList.add(userData);
					//After getting the data it stores in array list
			
			}
//			for (Users userdata : userList) {
//				System.out.println(userdata);
//				
//			}
			
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();//Because dataprovider will return in single dimenstional

	}

}
