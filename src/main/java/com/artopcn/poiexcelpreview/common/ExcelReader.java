package com.artopcn.poiexcelpreview.common;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    /**
     *
     * @param filePath 文件地址
     * @param sheetNumber 第几个sheet表
     * @param startRow 开始行数
     * @param startCol 开始列数
     * @param title 表格表头和变量名称对应的map
     * @param clazz 需要转换的类
     * @param <T>
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public static <T> List<T> getList(String filePath, Integer sheetNumber, Integer startRow,
                                  Integer startCol, Map<String,String> title, Class<T> clazz)
            throws IOException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        T t = null;
        InputStream is;
        Map<String,Object> excelValueMap;
        List<T> result = new ArrayList<>();

        is = new FileInputStream(filePath);
        // 读取excel
        excelValueMap = readExcel(is,sheetNumber,startRow,startCol);
        List<String> dataTiles = (List<String>)excelValueMap.get("title");
        List<List<String>> dataList = (List<List<String>>)excelValueMap.get("data");
        for(List<String> rowData : dataList){
            // 创建实体
            t = clazz.newInstance();
            for(Integer index = 0;index<dataTiles.size();index++){
                String objValueName = title.get(dataTiles.get(index));
                setProperty(t,objValueName,rowData.get(index));
            }
            result.add(t);
        }

        return result;
    }

    /**
     * 通过反射设值
     * @param obj
     * @param PropertyName
     * @param value
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setProperty(Object obj, String PropertyName, Object value) throws IllegalAccessException, NoSuchFieldException {
        // 获取obj类的字节文件对象
        Class c = obj.getClass();
        // 获取该类的成员变量
        Field f = null;
        f = c.getDeclaredField(PropertyName);

        // 取消语言访问检查
        f.setAccessible(true);
        // 给变量赋值
        Class<?> clazz = f.getType();
        String type = clazz.getName();
        if(null != value && null != value.toString()){
            if(type.equals("java.lang.Integer")){
                if(!"".equals(value.toString())){
                    f.set(obj, (int)Double.parseDouble(value.toString()));
                }
            }else if(type.equals("java.lang.String")){
                f.set(obj, value.toString());
            }
        }
    }

    /**
     * Excel读取 操作
     */
    public static Map<String,Object> readExcel(InputStream is,Integer sheetNumber, Integer startRow,Integer startCol)
            throws IOException {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** 得到第sheetNumber个sheet */
        Sheet sheet = wb.getSheetAt(sheetNumber-1);
        /** 得到Excel的行数 */
        int totalRows = sheet.getPhysicalNumberOfRows();

        /** 得到Excel的列数 */
        int totalCells = 0;
        if (totalRows >= startRow && sheet.getRow(startRow-1) != null) {
            totalCells = sheet.getRow(startRow-1).getPhysicalNumberOfCells();
        }

        Map<String,Object> map = new HashMap<>();
        List<List<String>> dataList = new ArrayList<List<String>>();
        /** 表头list */
        List<String> titleList = new ArrayList<>();
        /** 循环Excel的行 */
        for (Integer r = (startRow-1); r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null)
                continue;
            List<String> rowList = new ArrayList<String>();
            List<String> styleList = new ArrayList<String>();
            /** 循环Excel的列 */
            /** 第一行，是表头 */
            if(r.equals(startRow-1)){
                for (int c = (startCol-1); c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    String cellValue = "";
                    if (null != cell) {
                        HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
                        cellValue = hSSFDataFormatter.formatCellValue(cell);
                        rowList.add(cellValue);
                    }
                }
                map.put("title",rowList);

            }else{
                for (int c = (startCol-1); c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    String cellValue = "";
                    if (null != cell) {
                        HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
                        cellValue = hSSFDataFormatter.formatCellValue(cell);
                        // 以下是判断数据的类型
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC: // 数字
                                cellValue = cell.getNumericCellValue() + "";
                                break;
                            case Cell.CELL_TYPE_STRING: // 字符串
                                cellValue = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                                cellValue = cell.getBooleanCellValue() + "";
                                break;
                            case Cell.CELL_TYPE_FORMULA: // 公式
                                cellValue = cell.getCellFormula() + "";
                                break;
                            case Cell.CELL_TYPE_BLANK: // 空值
                                cellValue = "";
                                break;
                            case Cell.CELL_TYPE_ERROR: // 故障
                                cellValue = "非法字符";
                                break;
                            default:
                                cellValue = "未知类型";
                                break;
                        }
                    }
                    rowList.add(cellValue);
                }
                /** 保存第r行的第c列 */
                dataList.add(rowList);
            }
        }
        map.put("data",dataList);
        return map;
    }

    /**
     * 读取excel 表格一行的样式
     * @param startRow
     * @param startCol
     * @return
     */
    public static List<Object> readExcelStyle( Integer startRow,Integer startCol){
        Map<String,Object> map = new HashMap<>();
        List<Object> styleList = new ArrayList<>();
        //CellStyle cellStyle = new HSSFCellStyle();

        return styleList;
    }
}

