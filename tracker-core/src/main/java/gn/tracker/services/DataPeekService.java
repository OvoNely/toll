package gn.tracker.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DataPeekService {

    @Autowired
    private DataSendService dataSendService;
}
