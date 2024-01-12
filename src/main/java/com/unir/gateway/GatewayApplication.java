package com.unir.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GatewayApplication {

	@GetMapping("/")
	public String health() {
		return "OK";
	}

	public static void main(String[] args) {
		
		// Obtenemos perfil de ejecucion de variable de entorno. Si no hay, perfil default. 
		String profile = System.getenv("PROFILE");
		System.setProperty("spring.profiles.active", profile != null ? profile : "default");
		SpringApplication.run(GatewayApplication.class, args);
	}

}
