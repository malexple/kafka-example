package ru.mcs.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mcs.model.Data;
import ru.mcs.model.test.DataTestOptions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessages(DataTestOptions testOptions) {
        if (testOptions.getMeasurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Data data = new Data();
                        data.setSensorId((long) getRandomNumber(1, 0));
                        data.setMeasurement(getRandomNumber(15, 100));
                        data.setMeasurementType(getRandomMeasurementType(testOptions.getMeasurementTypes()));
                    },
                    0,
                    testOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS);
        }
    }

    private Data.MeasurementType getRandomMeasurementType(Data.MeasurementType[] measurementTypes) {
        int randomTypeId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomTypeId];
    }

    private double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }
}
