package com.infinity.model;

public class Ride {
	public Integer id;
	public String name;
	public String duration;
	public String rideType;
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRideType() {
		return rideType;
	}

	public void setRideType(String rideType) {
		this.rideType = rideType;
	}
}
