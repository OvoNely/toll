package gn.tracker;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import gn.dto.Point;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String... args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);
    }

}
