package com.artopcn.poiexcelpreview.core.service;

import com.artopcn.poiexcelpreview.common.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.artopcn.poiexcelpreview.common.ExcelReader.readExcel;
import static com.artopcn.poiexcelpreview.common.POIReadExcel.excelWriteToHtml;

/**
 * @Auther: ranjingde
 * @Date: 2018/9/17 11:25
 */
public class TestExcel {

//    public static void main(String[] args){
//        try {
//          /*  InputStream inputStream = new FileInputStream("F:\\test-preview\\test-eswp.xlsx");
//            Map<String,Object> map = new HashMap<>();
//            map = readExcel(inputStream,1,1,1);
//            for(Map.Entry<String,Object> entry:map.entrySet()){
//                System.out.println(entry.getKey()+"--->"+entry.getValue());
//            }*/
//          //  String[] excelWriteToHtml = excelWriteToHtml("F:\\test-preview\\sheet-test.xlsx");
////            List<Map<String, String>> list = excelWriteToHtml("F:\\test-preview\\sheet-test.xlsx");
////            for(int i = 0; i < list.size();i++ ){
////                Map<String,String> map = list.get(i);
////                for (Map.Entry<String,String> entry: map.entrySet()) {
////                    System.out.println(entry.getKey()+"--->"+entry.getValue());
////                }
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////       }
//
//    }

}