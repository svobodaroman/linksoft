package cz.linksoft.hr.java.ip2location.trafficlimit;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Interceptor to apply traffic limit based on IPv4 remote address of client.
 *
 * @see TrafficLimitService
 */
@Component
public class TrafficLimitHandlerInterceptor implements HandlerInterceptor {

	private static final String IPV4_PARAMETER_NAME	= "RemoteClientIPv4";
	private static final String IPV4_HEADER_NAME	= "X-RemoteClientIPv4";

	private static final Logger LOG = LoggerFactory.getLogger(TrafficLimitHandlerInterceptor.class);

	@NonNull
	private final TrafficLimitService trafficLimitService;

	private final boolean strictTrafficLimit;

	TrafficLimitHandlerInterceptor(@NonNull TrafficLimitService trafficLimitService,
								   @Value("${trafficlimit.strict:false}") boolean strictTrafficLimit) {
		this.trafficLimitService = trafficLimitService;
		this.strictTrafficLimit = strictTrafficLimit;

		LOG.info(strictTrafficLimit ? "Traffic limit is strict" : "Traffic limit is lenient");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		final Inet4Address clientRemoteAddress = getIPv4RemoteAddressFromRequestIfAny(request);
		if (clientRemoteAddress == null) {
			//unknown IPv4 address
			if (strictTrafficLimit) {
				LOG.warn("Unknown IPv4 address of remote client -> not acceptable");
				response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				return false;
			} else {
				LOG.warn("Unknown IPv4 address of remote client -> accepting without applying traffic limit");
				return true;
			}
		}

		if (trafficLimitService.acquireTrafficLimitPermit(clientRemoteAddress)) {
			LOG.debug("Allowed request for: {}", clientRemoteAddress);
			return true;

		} else {
			LOG.warn("Disallowed request for: {}", clientRemoteAddress);
			response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

	/**
	 * @param request HTTP request to be inspected
	 * @return IPv4 address of remote client if any.
	 */
	private Inet4Address getIPv4RemoteAddressFromRequestIfAny(HttpServletRequest request) {
		//1) parameter
		Inet4Address inet4Address = getIPv4AddressFromAddressIfPossible(request.getParameter(IPV4_PARAMETER_NAME));
		if (inet4Address == null) {
			//2 header
			inet4Address = getIPv4AddressFromAddressIfPossible(request.getHeader(IPV4_HEADER_NAME));
			if (inet4Address == null) {
				inet4Address = getIPv4AddressFromAddressIfPossible(request.getRemoteAddr());
			}
		}
		return inet4Address;
	}

	private Inet4Address getIPv4AddressFromAddressIfPossible(String remoteAddress) {
		if (remoteAddress == null) {
			return null;
		} else {
			try {
				InetAddress ipAddress = InetAddress.getByName(remoteAddress);
				return ipAddress instanceof Inet4Address ? (Inet4Address) ipAddress : null;
			} catch (UnknownHostException e) {
				return null;
			}
		}
	}

}
