package com.softwareag.platform.management.productcode.mysql.impl;

import com.softwareag.platform.management.configuration.common.serializer.XmlConfigurationSerializer;
import com.softwareag.platform.management.productcode.mysql.dto.UiBindingMySqlBindingsConfiguration;

public class UiBindingMySqlBindingsSerializer extends XmlConfigurationSerializer {

    @Override
    public Class<?> getConfigurationObjectClass() {
        if (super.getConfigurationObjectClass() == null) {
            super.setConfigurationObjectClass(UiBindingMySqlBindingsConfiguration.class);
        }
        return super.getConfigurationObjectClass();
    }

}
