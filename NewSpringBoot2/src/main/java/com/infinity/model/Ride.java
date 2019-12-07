package com.infinity.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Ride {
	public Integer id;
	@NotNull(message = "Name can't be null")
	@Size(min = 3, max = 10, message = "About Me must be between 3 and 10 characters")
	@Email
	public String name;
	@NotNull(message = "Duration can't be null")
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
