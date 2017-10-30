package com.camaleao.starter.server.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	  @Override
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class[]{ WebMvcConfiguration.class };
	  }

	  @Override
	  protected Class<?>[] getServletConfigClasses() {
	    return new Class[]{  WebMvcConfiguration.class };
	  }

	  @Override
	  protected String[] getServletMappings() {
	    return new String[]{ "/" };
	  }
}