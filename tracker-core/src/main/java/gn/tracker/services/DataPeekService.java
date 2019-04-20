package gn.tracker.services;

import gn.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


@Service
public class DataPeekService {

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);
//    static int count;

//    @Autowired
//    private DataSendService dataSendService;

//    @PostConstruct
//    private void init() {
//        dataSendService.callFromInit();
//    }

    private BlockingDeque<Point> queue = new LinkedBlockingDeque<>(100);


    ArrayList<Point> take () throws InterruptedException {
//        log.info("DataPeekService.take " + queue.take());
        ArrayList<Point> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.take());
        }

        return list;
    }

    void put(Point point) throws InterruptedException {
        queue.put(point);
    }


}
