package com.itsjustnull.sensehat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsjustnull.sensehat.model.SenseHat;

@Repository
public interface SenseHatRepository extends JpaRepository<SenseHat, Integer> {

}
