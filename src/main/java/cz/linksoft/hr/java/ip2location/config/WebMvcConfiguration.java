package cz.linksoft.hr.java.ip2location.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cz.linksoft.hr.java.ip2location.trafficlimit.TrafficLimitHandlerInterceptor;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

	@NonNull
	private final TrafficLimitHandlerInterceptor trafficLimitHandlerInterceptor;

	WebMvcConfiguration(@NonNull TrafficLimitHandlerInterceptor trafficLimitHandlerInterceptor) {
		this.trafficLimitHandlerInterceptor = trafficLimitHandlerInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(trafficLimitHandlerInterceptor).addPathPatterns("/**");
	}

}
