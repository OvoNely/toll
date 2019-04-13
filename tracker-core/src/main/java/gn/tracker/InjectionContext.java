package gn.tracker;

import org.springframework.context.annotation.Configuration;
import gn.tracker.services.DataPeekService;
import gn.tracker.services.DataSendService;
import org.springframework.context.annotation.Bean;

@Configuration
public class InjectionContext {

    @Bean
    public DataPeekService peekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }
}
