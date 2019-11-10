package com.infinity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infinity.model.Ride;
import com.infinity.service.RideService;

@Controller
public class RideController {

	@Autowired
	RideService rideServcie;
	
	//if the input is empty, set the null value.
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value = {"/","/ride"}, method = RequestMethod.GET)
	public ModelAndView ride() {
		ModelAndView mav = new ModelAndView("ride");
		Ride ride = new Ride();
		List<Ride> rides=rideServcie.selectRide(ride);
		mav.addObject("rides",rides);
		mav.addObject("ride",ride);
		return mav;
	}
	
	@RequestMapping(value="/addRide",method = RequestMethod.GET)
	public ModelAndView addRide(){
		ModelAndView mav=new ModelAndView("addRide");
		mav.addObject("ride",new Ride());
		return mav;
	}
	
	@RequestMapping(value="/addRide", method = RequestMethod.POST)
	public ModelAndView addRide(@ModelAttribute("ride") Ride ride) {
		ModelAndView mav=new ModelAndView("ride");
		rideServcie.addRide(ride);
		Ride ride1 = new Ride();
		List<Ride> rides=rideServcie.selectRide(ride1);
		mav.addObject("ride",ride1);
		mav.addObject("rides",rides);
		return mav;
	}
	
	@RequestMapping(value="/deleteRide/{id}", method = RequestMethod.GET)
	public ModelAndView deleteRide(@ModelAttribute("id") Integer id) {
		Ride ride = new Ride();
		ride.setId(id);
		rideServcie.deleteRide(ride);
		ModelAndView mav=new ModelAndView("ride");
		Ride ride1 = new Ride();
		List<Ride> rides=rideServcie.selectRide(ride1);
		mav.addObject("ride",ride1);
		mav.addObject("rides",rides);
		return mav;
	}
	
	@GetMapping("/updateRide/{id}")
	public ModelAndView showUpdateRideForm(@ModelAttribute("id") int id) {
		Ride ride = new Ride();
		ride.setId(id);
		Ride ride1 = rideServcie.selectRide(ride).get(0);
		ModelAndView mav = new ModelAndView("updateRide");
		mav.addObject("ride", ride1);
		return mav;
	}

	@RequestMapping(value = "/updateRide", method = RequestMethod.POST)
	public ModelAndView UpdateRide(@ModelAttribute("ride") Ride ride) {
		rideServcie.updateRide(ride);
		ModelAndView mav = new ModelAndView("ride");
		List<Ride> rides = rideServcie.selectRide(new Ride());
		mav.addObject("rides", rides);
		return mav;
	}
	
	@RequestMapping(value = "/searchRide", method = RequestMethod.POST)
	public ModelAndView searchRide(@ModelAttribute("ride") Ride ride) {
		ModelAndView mav = new ModelAndView("ride");
		List<Ride> rides = rideServcie.selectRide(ride);
		mav.addObject("rides",rides);
		return mav;
	}
}
