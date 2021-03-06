package hms.session.gc.service;

import hms.session.gc.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashMap;

@Service
@EnableScheduling
public class HashMapService {


    private final static Logger logger = LoggerFactory.getLogger(HashMapService.class);


    private HashMap<String, Student> hashMap = new HashMap<>();

    public void addHashMap(BigInteger hashMapLength) {
        logger.info("Hash Map Size before adding [{}]", hashMap.size());
        for (int x = 0; x < hashMapLength.longValue(); x++) {
            String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
            hashMap.put(String.format("data%d%s", x, timeStamp),
                    new Student(Integer.toString(x), Integer.toString(x), x));
        }
        logger.info("Hash Map Size after adding [{}]", hashMap.size());
    }

    public void clearHashMap() {
        logger.info("Hash Map Size before removing [{}]", hashMap.size());
        hashMap.clear();
        logger.info("Hash Map Size after removing [{}]", hashMap.size());
    }

    @Scheduled(cron = "${system.schedule.hash-map-size}")
    public void printHashMapSize() {
        logger.info("HashMap CurrentStatus: NoOfEntries[{}]", hashMap.size());
    }
}

