package com.softwareag.platform.management.productcode.mysql.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.softwareag.platform.management.common.configuration.ConfigurationContentType;
import com.softwareag.platform.management.common.configuration.ConfigurationInstance;
import com.softwareag.platform.management.common.configuration.ConfigurationStatus;
import com.softwareag.platform.management.common.configuration.ConfigurationType;
import com.softwareag.platform.management.common.configuration.dto.CategoryDTO;
import com.softwareag.platform.management.configuration.spi.ConfigurationFactory;
import com.softwareag.platform.management.configuration.spi.ConfigurationManager;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.productcode.mysql.dto.UiBindingMySqlBindingsConfiguration;

public abstract class AbstractUiBindingMySqlBindingsManager implements ConfigurationManager {

    public static final String CONFIGURATION_INSTANCE_BASE_ID = "demoInstance"; //$NON-NLS-1$

    private static final int INITIAL_INSTANCE_ID_SUFFIX = 1;

    private Map<String, UiBindingMySqlBindingsConfiguration> inMemoryConfiguration = new HashMap<>();

    private int stateCounter = INITIAL_INSTANCE_ID_SUFFIX;

    protected abstract String getConfigurationTypeId();

    protected abstract String getConfigurationDisplayPrefix();

    @Override
    public ConfigurationType getConfigurationType() {
        return ConfigurationFactory
            .createConfigurationType(
                getConfigurationTypeId(),
                getConfigurationDisplayPrefix() + " UiBindig - MySql type", //$NON-NLS-1$
                getConfigurationDisplayPrefix() + " for MySql support by GCUI", new CategoryDTO(getConfigurationTypeId(), getConfigurationDisplayPrefix() + " - Default"), //$NON-NLS-1$ //$NON-NLS-2$
                ConfigurationContentType.XML.value());
    }

    @Override
    public Object loadConfiguration(RuntimeComponentEx runtimeComponent, ConfigurationInstance configurationInstance, ConfigurationStatus status) {
        return inMemoryConfiguration.get(configurationInstance.getId());
    }

    @Override
    public ConfigurationStatus updateConfiguration(RuntimeComponentEx runtimeComponent, ConfigurationInstance configurationInstance, Object configurationObject) {

        inMemoryConfiguration.put(configurationInstance.getId(), (UiBindingMySqlBindingsConfiguration) configurationObject);

        return ConfigurationStatus.CURRENT;

    }

    @Override
    public Collection<ConfigurationInstance> getConfigurationInstances(RuntimeComponentEx runtimeComponent) {
        Collection<ConfigurationInstance> configInstances = new ArrayList<>();
        for (String configurationInstanceId : inMemoryConfiguration.keySet()) {
            ConfigurationInstance configurationInstance = createConfigurationInstance(runtimeComponent, configurationInstanceId);
            configInstances.add(configurationInstance);
        }
        return configInstances;
    }

    @Override
    public ConfigurationInstance createConfiguration(RuntimeComponentEx runtimeComponent, Object configurationObject) {
        if (configurationObject == null) {
            throw new IllegalArgumentException("The provided configuration data can not be null."); //$NON-NLS-1$
        }

        UiBindingMySqlBindingsConfiguration demosJsonBinding = (UiBindingMySqlBindingsConfiguration) configurationObject;
        
        String createdInstanceId = getConfigurationTypeId() + "-" + getConfigurationInstanceBaseId(demosJsonBinding.getName()) + stateCounter++;
        
        ConfigurationInstance configurationInstance = createConfigurationInstance(runtimeComponent, createdInstanceId);        

        inMemoryConfiguration.put(configurationInstance.getId(), demosJsonBinding);

        return configurationInstance;

    }

    private String getConfigurationInstanceBaseId(String demosJsonBindingName) {        
        if(demosJsonBindingName == null) {
            return  CONFIGURATION_INSTANCE_BASE_ID;
        }        
        return demosJsonBindingName;
    }

    @Override
    public ConfigurationStatus deleteConfiguration(RuntimeComponentEx runtimeComponent, ConfigurationInstance configurationInstance) {
    	UiBindingMySqlBindingsConfiguration deletedInstance = inMemoryConfiguration.remove(configurationInstance.getId());
        return (deletedInstance != null) ? ConfigurationStatus.DELETED : ConfigurationStatus.NOT_DELETED;
    }

    private ConfigurationInstance createConfigurationInstance(RuntimeComponentEx runtimeComponent, String createdInstanceId) {
        return ConfigurationFactory.createConfigurationInstance(createdInstanceId, runtimeComponent.getId(), getConfigurationTypeId(),
            "Configuration " + createdInstanceId, "Description " + createdInstanceId , null); //$NON-NLS-1$//$NON-NLS-2$
    }
}
