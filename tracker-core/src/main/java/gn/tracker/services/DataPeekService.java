package gn.tracker.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@Service
public class DataPeekService {

    @Autowired
    private DataSendService dataSendService;

    @PostConstruct
    private void init() {
        dataSendService.callFromInit();
    }
}
