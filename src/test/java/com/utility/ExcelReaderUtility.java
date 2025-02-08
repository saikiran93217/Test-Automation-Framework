package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.Users;

public class ExcelReaderUtility {
	public static Iterator<Users> readExcelFile(String fileName) {

		File xlsxFile = new File(System.getProperty("user.dir") + "//testdata//" + fileName);
		List<Users> userList = null;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Users user;
		XSSFWorkbook xssfWorkbook = null;
		Iterator<Row> rowIterator;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<Users>();
			XSSFSheet xssfSheet = xssfWorkbook.getSheet("loginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// skipping the col name
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);

				user = new Users(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();
				// System.out.println(firstCell.toString() );
//			System.out.println(secondCell.toString() );
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
	}
}
