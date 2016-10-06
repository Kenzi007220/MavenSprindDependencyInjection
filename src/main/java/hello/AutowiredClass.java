package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Map;

public class AutowiredClass {

    @Autowired //к полям класса
    @Qualifier("main")
    //@Autowired(required = false) //чтобы не бросалось исключение,
    //если не с кем связать
    //рекомендуется использовать @Required
    private GreetingService greetingService;

    @Autowired //for fields massive or collections
    private GreetingService[] services;

    @Autowired //for Map, where keys is Bean's names, value - beans
    private Map<String, GreetingService> serviceMap;

    @Autowired //for constructor
    public AutowiredClass(@Qualifier("main") GreetingService service) {}

    @Autowired //for methods
    public void prepare(GreetingService prepareContext){/* some action... */}

    @Autowired //for setters
    public void setContext(GreetingService service) { this.greetingService = service; }

    @Resource //default searching bean with name "context"
    private ApplicationContext context;

    @Resource(name="greetingService") //Searching bean with name "greetingService"
    public void setGreetingService(GreetingService service) {
        this.greetingService = service;
    }
}