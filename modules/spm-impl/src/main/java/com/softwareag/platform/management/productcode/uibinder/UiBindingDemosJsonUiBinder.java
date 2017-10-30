package com.softwareag.platform.management.productcode.uibinder;

import java.io.IOException;
import java.io.InputStream;

import com.softwareag.platform.management.common.configuration.ConfigurationType;
import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.configuration.common.configurationuibinding.UiBinding;
import com.softwareag.platform.management.configuration.uibinding.spi.ConfigurationUiBinder;
import com.softwareag.platform.management.configuration.uibinding.spi.ConfigurationUiBindingFactory;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;

public class UiBindingDemosJsonUiBinder implements ConfigurationUiBinder {

    private static final String UI_BINDING_XML = "/UiBindingDemosJsonBindingsExample.xml"; //$NON-NLS-1$

    @Override
    public UiBinding createConfigurationUiBinding(RuntimeComponentEx runtimeComponent,
        ConfigurationType configurationType) throws IOException, PlatformManagerException {
        InputStream uiBindingStream = this.getClass().getResourceAsStream(UI_BINDING_XML);
            return ConfigurationUiBindingFactory.newInstance().createConfigurationUiBinding(uiBindingStream);
        
    }

}
