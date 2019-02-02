package cz.linksoft.hr.java.ip2location.trafficlimit.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cz.linksoft.hr.java.ip2location.model.City;
import cz.linksoft.hr.java.ip2location.model.Country;
import cz.linksoft.hr.java.ip2location.model.Region;

/**
 * Default just hard-coded limits, the same per each country, region and city.
 */
@Component
class DefaultTrafficLimitConfig implements TrafficLimitConfig {

	/**
	 * Country limit - default is 1 000 000.
	 */
	private final int countryLimit;

	/**
	 * Region limit - default is 100 000.
	 */
	private final int regionLimit;

	/**
	 * City limit - default is 10 000.
	 */
	private final int cityLimit;

	DefaultTrafficLimitConfig(@Value("${trafficlimit.country:1000000}") int countryLimit,
							  @Value("${trafficlimit.region:100000}") int regionLimit,
							  @Value("${trafficlimit.city:10000}") int cityLimit) {
		this.countryLimit = countryLimit;
		this.regionLimit = regionLimit;
		this.cityLimit = cityLimit;
	}

	@Override
	public int getMaximalPermittedHourTrafficForCountry(Country country) {
		return countryLimit;
	}

	@Override
	public int getMaximalPermittedHourTrafficForRegion(Country country, Region region) {
		return regionLimit;
	}

	@Override
	public int getMaximalPermittedHourTrafficForCity(Country country, Region region, City city) {
		return cityLimit;
	}

}
