package com.artopcn.poiexcelpreview.core.service;

import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @Auther: ranjingde
 * @Date: 2018/9/17 10:58
 */
@Component
public interface PreviewExcel {

     String previewExcel(String sourPath);

     String previewEXcel(String sourPath,Boolean isWithStyle);

     String previewEXcel(InputStream inputStream);

     String previewEXcel(InputStream inputStream,boolean isWithStyle);



}
