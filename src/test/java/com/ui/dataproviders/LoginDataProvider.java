package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.Users;
import com.utility.ExcelReaderUtility;
import com.utility.CSVReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LogintestDataProvider")

	public  Iterator<Object[]> loginDataProvider() throws FileNotFoundException {

		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\\testdata\\loginData.json");
		FileReader fileReader = new FileReader(testDataFile);

		
		TestData testData = gson.fromJson(fileReader, TestData.class);

		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (Users user : testData.getdata()) {

			dataToReturn.add(new Object[] { user });

		}
		return dataToReturn.iterator();

	}
	@DataProvider(name="LogintestCSVDataProvider")
	public Iterator<Users> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("LoginData.csv");
		
	}
	@DataProvider(name="LoginTestExcelDataDataProvider")
	public Iterator<Users> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("LoginDataExcel.xlsx");
		
	}

}
