package gn.tracker.services;

import gn.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


@Service
public class DataPeekService {

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);
//    static int count;

    @Autowired
    private DataSendService dataSendService;

    @PostConstruct
    private void init() {
        dataSendService.callFromInit();
    }

    private BlockingDeque<Point> queue = new LinkedBlockingDeque<>(100);

    @Scheduled(fixedRate = 500)
    void take () throws InterruptedException {
        log.info("DataPeekService.take " + queue.take());
    }

    void put(Point point) throws InterruptedException {
        queue.put(point);
    }


}
