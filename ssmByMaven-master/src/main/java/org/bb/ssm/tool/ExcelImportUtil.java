package org.bb.ssm.tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelImportUtil {  
    public static List<Map<String, String>> parseExcel(InputStream fis) {  
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();;  
        try {  
        	Workbook book = null;
			try {
				book = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //HSSFWorkbook book = new HSSFWorkbook(fis);  
            Sheet sheet = book.getSheetAt(0);  
            int firstRow = sheet.getFirstRowNum();  
            int lastRow = sheet.getLastRowNum();  
            //除去表头和第一行  
//          ComnDao dao = SysBeans.getComnDao();  
            for(int i = firstRow; i<lastRow+1; i++) {  
                Map map = new HashMap();  
                  
                Row row = sheet.getRow(i);  
                int firstCell = row.getFirstCellNum();  
                int lastCell = row.getLastCellNum();  
                  
                  
                for(int j=firstCell; j<lastCell; j++) {  
                    String key=null;
                    String val=null;
                    Cell cell2 = sheet.getRow(firstRow).getCell(j); 
                    key = cell2.getStringCellValue();
                    /*if(row.getCell(j)!=null){
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                        key = cell2.getStringCellValue(); 
                    }else{
                    	key = "";
                    }*/
                     
                      
                    Cell cell = row.getCell(j);  
                    if(cell!=null){
                    	if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {  
                            cell.setCellType(Cell.CELL_TYPE_STRING);  
                        }  
                        val = cell.getStringCellValue(); 
                    }else{
                    	val="";
                    }
                     
                      
//              System.out.println(val);  
                      
                    if(i == firstRow) {  
                        break;  
                    }else{  
                        map.put(key, val);  
                          
                    }  
//              System.out.println(map);  
                }  
                if(i != firstRow) {  
                    data.add(map);  
                    //System.out.println(map);  
                }  
            }  
            //System.out.println(data);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return data;  
    }  
}
