package cz.linksoft.hr.java.ip2location.trafficlimit;

import java.net.Inet4Address;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import cz.linksoft.hr.java.ip2location.trafficlimit.config.TrafficLimitConfig;

/**
 * Core logic for {@link TrafficLimitHandlerInterceptor}.
 */
@Service
public class TrafficLimitService {

	@NonNull
	private final TrafficLimitConfig trafficLimitConfig;

	TrafficLimitService(@NonNull TrafficLimitConfig trafficLimitConfig) {
		this.trafficLimitConfig = trafficLimitConfig;
	}

	/**
	 * Try acquire permit for client remote address on geographical basis.
	 *
	 * @param clientRemoteAddress Remote address of the client (IPv4)
	 * @return Whether permit is acquired or not
	 */
	public boolean acquireTrafficLimitPermit(@NonNull Inet4Address clientRemoteAddress) {
		//TODO implement me
		return true;
	}

}
