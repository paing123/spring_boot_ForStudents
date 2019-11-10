package com.infinity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.infinity.model.Ride;

@Mapper
public interface RideMapper {
	public void addRide(@Param("ride") Ride ride);
}
