package com.nasrobot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@Slf4j
public class NasRobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasRobotApplication.class, args);
		log.info("[System] Nas Robot 启动成功");
	}

}
