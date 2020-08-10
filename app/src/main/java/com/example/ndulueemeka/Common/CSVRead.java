package com.example.ndulueemeka.Common;

import com.example.ndulueemeka.Model.CarOwnerModel;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVRead {
    public List<CarOwnerModel> readCsvFile() throws FileNotFoundException {
        FileReader reader =  new FileReader("C:\\Users\\Lenovo\\Desktop\\ehealth\\car_ownsers_data.csv");
        CsvToBean<CarOwnerModel> csvtobean= new CsvToBeanBuilder<CarOwnerModel>(reader)
                .withType(CarOwnerModel.class)
                .withSeparator(',')
                .build();

        return csvtobean.parse();
    }
}
