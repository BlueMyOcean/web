package com.jinjiang.web.back.conf;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;


/**
 * Created by Administrator on 2016/9/6 0006.
 * 实现Spring WebApllicationInitializer接口 来注册servlet
 */
public class ServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
       // Dynamic testServlet = servletContext.addServlet("name",Servlet.class) 注册servlet
        //testServlet.addMapping("/custom/**")  映射Servlet
        //同时也可以注册filter  但是abstratanno----已经实现了一个方法getServletFilters()
    }
}
