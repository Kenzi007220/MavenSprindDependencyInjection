package hello;

import org.springframework.context.annotation.Bean;

public class LessonsConfiguration {
    @Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}