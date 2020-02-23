package com.itsjustnull.sensehat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsjustnull.sensehat.model.SenseHat;
import com.itsjustnull.sensehat.repository.SenseHatRepository;

@Service
public class SenseHatService {

	@Autowired
	SenseHatRepository senseHatRepository;

	public Iterable<SenseHat> findAll() {

		return senseHatRepository.findAll();
	}

	public void saveAndFlush(SenseHat senseHat) {
		senseHatRepository.saveAndFlush(senseHat);
	}
}
