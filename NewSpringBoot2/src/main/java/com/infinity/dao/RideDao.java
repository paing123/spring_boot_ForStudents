package com.infinity.dao;

import java.util.List;

import com.infinity.model.Ride;

public interface RideDao {

	List<Ride> selectRide();

	void addRide(Ride ride);

	void deleteRide(Ride ride);

	void updateRide(Ride ride);

	Ride selectRideByID(Ride r);

	List<Ride> selectRideByName(Ride r);

	List<Ride> selectRideByDuration(Ride r);
	
	List<Ride> selectRideByNameDuration(Ride r);
}
