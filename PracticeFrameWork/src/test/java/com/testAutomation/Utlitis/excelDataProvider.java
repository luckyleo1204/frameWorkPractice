package com.testAutomation.Utlitis;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider
	{
		XSSFWorkbook wb;

		public excelDataProvider()
			{

				File src = new File("./TestData/TestData.xlsx");
				FileInputStream fis;
				try
					{
						fis = new FileInputStream(src);
						wb = new XSSFWorkbook(fis);
					} catch (Exception e)
					{
						System.out.println("Unable to Read from Excel file" + e.getMessage());
					}
			}

		public String getStringData(String sheetName, int row, int column)
			{
				return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

			}

		public double getNumberidData(String sheetName, int row, int column)
			{
				return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

			}

		public double getStringData(int sheetIndex, int row, int column)
			{
				return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();

			}

	}
