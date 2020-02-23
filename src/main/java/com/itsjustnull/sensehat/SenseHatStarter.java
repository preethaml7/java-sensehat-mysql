package com.itsjustnull.sensehat;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.itsjustnull.sensehat.model")
@ComponentScan(basePackages = "com.itsjustnull.sensehat")
@SpringBootApplication
public class SenseHatStarter {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SenseHatStarter.class, args);
	}
}
