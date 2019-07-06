package com.example.appTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTestApplication.class, args);
		init();
	}

	private static void init() {
		ExecutorService executor = Executors.newFixedThreadPool(7);
		
		for (int i = 0; i < 10; i++) {
			Runnable worker = new TestJob();
			executor.submit(worker);
		}
		
		executor.shutdown();
		while (!executor.isTerminated()) {			
		}
		
		System.out.println("All tasks are done!");
		
	}
	
	
}
