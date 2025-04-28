package com.bmt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bmt.interfaces.TransportMode;

@Component
public class BookMyTravel {

	private TransportMode transportMode;

	private int distanceToTravel;

	public int getDistanceToTravel() {
		return distanceToTravel;
	}

	public void setDistanceToTravel(int distanceToTravel) {
		this.distanceToTravel = distanceToTravel;
	}

	public TransportMode getTransportMode() {
		return transportMode;
	}

	@Autowired
	@Qualifier("Train")
	public void setTransportMode(TransportMode transportMode) {
		this.transportMode = transportMode;
	}
	

	@Override
	public String toString() {
		return "BookMyTravel [transportMode=" + transportMode + ", distanceToTravel=" + distanceToTravel + "]";
	}
	
	public void changeTransportMode(TransportMode transport) {
		if(transportMode!=null) {
			this.transportMode = transport;
		}
	}
	
}
