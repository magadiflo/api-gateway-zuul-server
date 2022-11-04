package com.magadiflo.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient // Para definir este proyecto como cliente de Eureka
@EnableZuulProxy // Habilitamos Zuul en el proyecto
@SpringBootApplication
public class ApiGatewayZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayZuulServerApplication.class, args);
	}

}
