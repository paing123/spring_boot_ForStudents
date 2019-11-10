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
	
	public List<Ride> selectRide(){
		return rideDao.selectRide();
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
	
	public Ride selectRideByID(Ride r) {
		return rideDao.selectRideByID(r);
	}
	
	public List<Ride> selectRideByName(Ride r){
		return rideDao.selectRideByName(r);
	}
	
	public List<Ride> selectRideByDuration(Ride r){
		return rideDao.selectRideByDuration(r);
	}
	
	public List<Ride> selectRideByNameDuration(Ride r){
		return rideDao.selectRideByNameDuration(r);
	}
}
