package cz.linksoft.hr.java.ip2location.rest;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.linksoft.hr.java.ip2location.model.Country;

/**
 * REST endpoint related to {@link Country}.
 */
@RestController
@RequestMapping("country")
public class CountryRestController {

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
	public Country get(@PathVariable("id") Object id) {
		//TODO implement me
		return null;
	}

	/**
	 * Provides all IDs of regions in specified country.
	 * @param countryId Identification of country
	 * @return All IDs of regions in specified country if it's found
	 */
	@GetMapping("{id}/region")
	public Collection<Object> getAllRegionsIdsForCountry(@PathVariable("id") Object countryId) {
		//TODO implement me
		return null;
	}

}
