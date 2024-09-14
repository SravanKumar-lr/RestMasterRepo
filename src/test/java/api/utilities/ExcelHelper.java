package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	public static Object[][] readExcelFile(File file) throws IOException {

		InputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		int rowNumbers = sheet.getLastRowNum();
		int colNumbers = sheet.getRow(0).getLastCellNum();
		System.out.println("Total rows are: "+rowNumbers);
		System.out.println("Total coloumns are: "+colNumbers);
		String[][] data = new String[rowNumbers][colNumbers];

		for (int i = 0; i < rowNumbers; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				data[i][j] = row.getCell(j).getStringCellValue();
			}
		}

		return data;

	}

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir") + "//testdata//Data.xlsx";
		Object[][] data = readExcelFile(new File(path));
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
	}

}