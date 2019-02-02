package cz.linksoft.hr.java.ip2location.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.linksoft.hr.java.ip2location.model.Region;

/**
 * REST endpoint related to {@link Region}.
 */
@RestController
@RequestMapping("region")
public class RegionRestController {

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
	public Region getOne(@PathVariable("id") Object id) {
		//TODO implement me
		return null;
	}

	/**
	 * Provides all IDs of cities in specified region.
	 * @param regionId Identification of region
	 * @return All IDs of cities in specified region if it's found
	 */
	@GetMapping("{id}/city")
	public Collection<Object> getAllCityIdsForRegion(@PathVariable("id") Object regionId) {
		//TODO implement me
		return null;
	}

}
