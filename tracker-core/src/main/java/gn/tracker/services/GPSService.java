package gn.tracker.services;

import gn.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GPSService {

    @Autowired
    private DataPeekService peekService;

    @Scheduled(cron = "${cron.prop}")
    private void coordinatesGeneration() throws InterruptedException {
        Point point = new Point();
        Random random = new Random(System.currentTimeMillis());
        point.setLat(random.nextDouble() * 100);
        point.setLon(random.nextDouble() * 100);
        point.setAzimuth(random.nextDouble() * 100);
        point.setInstantSpeed(random.nextDouble() * 100);
        point.setTime(System.currentTimeMillis());

//        String s = "tick" + DataPeekService.count++;
        peekService.put(point);

    }

}
