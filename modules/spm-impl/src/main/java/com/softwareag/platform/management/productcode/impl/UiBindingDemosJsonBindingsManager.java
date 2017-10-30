package com.softwareag.platform.management.productcode.impl;

import com.softwareag.platform.management.productcode.AbstractUiBindingDemosJsonBindingsManager;

public class UiBindingDemosJsonBindingsManager extends AbstractUiBindingDemosJsonBindingsManager {
    private static final String DEMOS_CASES_PREFIX = "Demo cases"; //$NON-NLS-1$

    private static final String CONFIGURATION_TYPE_ID = "cloudExtentionStatic"; //$NON-NLS-1$

    @Override
    protected String getConfigurationTypeId() {
        return CONFIGURATION_TYPE_ID;
    }

    @Override
    protected String getConfigurationDisplayPrefix() {
        return DEMOS_CASES_PREFIX;
    }

}
