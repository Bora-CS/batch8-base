package utils;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pojo.SearchResult;

public class ExcelUtilities {

	public static void writeResultToExcel(String searchTerm, ArrayList<SearchResult> searchResults) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(searchTerm);

		XSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Price");
		headerRow.createCell(2).setCellValue("Title");

		int rowNum = 1;
		for (SearchResult searchResult : searchResults) {
			XSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(searchResult.id);
			row.createCell(1).setCellValue(searchResult.price);
			row.createCell(2).setCellValue(searchResult.title);
			rowNum++;
		}

		FileOutputStream os;
		try {
			os = new FileOutputStream("target/amazonTest.xlsx");
			workbook.write(os);

			workbook.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
