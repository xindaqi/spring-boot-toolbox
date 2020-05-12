package com.company.web;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.company.web.mapper")
@EnableSwagger2 
@EnableCaching 
public class InitiApplication extends SpringBootServletInitializer{
    private static Logger logger = LoggerFactory.getLogger(InitiApplication.class);
    @Override 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(InitiApplication.class);
    }

    // @Bean 
    // public TomcatServletWebServerFactory servletContainer(){
    //     TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
    //         @Override 
    //         protected void postProcessContext(Context context){
    //             // Forcing use https or cannot get infos by http
    //             // SecurityConstraint constraint = new SecurityConstraint();
    //             // constraint.setUserConstraint("CONFIDENTIAL");
    //             // SecurityCollection collection = new SecurityCollection();
    //             // collection.addPattern("/*");
    //             // constraint.addCollection(collection);
    //             // context.addConstraint(constraint);
    //         }
    //     };
    //     tomcat.addAdditionalTomcatConnectors(httpConnector());
    //     return tomcat;
    // }

    // @Bean 
    // public Connector httpConnector(){
    //     Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    //     connector.setScheme("http");
    //     connector.setPort(18810);
    //     connector.setSecure(false);
    //     connector.setRedirectPort(18820);
    //     return connector;
    // }

    public static void main(String[] args){
        SpringApplication.run(InitiApplication.class, args);
        logger.info("web服务启动");
    }
}