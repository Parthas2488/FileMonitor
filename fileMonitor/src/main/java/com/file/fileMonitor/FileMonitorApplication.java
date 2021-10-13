package com.file.fileMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileMonitorApplication {
	public static String HONE_DIR_PATH ;

	public static void main(String[] args) {
		HONE_DIR_PATH = args[0];
		SpringApplication.run(FileMonitorApplication.class, args);
	}
}
