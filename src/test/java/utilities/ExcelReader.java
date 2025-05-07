package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.eventusermodel.XSSFReader;

public class ExcelReader {


	    public static List<List<String>> readExcelData(String filePath) {
	        List<List<String>> excelData = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0);

	            if (sheet == null) {
	                throw new RuntimeException("Sheet not found.");
	            }

	            for (Row row : sheet) {
	                List<String> rowData = new ArrayList<>();
	                for (Cell cell : row) {
	                    cell.setCellType(CellType.STRING); // Convert all cell types to String
	                    rowData.add(cell.getStringCellValue());
	                }
	                excelData.add(rowData);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return excelData;
	    }
	    

	    public static void main(String[] args) {
			System.out.println(ExcelReader.readExcelData("C:\\Users\\Jim\\eclipse-workspace\\Capstone-Project\\seleniumProjects\\src\\main\\resources\\loginData.xlsx"));
			
		}

}
