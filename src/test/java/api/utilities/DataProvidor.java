package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidor {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		
		String path = System.getProperty("user.dir") + "//testdata//Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String progdata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				progdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return progdata;
	}

}
