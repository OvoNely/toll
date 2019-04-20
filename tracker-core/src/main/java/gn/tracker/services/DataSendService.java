package gn.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import gn.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataSendService {
//    public void callFromInit() {
//        System.out.println("DataSendService.callFromInit say \"Hello!\"");
//    }

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    @Autowired
    private DataPeekService peekService;

    @Scheduled(cron = "${cronMin.prop}")
    private void send () throws InterruptedException, JsonProcessingException {
        for (Point point :
                peekService.take()) {
            log.info(point.toJson());
        }
    }

}
