package com.softwareag.platform.management.sdk.democases.configuration.impl;

import com.softwareag.platform.management.sdk.democases.configuration.AbstractUiBindingDemosJsonBindingsManager;

public class AdvancedUiBindingDemosJsonBindingsManager extends AbstractUiBindingDemosJsonBindingsManager {
    private static final String ADVANCED_DEMOS_CASES_PREFIX = "Advanced cases"; //$NON-NLS-1$

    private static final String ADVANCED_CONFIGURATION_TYPE_ID = "ADVANCED-UIBINDING-DEMOS-JSON"; //$NON-NLS-1$

    @Override
    protected String getConfigurationTypeId() {
        return ADVANCED_CONFIGURATION_TYPE_ID;
    }

    @Override
    protected String getConfigurationDisplayPrefix() {
        return ADVANCED_DEMOS_CASES_PREFIX;
    }

}
