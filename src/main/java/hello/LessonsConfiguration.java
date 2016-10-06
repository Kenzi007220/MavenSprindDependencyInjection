package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan
public class LessonsConfiguration {
    @Bean
    @Profile("runner")
    @Autowired
    GreetingService greetingService() {
        System.out.println("Profile fo work");
        return new GreetingServiceImpl();
    }

    @Bean
    @Profile("testing")
    GreetingService greetingService2() {
        System.out.println("Profile fo test");
        return new GreetingServiceImpl();
    }

    //----------------------------------MessageSourse(Only using ApplicationContext)
    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}

