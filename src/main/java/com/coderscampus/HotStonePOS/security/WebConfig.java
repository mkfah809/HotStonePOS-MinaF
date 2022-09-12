package com.coderscampus.HotStonePOS.security;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
//@Configuration
//public class WebConfig implements WebMvcConfigurer{
//	
//	 @Override
//	    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//	        // add converter suport Content-Type: 'application/x-www-form-urlencoded'
//	        converters.stream()
//	                .filter(AllEncompassingFormHttpMessageConverter.class::isInstance)
//	                .map(AllEncompassingFormHttpMessageConverter.class::cast)
//	                .findFirst()
//	                .ifPresent(converter -> converter.addSupportedMediaTypes(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
//	    }
//}
