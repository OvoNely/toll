package gn.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class SchedulingService {
    @Scheduled (fixedDelay = 3000)
    private void tick() {
        System.out.println("ScheduledService.tick");
    }
}
