package cz.linksoft.hr.java.ip2location.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.linksoft.hr.java.ip2location.model.City;
import cz.linksoft.hr.java.ip2location.model.IPAddressRange;

/**
 * REST endpoint related to {@link City}.
 */
@RestController
@RequestMapping("city")
public class CityRestController {

	/**
	 * Provides all registered object IDs.
	 * @return All registered IDs
	 */
	@GetMapping
	public Collection<Object> getAllIds() {
		//TODO implement me
		return null;
	}

	/**
	 * Provides detail info about object with specified identification.
	 * @param id Identification of object
	 * @return Detail info about object if it's found
	 */
	@GetMapping("{id}")
	public City getOne(@PathVariable("id") Object id) {
		//TODO implement me
		return null;
	}

	/**
	 * Provides all IP address ranges registered for specified city.
	 * @param cityId Identification of city
	 * @return All IP address ranges for the city if it's found
	 */

	@GetMapping("{id}/ip")
	public Collection<IPAddressRange> getAllIpAddressRangesForCity(@PathVariable("id") Object cityId) {
		//TODO implement me
		return null;
	}

}
