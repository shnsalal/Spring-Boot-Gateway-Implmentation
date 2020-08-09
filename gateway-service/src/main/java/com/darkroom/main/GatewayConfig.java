package com.darkroom.main;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("ORDER-SERVICE", r -> r.path("/order/**")
					.filters(f -> f.hystrix(h -> h.setName("circuitBreaker")
							.setFallbackUri("forward:/orderFallback")))
				.uri("lb://ORDER-SERVICE"))
			.route("PAYMENT-SERVICE",
					r -> r.path("/payment/**")
					.filters(f -> f.hystrix(h -> h.setName("circuitBreaker")
							.setFallbackUri("forward:/paymentFallback")))
					.uri("lb://PAYMENT-SERVICE"))
			.build();
	}
}
