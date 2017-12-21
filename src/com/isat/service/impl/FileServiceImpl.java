package com.isat.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.isat.service.FileService;
 
@Service("fileService")
public class FileServiceImpl implements FileService {
 
 
    @Autowired
    private Environment environment;
 
    public void readValues() {
        System.out.println("---------------------------------    Getting property via Spring Environment :"
                + environment.getProperty("error"));
    }
    
    public String readValues(String propertyKey) {
        System.out.println("---------------------------------    Getting property via Spring Environment :"
                + environment.getProperty(propertyKey));
        return environment.getProperty(propertyKey);
    }
 
}