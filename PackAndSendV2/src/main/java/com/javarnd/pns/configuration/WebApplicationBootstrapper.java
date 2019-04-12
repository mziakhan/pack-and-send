/*
 * This class represent the traditional web.xml
 * Here we need to configure the
 * ServletContext
 * ContextLoaderListener
 */
package com.javarnd.pns.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Ossu
 */
@PropertySource({"classpath:../dbconfig.properties"})
public class WebApplicationBootstrapper implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
    	/* We need to register the Spring Configuration and
    	 * DispatcherServlet configuration in web application context
    	 * To do so, AnnotationConfigWebApplicationContext comes into the picture
    	 * having method called register() and setServletContext()
    	 * 
    	 * DispatcherServlet however needs to be registered
    	 * */
    	
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();

        applicationContext.register(SpringBeanContainer.class);
        dispatcherContext.register(DispatcherServletConfiguration.class);
        applicationContext.setServletContext(sc);

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(applicationContext);
        sc.addListener(contextLoaderListener);
        sc.setInitParameter("applicationName","Pack'N Send");
        //DispatcherServlet Registration
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = sc.addServlet("dispatcher", dispatcherServlet);

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    @Autowired
    Environment env;
}
