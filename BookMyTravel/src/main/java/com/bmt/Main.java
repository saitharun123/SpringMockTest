package com.bmt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bmt.beans.BookMyTravel;
import com.bmt.config.ProjectConfig;
import com.bmt.impl.Taxi;
import com.bmt.impl.Train;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		ApplicationContext defaultContext = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		
		BookMyTravel travel2 = defaultContext.getBean(BookMyTravel.class);
		
		travel2.setDistanceToTravel(200);
		int distance2 = travel2.getDistanceToTravel();
		
		double totalFare2 = travel2.getTransportMode().calculateFare(distance2);
		System.out.println("Going through default mode !!");
		travel2.getTransportMode().startTransport();
		travel2.getTransportMode().stopTransport();
		
		System.out.println("Total fare for default travel : "+totalFare2);
//		
//		System.out.println("-----------------------------------------");
//		System.out.println("Changing the transportMode to Taxi !!");
//		
//		travel2.changeTransportMode(context.getBean(Taxi.class));
//		
//		travel2.getTransportMode().startTransport();
//		travel2.getTransportMode().stopTransport();
//		
//		double fare3 = travel2.getTransportMode().calculateFare(distance2);
//		System.out.println("Total fare after changing transport : "+fare3);
//		
//		
//		System.out.println("------------------------------------");
//		BookMyTravel travel = context.getBean(BookMyTravel.class);
//		
//		Train train = context.getBean(Train.class);
//		
//		travel.setTransportMode(train);
//		travel.setDistanceToTravel(100);
//		int distance = travel.getDistanceToTravel();
//		double totalFare = travel.getTransportMode().calculateFare(distance);
//		System.out.println("Starting with "+travel.getTransportMode().getClass().getSimpleName());
//		train.startTransport();
//		train.stopTransport();
//		System.out.println("Total fare for distance Travelled : "+totalFare);
	}
}
