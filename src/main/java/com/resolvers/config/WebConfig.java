package com.resolvers.config;

import com.resolvers.resolvers.CustomArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @PostConstruct
    public void prioritizeCustomArgumentMethodHandlers () {
        List<HandlerMethodArgumentResolver> argumentResolvers =
                new ArrayList<>(adapter.getArgumentResolvers ());
        List<HandlerMethodArgumentResolver> customResolvers =
                adapter.getCustomArgumentResolvers ();
        argumentResolvers.removeAll (customResolvers);
        argumentResolvers.addAll (0, customResolvers);
        adapter.setArgumentResolvers (argumentResolvers);
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomArgumentResolver());
    }


}
