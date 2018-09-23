package com.artopcn.poiexcelpreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PoiExcelPreviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiExcelPreviewApplication.class, args);
    }
}
