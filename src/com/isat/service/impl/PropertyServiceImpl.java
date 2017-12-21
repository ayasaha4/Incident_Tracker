package com.isat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.isat.service.PropertyService;

@Service("PropertyService")
public class PropertyServiceImpl implements PropertyService{

	
	@Autowired
    private Environment environment;
	
	@Override
	public String readValues(String propertyKey) {
		return environment.getProperty(propertyKey);
		
	}

}
