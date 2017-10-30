package com.softwareag.platform.management.productcode.mysql.impl;

import com.softwareag.platform.management.productcode.mysql.impl.AbstractUiBindingMySqlBindingsManager;

public class UiBindingMySqlBindingsManager extends AbstractUiBindingMySqlBindingsManager {
    private static final String DEMOS_CASES_PREFIX = "DataBase Configuration"; //$NON-NLS-1$

    private static final String CONFIGURATION_TYPE_ID = "MySql"; //$NON-NLS-1$

    @Override
    protected String getConfigurationTypeId() {
        return CONFIGURATION_TYPE_ID;
    }

    @Override
    protected String getConfigurationDisplayPrefix() {
        return DEMOS_CASES_PREFIX;
    }

}
