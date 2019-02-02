package cz.linksoft.hr.java.ip2location.model;

/**
 * The city, located in some country and region.
 */
//TODO figure out how to make relationship to region and IP address ranges
public class City {

	/**
	 * Name of the city. It needn't to be unique in the region or country.
	 */
	String name;

	/**
	 * Coordinates in GPS, describes somehow central point of the city.
	 */
	GpsCoordinates gpsCoordinates;

	/**
	 * ZIP code aka postal code related to the city. For cities with multiple ZIP codes there is just some single one.
	 */
	String zipCode;

}
