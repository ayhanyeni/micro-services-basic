package com.study.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("r1", r -> r.host("**.baeldung.com")
//						.and()
//						.path("/baeldung")
//						.uri("http://baeldung.com"))
//				.route(r -> r.host("**.baeldung.com")
//						.and()
//						.path("/myOtherRouting")
//						.filters(f -> f.prefixPath("/myPrefix"))
//						.uri("http://othersite.com")
//						.id("myOtherID"))
//				.build();
//	}

}
