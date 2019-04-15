package gn.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

public class ScheduledQueueService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledQueueService.class);

    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled (fixedRate = 2000)
    void take() throws InterruptedException {
        log.info("take trying!!!");
        long current = System.currentTimeMillis();
        log.info((current - previous) + " ScheduledQueueService.take " + queue.take());
        previous = current;

    }

    @Scheduled (fixedDelay = 3_000)
    void put() throws InterruptedException {
        int i = putCount++;
        log.info("ScheduledQueueService.put " + i);
        queue.put("new string => " + i);

    }
}
