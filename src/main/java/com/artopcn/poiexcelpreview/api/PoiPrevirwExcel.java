package com.artopcn.poiexcelpreview.api;

import com.artopcn.poiexcelpreview.core.service.impl.PreviewServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.artopcn.poiexcelpreview.common.POIReadExcel.excelWriteToHtml;

/**
 * @Auther: ranjingde
 * @Date: 2018/9/17 10:56
 */
@Controller
public class PoiPrevirwExcel {
    @Resource
    private PreviewServiceImpl previewService;

   // private Map<String,String> map;

   /* @RequestMapping(value = "/preview",method = RequestMethod.GET)
    public String preview(Model model){
        String[] excelWriteToHtml = excelWriteToHtml("F:\\test-preview\\sheet-test.xlsx");
            model.addAttribute("sheet1",excelWriteToHtml[0]);
            model.addAttribute("sheet2",excelWriteToHtml[1]);
            model.addAttribute("sheet3",excelWriteToHtml[2]);
        for (String string:excelWriteToHtml) {
            System.out.println(string);
        }
        return "/excelPreview.html";
    }*/

  /*  @RequestMapping(value = "/preview1",method = RequestMethod.GET)
    public String preview1(Model model){

        String[] excelWriteToHtml = excelWriteToHtml("F:\\test-preview\\sheet-test.xlsx");
        for(int sheetNum = 0;sheetNum < excelWriteToHtml.length;sheetNum++){
            if(excelWriteToHtml[sheetNum] != null){
                model.addAttribute("sheetNum"+sheetNum,sheetNum);
                model.addAttribute("sheetName"+sheetNum,"sheetName"+sheetNum);
            }
        }
        model.addAttribute("sheet1",excelWriteToHtml[0]);
        model.addAttribute("sheet2",excelWriteToHtml[1]);
        model.addAttribute("sheet3",excelWriteToHtml[2]);
        model.addAttribute("sheet4",excelWriteToHtml[3]);
        model.addAttribute("sheet5",excelWriteToHtml[4]);
        for (String string:excelWriteToHtml) {
            System.out.println(string);
        }
        return "/preview.html";
    }
*/


 /*   @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Model model){
        List<Map<String, String>> list = excelWriteToHtml("F:\\test-preview\\test-eswp.xlsx");
        for(int i = 0; i < list.size();i++ ){
            Map<String,String> map = list.get(i);
            for (Map.Entry<String,String> entry: map.entrySet()) {
                System.out.println(entry.getKey()+"--->"+entry.getValue());
                model.addAttribute("sheetName"+i,entry.getKey());
                model.addAttribute("tableValue"+i,entry.getValue());
            }
        }

        return "/preview.html";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1(Model model){
        List<Map<String, String>> list = excelWriteToHtml("F:\\test-preview\\test1.xlsx");
        System.out.println(list.size()+"==========");
        model.addAttribute("list",list);
        list.clear();//清除list缓存
        System.out.println(list.size()+"==========");
        return "/test.html";
    }*/



    @RequestMapping(value = "/freemaker",method = RequestMethod.GET)
    public String testFreeMaker(HttpServletRequest request){

        Map<String,String> map = excelWriteToHtml("F:\\test-preview\\test1.xlsx");
        request.setAttribute("map",map);
        return "index";
    }
    @RequestMapping(value = "/freemaker1",method = RequestMethod.GET)
    public String testFreeMaker1(HttpServletRequest request){
        Map<String, String>   map = excelWriteToHtml("F:\\test-preview\\test1.xlsx");
        request.setAttribute("map",map);
        return "index1";
    }
    @RequestMapping(value = "/freemaker2",method = RequestMethod.GET)
    public String testFreeMaker2(HttpServletRequest request){
        Map<String, String>   map = excelWriteToHtml("F:\\test-preview\\test1.xlsx");
        request.setAttribute("map",map);
        return "test";
    }
 @RequestMapping(value = "/freemaker3",method = RequestMethod.GET)
    public String testFreeMaker3(HttpServletRequest request){
        Map<String, String>   map = excelWriteToHtml("F:\\test-preview\\ESWP.xlsx");
        request.setAttribute("map",map);
        return "index2";
    }


}