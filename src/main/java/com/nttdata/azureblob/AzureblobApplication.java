package com.nttdata.azureblob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AzureblobApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureblobApplication.class, args);
	}

}
