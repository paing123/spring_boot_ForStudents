package com.infinity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.dao.RideDao;
import com.infinity.model.Ride;

@Service("rideService")
public class RideServiceImpl implements RideService{
	
	@Autowired
	RideDao rideDao;
	
	public List<Ride> selectRide(Ride ride){
		return rideDao.selectRide(ride);
	}
	
	public void addRide(Ride ride) {
		rideDao.addRide(ride);
	}

	public void deleteRide(Ride ride) {
		rideDao.deleteRide(ride);	
	}
	
	public void updateRide(Ride ride) {
		rideDao.updateRide(ride);
	}
}
