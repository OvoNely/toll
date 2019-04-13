package gn;

import gn.services.SchedulingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulingContext {

    @Bean
    public SchedulingService schedulingService() {
        return new SchedulingService();
    }
}
