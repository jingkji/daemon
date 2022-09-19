package com.kiseki.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class KisekiDaemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(KisekiDaemonApplication.class, args);
	}

}
