package com.veselov.alex.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        DispatcherServlet dispatcher = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcher);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}