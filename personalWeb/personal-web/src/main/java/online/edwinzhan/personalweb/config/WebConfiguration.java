package online.edwinzhan.personalweb.config;

import jakarta.annotation.Resource;
import online.edwinzhan.personalweb.interceptor.AuthorizeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Resource
    AuthorizeInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry
                .addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/auth/**")
                .excludePathPatterns("/api/image/**")
                .excludePathPatterns("/upload-image")
                .excludePathPatterns("/api/songs/**");
    }
}
