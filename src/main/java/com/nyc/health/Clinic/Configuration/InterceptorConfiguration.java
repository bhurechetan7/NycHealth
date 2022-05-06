package com.nyc.health.Clinic.Configuration;

import com.nyc.health.Clinic.Interceptor.BasicAuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(new BasicAuthenticationInterceptor());
    }
}
