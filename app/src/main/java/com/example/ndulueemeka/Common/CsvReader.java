package com.example.ndulueemeka.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    InputStream inputStream;

    //CSV constructor
    public CsvReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    //method that returns List of String
    public List<String[]> readList(){
        List<String[]> resultList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null){
                String[] row = csvLine.split(",");
                resultList.add(row);
            }

        }catch (IOException e){
            throw  new RuntimeException("Error in reading CSV" + e);
        }
        return resultList;
    }
}
