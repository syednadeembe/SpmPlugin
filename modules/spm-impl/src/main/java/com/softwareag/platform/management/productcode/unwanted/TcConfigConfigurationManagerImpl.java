package com.softwareag.platform.management.productcode.unwanted;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.softwareag.platform.management.common.configuration.ConfigurationInstance;
import com.softwareag.platform.management.common.configuration.ConfigurationStatus;
import com.softwareag.platform.management.common.configuration.ConfigurationType;
import com.softwareag.platform.management.common.configuration.dto.CategoryDTO;
import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.configuration.common.serializer.ConfigurationSourceFactory;
import com.softwareag.platform.management.configuration.spi.ConfigurationFactory;
import com.softwareag.platform.management.configuration.spi.ConfigurationManager;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.productcode.unwanted.InstanceRuntimeComponent;

public class TcConfigConfigurationManagerImpl implements ConfigurationManager {

	private static final String TC_CONFIG_NAME = "TC-CONFIG";

	private ConfigurationType configurationType = ConfigurationFactory
			.createConfigurationType(TC_CONFIG_NAME, "TC-Config", "TC-Config",
					new CategoryDTO(TC_CONFIG_NAME, "TC-Config"), "text/plain");

	@Override
	public ConfigurationInstance createConfiguration(RuntimeComponentEx arg0,
			Object arg1) throws IOException, PlatformManagerException {
		throw new UnsupportedOperationException(
				"Creating new tc-config.xml is not supported");
	}

	@Override
	public ConfigurationStatus deleteConfiguration(RuntimeComponentEx arg0,
			ConfigurationInstance arg1) throws IOException,
			PlatformManagerException {
		throw new UnsupportedOperationException(
				"Deleting tc-config.xml is not supported");
	}

	@Override
	public Collection<ConfigurationInstance> getConfigurationInstances(
			RuntimeComponentEx rc) throws IOException, PlatformManagerException {
		Collection<ConfigurationInstance> configurationInstances = new ArrayList<>();
		InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
		configurationInstances.add(ConfigurationFactory
				.createConfigurationInstance(TC_CONFIG_NAME, runtimeComponent
						.getId(), getConfigurationType().getId(), "TC-Config",
						"TC-Config", null));
		return Collections.unmodifiableCollection(configurationInstances);
	}

	@Override
	public ConfigurationType getConfigurationType() throws IOException {
		return configurationType;
	}

	@Override
	public Object loadConfiguration(RuntimeComponentEx rc,
			ConfigurationInstance configurationInstance,
			ConfigurationStatus configurationStatus) throws IOException,
			PlatformManagerException {
		InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
		TcConfigPlainTextSerializer tcConfigSerializer = new TcConfigPlainTextSerializer();
		return tcConfigSerializer.loadConfiguration(runtimeComponent);
	}

	@Override
	public ConfigurationStatus updateConfiguration(RuntimeComponentEx rc,
			ConfigurationInstance configurationInstance,
			Object configurationObject) throws IOException,
			PlatformManagerException {
		InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
		TcConfigSerializer configSerializer = new TcConfigSerializer();
		Object configObj = null;
		try{
			configObj = configSerializer.deserialize(ConfigurationSourceFactory.createConfigurationSource(new ByteArrayInputStream(((String)configurationObject).getBytes()), "UTF-8"));
		} catch (Exception ex){
			throw new PlatformManagerException(ex);
		}
		
		if (configObj == null) {
			throw new PlatformManagerException(new RuntimeException("Incorrect TC-Config"));
		}

		TcConfigPlainTextSerializer tcConfigSerializer = new TcConfigPlainTextSerializer();
		tcConfigSerializer.saveConfiguration(runtimeComponent,
				configurationObject);
		return ConfigurationStatus.PENDING_RESTART;
	}

}
