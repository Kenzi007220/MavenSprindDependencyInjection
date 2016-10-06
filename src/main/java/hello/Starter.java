package hello;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;

public class Starter {

    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        //-------------------------------------------

        logger.info("Starting configuration ...");

        ApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
        logger.info(greetingService.sayGreeting());  // "Greeting, user!"
        System.out.println(greetingService.sayGreeting());

        logger.info("Finish configuration ...");

        //------------------------------------------ Using Profile

        logger.info("Starting runner configuration ...");

        AnnotationConfigApplicationContext ctxRunner = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        ctxRunner.getEnvironment().setActiveProfiles("runner");
        GreetingService greetingService2 = context.getBean(GreetingService.class);
        logger.info(greetingService2.sayGreeting());  // "Greeting, user!"
        System.out.println(greetingService2.sayGreeting());

        logger.info("Finish configuration ...");

        //------------------------------------------- Using Profile

        logger.info("Starting test configuration ...");

        AnnotationConfigApplicationContext ctxTest = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        ctxTest.getEnvironment().setActiveProfiles("testing");
        GreetingService greetingService3 = context.getBean(GreetingService.class);
        logger.info(greetingService3.sayGreeting());  // "Greeting, user!"
        System.out.println(greetingService3.sayGreeting());

        logger.info("Finish configuration ...");

        //-------------------------------------------Using PropertySource

        ApplicationContext ctxProperty = new GenericApplicationContext();
        Environment env = ctxProperty.getEnvironment();
        boolean containsFoo = env.containsProperty("foo");
        System.out.println("Does my environment contain the 'foo' property? " + containsFoo);

        //----------------------------------MessageSourse(Only using ApplicationContext)

        logger.info("Starting configuration MessageSourse");

        ApplicationContext contextMessageSourse = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        logger.info("Message: " + context.getMessage("message", null, Locale.getDefault()));
        logger.info("Argument.required: " + context.getMessage("argument.required", new Object[]{"Test_UK_Argument"}, Locale.UK));

    }
}