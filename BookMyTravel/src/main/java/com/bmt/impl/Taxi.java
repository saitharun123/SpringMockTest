package com.bmt.impl;

import org.springframework.stereotype.Component;

import com.bmt.interfaces.TransportMode;

@Component("Taxi")
public class Taxi implements TransportMode{

	@Override
	public void startTransport() {
		System.out.println("Taxi started ! ");
		
	}

	@Override
	public void stopTransport() {
		System.out.println("Taxi stopped !!");
		
	}

	@Override
	public double calculateFare(int distance) {
		double pricePerKm = 30;
		double fare = distance*pricePerKm;
		return fare;
	}

}
