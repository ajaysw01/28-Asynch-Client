package com.aj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {
	
	static String url = "http://13.232.253.164:8081/ticket/{ticketNumber}";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		WebClient webClient = WebClient.create();
		System.err.println("req sendign start ...");
		webClient.get()
		.uri(url,6)
		.header("Accept","application/json")
		.retrieve()
		.bodyToMono(String.class)
		.subscribe(Application::handleResponse);//dont wait for response
		
		System.out.println("request sending end....");
	}
	
	public static void handleResponse(String response) {
		System.out.println(response);
	}
	

}
