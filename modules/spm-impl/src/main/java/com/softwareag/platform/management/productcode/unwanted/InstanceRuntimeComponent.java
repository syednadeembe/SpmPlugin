package com.softwareag.platform.management.productcode.mysql.impl;

import java.io.File;

import com.softwareag.platform.management.common.inventory.Category;
import com.softwareag.platform.management.inventory.spi.Instance;
import com.softwareag.platform.management.inventory.spi.ProductEx;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.productcode.AccessCustomWrapperConf;

public class InstanceRuntimeComponent implements Instance {

  private ProductEx product;
  private String instanceName;
  private File instanceDir;

  public static final String TERRACOTTA_SERVER_INSTANCES_DIR = "Terracotta/server/wrapper";
  public static final String INSTANCE_NAME = "default";
  
  public InstanceRuntimeComponent(ProductEx product) {
    this.product = product;
    this.instanceName = INSTANCE_NAME;
    this.instanceDir = new File(product.getSuiteInstallDirectory(),
        TERRACOTTA_SERVER_INSTANCES_DIR);
  }

  public String getInstanceName() {
    return instanceName;
  }

  public File getInstanceDir() {
    return instanceDir;
  }

  @Override
  public String getId() {
    return product.getId() + '-' + instanceName;
  }

  @Override
  public String getDisplayName() {
    return "TSA-" + AccessCustomWrapperConf.getServerName(product);
  }

  @Override
  public String getProductId() {
    return product.getId();
  }

  @Override
  public Category getCategory() {
    return Category.PROCESS;
  }

  @Override
  public String getRuntimeParentId() {
    return RuntimeComponentEx.ROOT_PARENT_ID;
  }

  @Override
  public ProductEx getProduct() {
    return product;
  }

  @Override
  public File getConfigurationHome() {
    return new File(instanceDir, TERRACOTTA_SERVER_INSTANCES_DIR + File.separator +"conf");
  }

  @Override
  public File getInstanceHome() {
    return new File(instanceDir, TERRACOTTA_SERVER_INSTANCES_DIR);
  }
}
