package com.gl.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration   // tells Spring this is a config class
@ComponentScan("com.gl.spring") // scans package for components
public class Container {

    // method name becomes the bean id: "getCounter"
    @Bean
    @Scope("singleton")   // default is singleton, so optional
    public Counter getCounter() {
        return new Counter();
    }
}
