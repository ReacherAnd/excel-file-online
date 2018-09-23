package com.artopcn.poiexcelpreview.core.service.impl;

import com.artopcn.poiexcelpreview.core.service.PreviewExcel;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @Auther: ranjingde
 * @Date: 2018/9/17 11:00
 */
@Service
public class PreviewServiceImpl implements PreviewExcel {


    @Override
    public String previewExcel(String sourPath) {
        return previewExcel(sourPath);
    }

    @Override
    public String previewEXcel(String sourPath, Boolean isWithStyle) {
        return previewEXcel(sourPath, isWithStyle);
    }

    @Override
    public String previewEXcel(InputStream inputStream) {
        return previewEXcel(inputStream);
    }

    @Override
    public String previewEXcel(InputStream inputStream, boolean isWithStyle) {
        return previewEXcel(inputStream,isWithStyle);
    }
}