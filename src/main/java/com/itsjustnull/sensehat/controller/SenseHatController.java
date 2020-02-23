package com.itsjustnull.sensehat.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itsjustnull.sensehat.config.SenseHatConfig;
import com.itsjustnull.sensehat.model.SenseHat;
import com.itsjustnull.sensehat.service.SenseHatService;
import com.itsjustnull.sensehat.util.SenseHatUtil;

/**
 * 	  @Author Preetham Lokesh
 * 
 *    1) HTTP GET - http://localhost:8080/collect --> Collects SenseHat Data And Stores into MySql 
 *    2) HTTP GET - http://localhost:8080/sensehat --> Displays SenseHat data from MySql as JSON
 *    
 */
@RestController
public class SenseHatController {

	private Instant startSenseHatRequest;
	private Instant stopSenseHatRequest;
	private long senseHatResponseTime;

	Iterable<SenseHat> senseHatFromMySql;
	SenseHat senseHat = new SenseHat();
	SenseHatUtil senseHatUtil = new SenseHatUtil();

	@Autowired
	SenseHatConfig senseHatConfig;

	@Autowired
	SenseHatService senseHatService;

	private static final Logger logger = LoggerFactory.getLogger(SenseHatController.class);

	@RequestMapping(path = "/collect", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public String getDataFromSenseHat() {

		final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Sense Hat Data Collection Started...");

					saveSenseHatStatsIntoMySql(getOrDisplaySenseHatStats());

					System.out.println("Sense Hat Data Collection Completed...");
					System.out.println("Active Thread Count: " + java.lang.Thread.activeCount());

				} catch (Exception e) {
					logger.error("Exception:- " + "Message: " + e.getMessage() + " StackTrace: "
							+ senseHatUtil.printStackTrace(e));
				}
			}

		}, 0, 1, TimeUnit.SECONDS);

		return "Success";
	}

	@RequestMapping(path = "/sensehat", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public Iterable<SenseHat> fetchSenseHatStatsFromMySql() {

		final ExecutorService executorService = Executors.newFixedThreadPool(5);

		executorService.execute(new Runnable() {

			public void run() {
				try {

					Instant startSenseHatMySqlRequest = Instant.now();

					senseHatFromMySql = senseHatService.findAll();

					Instant stopSenseHatMySqlRequest = Instant.now();
					long senseHatFetchFromMySqlResponseTime = Duration
							.between(startSenseHatMySqlRequest, stopSenseHatMySqlRequest).toMillis();

					System.out.println("Sense Hat Stats Fetched From... MySQL Response Time: "
							+ senseHatFetchFromMySqlResponseTime + "ms");

				} catch (Exception e) {

					logger.error("Exception:- " + "Message: " + e.getMessage() + " StackTrace: "
							+ senseHatUtil.printStackTrace(e));
				}
			}
		});

		return senseHatFromMySql;
	}

	public SenseHat getOrDisplaySenseHatStats() throws IOException {

		startSenseHatRequest = Instant.now();

		// System.out.println("\n \n");

		Double temperature = senseHatConfig.senseHat().getTemperature();
		// System.out.println("Temperature: " + temperature);

		Double humidity = senseHatConfig.senseHat().getHumidity();
		// System.out.println("Humidity: " + humidity);

		Double pressure = senseHatConfig.senseHat().getPressure();
		// System.out.println("Pressure: " + pressure);

		// System.out.println("\n \n");

		stopSenseHatRequest = Instant.now();
		senseHatResponseTime = Duration.between(startSenseHatRequest, stopSenseHatRequest).toMillis();

		senseHat.setHumidity(humidity);
		senseHat.setPressure(pressure);
		senseHat.setTemperature(temperature);
		senseHat.setCollection_date(senseHatUtil.currentTimeStamp());
		senseHat.setSensehat_responsetime((double) senseHatResponseTime);

		return senseHat;

	}

	public void saveSenseHatStatsIntoMySql(SenseHat senseHat) {

		senseHatService.saveAndFlush(senseHat);

	}
}
