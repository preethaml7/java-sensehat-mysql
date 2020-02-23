package com.itsjustnull.sensehat.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensehat")
public class SenseHat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	private Double temperature;
	private Double humidity;
	private Double pressure;
	private Timestamp collection_date;
	private Double sensehat_responsetime;

	public SenseHat() {
	}

	public SenseHat(Integer id, Double temperature, Double humidity, Double pressure, Timestamp collection_date,
			Double sensehat_responsetime) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.collection_date = collection_date;
		this.sensehat_responsetime = sensehat_responsetime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Timestamp getCollection_date() {
		return collection_date;
	}

	public void setCollection_date(Timestamp collection_date) {
		this.collection_date = collection_date;
	}

	public Double getSensehat_responsetime() {
		return sensehat_responsetime;
	}

	public void setSensehat_responsetime(Double sensehat_responsetime) {
		this.sensehat_responsetime = sensehat_responsetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collection_date == null) ? 0 : collection_date.hashCode());
		result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pressure == null) ? 0 : pressure.hashCode());
		result = prime * result + ((sensehat_responsetime == null) ? 0 : sensehat_responsetime.hashCode());
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SenseHat other = (SenseHat) obj;
		if (collection_date == null) {
			if (other.collection_date != null)
				return false;
		} else if (!collection_date.equals(other.collection_date))
			return false;
		if (humidity == null) {
			if (other.humidity != null)
				return false;
		} else if (!humidity.equals(other.humidity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pressure == null) {
			if (other.pressure != null)
				return false;
		} else if (!pressure.equals(other.pressure))
			return false;
		if (sensehat_responsetime == null) {
			if (other.sensehat_responsetime != null)
				return false;
		} else if (!sensehat_responsetime.equals(other.sensehat_responsetime))
			return false;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SenseHat [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + ", pressure="
				+ pressure + ", collection_date=" + collection_date + ", sensehat_responsetime=" + sensehat_responsetime
				+ "]";
	}
}