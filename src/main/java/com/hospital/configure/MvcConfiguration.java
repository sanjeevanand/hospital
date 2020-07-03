package com.hospital.configure;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    	registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
        .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

      registry.addResourceHandler("/jsp/admin/js/**").addResourceLocations("/WEB-INF/jsp/admin/js/")
       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
       
		  registry.addResourceHandler("/jsp/admin/css/**").addResourceLocations("/WEB-INF/jsp/admin/css/")
       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    
		registry.addResourceHandler("/jsp/admin/images/**").addResourceLocations("/WEB-INF/jsp/admin/images/")
       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

		//for doctor
		 registry.addResourceHandler("/jsp/doctor/js/**").addResourceLocations("/WEB-INF/jsp/doctor/js/")
	       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	       
			  registry.addResourceHandler("/jsp/doctor/css/**").addResourceLocations("/WEB-INF/jsp/doctor/css/")
	       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	    
			registry.addResourceHandler("/jsp/doctor/images/**").addResourceLocations("/WEB-INF/jsp/doctor/images/")
	       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

		//
			 registry.addResourceHandler("/jsp/patient/js/**").addResourceLocations("/WEB-INF/jsp/patient/js/")
		       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		       
				  registry.addResourceHandler("/jsp/patient/css/**").addResourceLocations("/WEB-INF/jsp/patient/css/")
		       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		    
				registry.addResourceHandler("/jsp/patient/images/**").addResourceLocations("/WEB-INF/jsp/patient/images/")
		       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

    }
}