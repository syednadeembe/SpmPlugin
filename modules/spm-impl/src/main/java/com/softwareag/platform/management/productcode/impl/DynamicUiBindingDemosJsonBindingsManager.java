package com.softwareag.platform.management.productcode.impl;

import com.softwareag.platform.management.productcode.AbstractUiBindingDemosJsonBindingsManager;

public class DynamicUiBindingDemosJsonBindingsManager extends AbstractUiBindingDemosJsonBindingsManager {
    private static final String DYNAMIC_DEMOS_CASES_PREFIX = "Dynamic cases"; //$NON-NLS-1$

    private static final String DYNAMIC_CONFIGURATION_TYPE_ID = "cloudExtentionDynamic"; //$NON-NLS-1$

    @Override
    protected String getConfigurationTypeId() {
        return DYNAMIC_CONFIGURATION_TYPE_ID;
    }

    @Override
    protected String getConfigurationDisplayPrefix() {
        return DYNAMIC_DEMOS_CASES_PREFIX;
    }

}
