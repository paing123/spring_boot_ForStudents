package com.infinity.dao;

import java.util.List;

import com.infinity.model.Ride;

public interface RideDao {

	void addRide(Ride ride);

	void deleteRide(Ride ride);

	void updateRide(Ride ride);

	List<Ride> selectRide(Ride ride);
}
