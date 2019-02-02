package cz.linksoft.hr.java.ip2location.service.database;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * Provider for local IP2Location data, database of type LITE IP-COUNTRY-REGION-CITY-LATITUDE-LONGITUDE-ZIPCODE.
 *
 * <p>
 *     It refers to IP2Location LITE data downloaded from <a href="https://lite.ip2location.com">http://lite.ip2location.com</a>.
 * </p>
 */
@Service
public class IP2LocationDataResourceProvider {

	@NonNull
	private final ResourceLoader resourceLoader;

	IP2LocationDataResourceProvider(@NonNull ResourceLoader resourceLoader) {
		this.resourceLoader = Objects.requireNonNull(resourceLoader);
	}

	/**
	 * Provides resources for gzipped CSV files, either a custom or default ones. Please be aware that provided
	 * resources are not checked for their existence or readability.
	 *
	 * @param customPaths Custom paths which should replace the default data file(s)
	 * @return Resources
	 */
	@NonNull
	public List<Resource> getAllDatabaseResources(@Nullable List<String> customPaths) {
		if (customPaths == null) {
			return Collections.singletonList(getDefaultDatabaseResource());
		} else {
			return getResourcesForCustomPaths(customPaths);
		}
	}

	@NonNull
	private Resource getDefaultDatabaseResource() {
		return resourceLoader.getResource("classpath:data/IP2LOCATION-LITE-DB9-CE.CSV.gz");
	}

	@NonNull
	private List<Resource> getResourcesForCustomPaths(@NonNull List<String> customPaths) {
		return customPaths.stream()
				.map(resourceLoader::getResource)
				.collect(Collectors.toList());
	}

}
