package com.infinity.service;

import java.util.List;

import com.infinity.model.Ride;

public interface RideService {

	void addRide(Ride ride);

	void deleteRide(Ride ride);

	void updateRide(Ride ride);

	List<Ride> selectRide(Ride ride);
}
