package cz.linksoft.hr.java.ip2location.trafficlimit.config;

import org.springframework.lang.Nullable;

import cz.linksoft.hr.java.ip2location.model.City;
import cz.linksoft.hr.java.ip2location.model.Country;
import cz.linksoft.hr.java.ip2location.model.Region;

public interface TrafficLimitConfig {

	/**
	 * Maximal permitted number of requests per hour for specified country.
	 * @param country Country or null if it's other/unknown
	 * @return Maximal permitted number of requests per hour
	 */
	int getMaximalPermittedHourTrafficForCountry(@Nullable Country country);

	/**
	 * Maximal permitted number of requests per hour for specified region.
	 * @param country Country or null if it's other/unknown
	 * @param region Region or null if it's other/unknown
	 * @return Maximal permitted number of requests per hour
	 */
	int getMaximalPermittedHourTrafficForRegion(@Nullable Country country, @Nullable Region region);

	/**
	 * Maximal permitted number of requests per hour for specified city.
	 * @param country Country or null if it's other/unknown
	 * @param region Region or null if it's other/unknown
	 * @param city City or null if it's other/unknown
	 * @return Maximal permitted number of requests per hour
	 */
	int getMaximalPermittedHourTrafficForCity(@Nullable Country country, @Nullable Region region, @Nullable City city);


}
