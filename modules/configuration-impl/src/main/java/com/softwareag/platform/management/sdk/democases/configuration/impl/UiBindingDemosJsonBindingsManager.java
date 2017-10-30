package com.softwareag.platform.management.sdk.democases.configuration.impl;

import com.softwareag.platform.management.sdk.democases.configuration.AbstractUiBindingDemosJsonBindingsManager;

public class UiBindingDemosJsonBindingsManager extends AbstractUiBindingDemosJsonBindingsManager {
    private static final String DEMOS_CASES_PREFIX = "Demo cases"; //$NON-NLS-1$

    private static final String CONFIGURATION_TYPE_ID = "UIBINDING-DEMOS-JSON"; //$NON-NLS-1$

    @Override
    protected String getConfigurationTypeId() {
        return CONFIGURATION_TYPE_ID;
    }

    @Override
    protected String getConfigurationDisplayPrefix() {
        return DEMOS_CASES_PREFIX;
    }

}
