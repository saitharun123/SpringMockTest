package com.bmt.impl;

import org.springframework.stereotype.Component;

import com.bmt.interfaces.TransportMode;

@Component("Train")
public class Train implements TransportMode{

	@Override
	public void startTransport() {
		System.out.println("Train started ! ");
		
	}

	@Override
	public void stopTransport() {
		System.out.println("Train stopped !!");
		
	}

	@Override
	public double calculateFare(int distance) {
		double pricePerKm = 5;
		double fare = distance*pricePerKm;
		return fare;
	}


}
