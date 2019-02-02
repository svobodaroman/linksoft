package cz.linksoft.hr.java.ip2location.service.database;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Component responsible to establish the local database and its data from desired IP2Location CSV data.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LocalDatabaseInitializer implements ApplicationRunner {

	private static final Logger LOG = LoggerFactory.getLogger(LocalDatabaseInitializer.class);

	/**
	 * Argument name for providing optional custom IP2Location CSV data to replace a default one.
	 * @see ApplicationArguments#getOptionValues(String)
	 */
	private static final String ARG_NAME_CUSTOM_DB_PATH = "f";

	@NonNull
	private final IP2LocationDataResourceProvider ip2LocationDataResourceProvider;

	LocalDatabaseInitializer(@NonNull IP2LocationDataResourceProvider ip2LocationDataResourceProvider) {
		this.ip2LocationDataResourceProvider = ip2LocationDataResourceProvider;
	}

	@Override
	public void run(@NonNull ApplicationArguments args) throws Exception {
		LOG.debug("Start initializing a local database");

		final List<String> customDbPaths = args.getOptionValues(ARG_NAME_CUSTOM_DB_PATH);
		if (customDbPaths != null) {
			LOG.info("Custom database: {}", customDbPaths);
		}

		final List<Resource> dbResources = ip2LocationDataResourceProvider.getAllDatabaseResources(customDbPaths);
		initializeLocalDatabaseByCsvResources(dbResources);

		LOG.info("Database initialization is done");
	}

	private void initializeLocalDatabaseByCsvResources(@NonNull List<Resource> gzippedCsvResources) throws Exception {
		//TODO implement me (fill data by CsvParser into the LocalDatabase somehow)
	}

}
