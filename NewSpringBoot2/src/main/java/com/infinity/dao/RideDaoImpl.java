package com.infinity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infinity.mapper.RideMapper;
import com.infinity.model.Ride;


@Repository("rideDao")
public class RideDaoImpl implements RideDao {
	
	@Autowired
	RideMapper rideMapper;
	
	@Override
	public List<Ride> selectRide(Ride ride) {
		List<Ride> rides = rideMapper.selectRide(ride);	
		return rides;
	}
	
	@Override
	public void addRide(Ride ride) {
		rideMapper.addRide(ride);
	}
	
	public void deleteRide(Ride ride) {
		rideMapper.deleteRide(ride);
	}
	
	public void updateRide(Ride ride) {
		rideMapper.updateRide(ride);
	}
}
