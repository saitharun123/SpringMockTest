package com.carsim.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.carsim.beans.Song;
import com.carsim.config.ProjectConfig;
import com.carsim.service.VehicleService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		VehicleService service = context.getBean(VehicleService.class);
		Song song = context.getBean(Song.class);
		song.setTitle("Maate Vinadhuga");
		song.setSingerName("SId Sriram");
		
		String status = service.moveVehicle(true);
		System.out.println(status);
		
		String music = service.playMusic(true, song);
		System.out.println(music);
		
		String stop = service.applyBrake(true);
		System.out.println(stop);
		
	}
}
