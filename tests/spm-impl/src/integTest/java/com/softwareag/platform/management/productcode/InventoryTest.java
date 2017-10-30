/*
 * Copyright (c) 2011-2015 Software AG, Darmstadt, Germany and/or Software AG USA Inc., Reston, VA, USA, and/or its subsidiaries and/or its affiliates and/or their licensors.
 *
 * Use, reproduction, transfer, publication or disclosure is prohibited except as specifically provided for in your License Agreement with Software AG.
 */
package com.softwareag.platform.management.productcode;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.inventory.spi.InventoryExService;

/**
 * Example Inventory Integration Test.
 */
public class InventoryTest {

    public static final String PRODUCT_ID = System.getProperty("spm.common.plugins.product.id"); //$NON-NLS-1$

    private BundleContext bundleContext;

    private InventoryExService inventoryService;

    @Before
    public void init() throws Exception {
        Bundle bundle = FrameworkUtil.getBundle(this.getClass());
        Assert.assertNotNull("Not running under OSGi", bundle); //$NON-NLS-1$
        bundleContext = bundle.getBundleContext();
        Assert.assertNotNull("Bundle context is null", bundleContext); //$NON-NLS-1$
        ServiceReference sr = bundleContext.getServiceReference(InventoryExService.class.getName());
        Assert.assertNotNull("InventoryService is not available", sr); //$NON-NLS-1$
        inventoryService = (InventoryExService) bundleContext.getService(sr);
        Assert.assertNotNull("InventoryService is not available", inventoryService); //$NON-NLS-1$
    }

    @Test
    public void testProductInInventoryService() throws PlatformManagerException {
        Assert.assertNotNull("The product " + PRODUCT_ID + " should be present in the SPM inventory.", inventoryService.getInstalledProduct(PRODUCT_ID));
    }

}
