package com.infinity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infinity.mapper.RideMapper;
import com.infinity.model.Ride;


@Repository("rideDao")
public class RideDaoImpl implements RideDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RideMapper rideMapper;
	
	@Override
	public List<Ride> selectRide() {
		List<Ride> ride = jdbcTemplate.query("select * from ride",new RideRowMapper());	
		return ride;
	}
	
	@Override
	public void addRide(Ride ride) {
		rideMapper.addRide(ride);
	}
	
	public void deleteRide(Ride ride) {
		jdbcTemplate.update("DELETE from ride WHERE id = ?",ride.getId());
	}
	
	public class RideRowMapper implements RowMapper<Ride> {
		@Override
		public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
			Ride ride = new Ride();
			ride.setId(rs.getInt("id"));
			ride.setName(rs.getString("name"));
			ride.setDuration(rs.getInt("duration"));
			return ride;
		}
	}
	
	public void updateRide(Ride ride) {
		jdbcTemplate.update("UPDATE ride SET name = ?,duration = ? WHERE id = ?", ride.getName(), ride.getDuration(),
				ride.getId());
	}
	
	public Ride selectRideByID(Ride r) {
		String sql = "select * from ride where id = ?";
		Ride ride = jdbcTemplate.queryForObject(sql,new RideRowMapper(),r.getId());
		return ride;
	}
	
	public List<Ride> selectRideByName(Ride r){
		String sql = "select * from ride where name = ?";
		List<Ride> rides = jdbcTemplate.query(sql,new RideRowMapper(),r.getName());
		return rides;
	}
	
	public List<Ride> selectRideByDuration(Ride r){
		String sql = "select * from ride where duration = ?";
		List<Ride> rides = jdbcTemplate.query(sql,new RideRowMapper(),r.getDuration());
		return rides;
	}
	
	public List<Ride> selectRideByNameDuration(Ride r){
		String sql = "select * from ride where duration = ? and name = ?";
		List<Ride> rides = jdbcTemplate.query(sql,new RideRowMapper(),r.getDuration(),r.getName());
		return rides;
	}
}
