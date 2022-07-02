package com.datamart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.datamart.entity")
public class DengueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DengueServiceApplication.class, args);
	}

}
