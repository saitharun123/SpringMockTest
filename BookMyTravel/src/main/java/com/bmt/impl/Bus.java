package com.bmt.impl;

import org.springframework.stereotype.Component;

import com.bmt.interfaces.TransportMode;

@Component("Bus")
public class Bus implements TransportMode{

	@Override
	public void startTransport() {
		System.out.println("Bus started ! ");
		
	}

	@Override
	public void stopTransport() {
		System.out.println("Bus stopped !!");
		
	}

	@Override
	public double calculateFare(int distance) {
		double pricePerKm = 10;
		double fare = distance*pricePerKm;
		return fare;
	}


}
