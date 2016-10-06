package SaySomething;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(BeanHello.class);
        Say hello = context.getBean(Say.class);
        System.out.println(hello.saySomething("My name is Sasha"));
        logger.info(hello.saySomething("ssd"));
        
    }
}
