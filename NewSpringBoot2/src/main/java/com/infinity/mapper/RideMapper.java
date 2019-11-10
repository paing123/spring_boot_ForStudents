package com.infinity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.infinity.model.Ride;

@Mapper
public interface RideMapper {
	public void addRide(@Param("ride") Ride ride);
	
	public void updateRide(@Param("ride") Ride ride);
	
	public void deleteRide(@Param("ride") Ride ride);
	
	public List<Ride> selectRide(@Param("ride") Ride ride);
}
