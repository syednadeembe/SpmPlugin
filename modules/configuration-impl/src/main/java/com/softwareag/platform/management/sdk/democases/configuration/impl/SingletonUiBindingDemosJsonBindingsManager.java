package com.softwareag.platform.management.sdk.democases.configuration.impl;

import java.util.Collection;
import java.util.Collections;

import com.softwareag.platform.management.common.configuration.ConfigurationInstance;
import com.softwareag.platform.management.common.configuration.ConfigurationStatus;
import com.softwareag.platform.management.configuration.spi.ConfigurationFactory;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.sdk.democases.configuration.AbstractUiBindingDemosJsonBindingsManager;
import com.softwareag.platform.management.sdk.democases.configuration.dto.UiBindingDemosJsonBindingsConfiguration;

public class SingletonUiBindingDemosJsonBindingsManager extends AbstractUiBindingDemosJsonBindingsManager {
    private static final String SINGLETON_DEMOS_CASES_PREFIX = "Singleton cases"; //$NON-NLS-1$

    private static final String SINGLETON_CONFIGURATION_TYPE_ID = "SINGLETON-UIBINDING-DEMOS-JSON"; //$NON-NLS-1$
    
    private static final String SINGLETON_NAME_CONFIGURATION="testSingleton"; //$NON-NLS-1$
    
    private static final String CONFIGURATION_INSTANCE_ID_FORMAT= "%s-%s"; //$NON-NLS-1$
    
    private static final String CONFIGURATION_DISPLAY_NAME_FORMAT =  "%s %s"; //$NON-NLS-1$
    
    private static final String CONFIGURATION_DESCRIPTION_FORMAT = "Configuration for %s"; //$NON-NLS-1$
    
    private static final String SINGLETON_DESCRIPTION = "Singleton configuration uiBinding"; //$NON-NLS-1$
    

    @Override
    protected String getConfigurationTypeId() {
        return SINGLETON_CONFIGURATION_TYPE_ID;
    }

    @Override
    protected String getConfigurationDisplayPrefix() {
        return SINGLETON_DEMOS_CASES_PREFIX;
    }
    
    
    @Override
    public ConfigurationInstance createConfiguration(RuntimeComponentEx runtimeComponent, Object configurationObject) {
        return createConfigurationInstance(runtimeComponent);
    }
    
    @Override
    public Collection<ConfigurationInstance> getConfigurationInstances(RuntimeComponentEx runtimeComponent) {
        ConfigurationInstance instance = createConfigurationInstance(runtimeComponent);
        return Collections.singletonList(instance);
    }
    
    private ConfigurationInstance createConfigurationInstance(RuntimeComponentEx runtimeComponent){
        String configurationInstanceId = String.format(CONFIGURATION_INSTANCE_ID_FORMAT,SINGLETON_CONFIGURATION_TYPE_ID, SINGLETON_NAME_CONFIGURATION);
        String configurationDisplayName = String.format(CONFIGURATION_DISPLAY_NAME_FORMAT,SINGLETON_CONFIGURATION_TYPE_ID ,SINGLETON_NAME_CONFIGURATION);
        String configurationDescription = String.format(CONFIGURATION_DESCRIPTION_FORMAT, SINGLETON_DESCRIPTION);
        return ConfigurationFactory.createConfigurationInstance(configurationInstanceId, runtimeComponent.getId(),SINGLETON_CONFIGURATION_TYPE_ID,  configurationDisplayName,configurationDescription,null); 
    }
    
     @Override
     public Object loadConfiguration(RuntimeComponentEx runtimeComponent, ConfigurationInstance configurationInstance, ConfigurationStatus status) {
     return constructSingleton();
     }
    
    private UiBindingDemosJsonBindingsConfiguration constructSingleton() {
        UiBindingDemosJsonBindingsConfiguration demo = new UiBindingDemosJsonBindingsConfiguration();
        demo.setEnabled(true);
        demo.setName("Singleton"); //$NON-NLS-1$
        return demo;
    }
}
