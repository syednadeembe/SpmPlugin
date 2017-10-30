package com.softwareag.platform.management.productcode;

import com.softwareag.platform.management.configuration.common.serializer.XmlConfigurationSerializer;

public class ServerNameConfigSerializer extends XmlConfigurationSerializer {
  @Override
  protected String getValidatingSchemaName() {
    return "server-name.xsd"; //$NON-NLS-1$
  }

  @Override
  public Class<?> getConfigurationObjectClass() {
    return null;
  }
}
