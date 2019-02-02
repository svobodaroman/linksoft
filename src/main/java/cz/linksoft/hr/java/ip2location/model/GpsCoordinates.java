package cz.linksoft.hr.java.ip2location.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * <a href="https://en.wikipedia.org/wiki/Geographic_coordinate_system#Horizontal_coordinates">GPS horizontal coordinates</a>
 */
public class GpsCoordinates {

	/**
	 * <p>
	 *     The "latitude" of a point on Earth's surface is the angle between the equatorial plane and the straight line
	 *     that passes through that point and through (or close to) the center of the Earth.
	 * </p>
	 *
	 * <p>
	 *     The North Pole is 90° N; the South Pole is 90° S. The 0° parallel of latitude is designated the Equator.
	 * </p>
	 */
	@Min(-90)
	@Max(90)
	double latitude;

	/**
	 * <p>
	 *     The "longitude" of a point on Earth's surface is the angle east or west of a reference meridian to another
	 *     meridian that passes through that point. All meridians are halves of great ellipses (often called great
	 *     circles), which converge at the North and South Poles. The meridian of the British Royal Observatory in
	 *     Greenwich, in south-east London, England, is the international prime meridian.
	 * </p>
	 * <p>
	 *     The prime meridian determines the proper Eastern and Western Hemispheres. The antipodal meridian of Greenwich
	 *     is both 180°W and 180°E.
	 * </p>
	 */
	@Min(-180)
	@Max(180)
	double longitude;

}
