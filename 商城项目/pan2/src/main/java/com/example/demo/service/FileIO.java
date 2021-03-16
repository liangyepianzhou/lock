package com.example.demo.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileIO {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    String outputUrl;
    String inputUrl;

    public FileIO(String outputUrl, String inputUrl) {
        this.outputUrl = outputUrl;
        this.inputUrl = inputUrl;
        try {
            fileInputStream=new FileInputStream(inputUrl);
            fileOutputStream=new FileOutputStream(outputUrl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void load(){

    }
    public  void upload(){

    }
}
