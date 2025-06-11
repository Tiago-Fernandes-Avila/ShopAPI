package dev.Practice.DeliverySystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {


    @Bean
    public WebMvcConfigurer CorsConfiguration(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT","DELETE")
                .allowedHeaders("*"); 
                //permite todas as rotas ou seja os endpoints do back, permite as requests do meu front, metdos permitidos 

                //tambem podemos configurar de maneira potual na propria rota com um 
                //@CrossOrigin(origins = "http://localhost:5173")
            }
        };

    }
}
