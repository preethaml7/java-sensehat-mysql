package com.itsjustnull.sensehat.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.larsgrefer.sense_hat.SenseHat;

@Configuration
public class SenseHatConfig {

	@Bean
	public SenseHat senseHat() throws IOException {
		return new SenseHat();
	}
}
