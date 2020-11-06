/*
 * (C) Copyright 2008-2020 hSenid Software International (Pvt) Limited.
 *
 * All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Software International (Pvt) Limited.
 *
 * hSenid Software International (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 */

package hms.session.gc.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages = {"hms.session.gc"})
@EnableScheduling
@SpringBootApplication
public class ApiStarter {

    private static final String APP_NAME = "GC";

    private final static Logger logger = LoggerFactory.getLogger(ApiStarter.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiStarter.class, args);
    }

    @PostConstruct
    public void start() {
        try {
            logger.info("Initializing " + APP_NAME);
            logger.info("===============================================================");
            logger.info("========== Java Session : " + APP_NAME + " Started =========");
            logger.info("===============================================================");
        } catch (Throwable e) {
            logger.error("Error occurred while initializing the " + APP_NAME + " {}", e);
        }
    }

    @PreDestroy
    public void shutDown() {
        try {
            logger.info("===============================================================");
            logger.info("==================== Stopping " + APP_NAME + " ======================");
            logger.info("===============================================================");
        } catch (Exception e) {
            logger.error("Error occurred while stopping the " + APP_NAME);
        }
    }
}
