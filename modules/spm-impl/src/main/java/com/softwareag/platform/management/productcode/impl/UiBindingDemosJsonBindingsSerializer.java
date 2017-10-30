package com.softwareag.platform.management.productcode.impl;

import com.softwareag.platform.management.configuration.common.serializer.XmlConfigurationSerializer;
import com.softwareag.platform.management.productcode.dto.UiBindingDemosJsonBindingsConfiguration;

public class UiBindingDemosJsonBindingsSerializer extends XmlConfigurationSerializer {

    @Override
    public Class<?> getConfigurationObjectClass() {
        if (super.getConfigurationObjectClass() == null) {
            super.setConfigurationObjectClass(UiBindingDemosJsonBindingsConfiguration.class);
        }
        return super.getConfigurationObjectClass();
    }

}
