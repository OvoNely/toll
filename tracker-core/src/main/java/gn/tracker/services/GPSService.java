package gn.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GPSService {

    @Autowired
    private DataPeekService peekService;

    @Scheduled(cron = "${cron.prop}")
    private void coordinatesGeneration() throws InterruptedException {
        String s = "tick" + DataPeekService.count++;
        peekService.put(s);

    }

}
