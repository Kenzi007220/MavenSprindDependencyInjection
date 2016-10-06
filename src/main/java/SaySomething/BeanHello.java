package SaySomething;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanHello {
    @Bean
    SayInt sayInt(){
        return new Say(toString());
    }
}
