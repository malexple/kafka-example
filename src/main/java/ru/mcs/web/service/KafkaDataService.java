package ru.mcs.web.service;

import ru.mcs.model.Data;


public interface KafkaDataService {
    void send(Data data);
}
