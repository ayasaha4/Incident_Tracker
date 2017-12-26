package com.isat.common;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

 
@Configuration
@PropertySources({
    //@PropertySource("/resources/properties/jdbc.properties"),
    @PropertySource("/resources/properties/dashboard.properties")
})

public class AppConfig {}