package com.softwareag.platform.management.productcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//import org.terracotta.config.BindPort;
//import org.terracotta.config.Server;
//import org.terracotta.config.TcConfig;

import com.softwareag.platform.management.common.configuration.ConfigurationInstance;
import com.softwareag.platform.management.common.configuration.ConfigurationStatus;
import com.softwareag.platform.management.common.configuration.ConfigurationType;
import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.configuration.common.types.ConfigurationTypesFactory;
import com.softwareag.platform.management.configuration.common.types.portsettings.ObjectFactory;
import com.softwareag.platform.management.configuration.common.types.portsettings.Port;
import com.softwareag.platform.management.configuration.common.types.portsettings.PortSettings;
import com.softwareag.platform.management.configuration.common.types.portsettings.PortType;
import com.softwareag.platform.management.configuration.spi.ConfigurationFactory;
import com.softwareag.platform.management.configuration.spi.ConfigurationManager;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.productcode.InstanceRuntimeComponent;

public class PortsConfigurationManagerImpl implements ConfigurationManager {

  public static final String TSA_PORT_INSTANCE_ID = ConfigurationTypesFactory.COMMON_PORTS
      + '-' + "TSA";
  public static final String JMX_PORT_INSTANCE_ID = ConfigurationTypesFactory.COMMON_PORTS
      + '-' + "JMX";
  public static final String GROUP_PORT_INSTANCE_ID = ConfigurationTypesFactory.COMMON_PORTS
      + '-' + "GROUP";
  public static final String MANAGEMENT_PORT_INSTANCE_ID = ConfigurationTypesFactory.COMMON_PORTS
      + '-' + "MANAGEMENT";

  private ConfigurationType configurationType;

  public PortsConfigurationManagerImpl() {
    configurationType = ConfigurationTypesFactory.createCommonPorts();
  }

  @Override
  public ConfigurationType getConfigurationType() throws IOException {
    return configurationType;
  }

/*  @Override
  public Collection<ConfigurationInstance> getConfigurationInstances(
      RuntimeComponentEx rc) throws IOException, PlatformManagerException {

    Collection<ConfigurationInstance> configurationInstances = new ArrayList<>();
    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
*/
//    TcConfigSerializer tcConfigSerializer = new TcConfigSerializer();
//    TcConfig tcConfig = tcConfigSerializer.loadConfiguration(runtimeComponent);
//    Server server = tcConfigSerializer.loadServerConfiguration(
//        runtimeComponent, tcConfig);
//    if (server != null) {
//      if (server.getTsaPort() != null) {
//        // primary port instance
//        configurationInstances.add(ConfigurationFactory
//            .createConfigurationInstance(TSA_PORT_INSTANCE_ID,
//                runtimeComponent.getId(), getConfigurationType().getId(),
//                "TSA Port", "Port for client connections", null));
//      }
//
//      if (server.getJmxPort() != null) {
//        // jmx port instance
//        configurationInstances.add(ConfigurationFactory
//            .createConfigurationInstance(JMX_PORT_INSTANCE_ID,
//                runtimeComponent.getId(), getConfigurationType().getId(),
//                "JMX Port", "Port for administration", null));
//      }
//
//      // group port instance
//      if (server.getTsaGroupPort() != null) {
//        configurationInstances.add(ConfigurationFactory
//            .createConfigurationInstance(GROUP_PORT_INSTANCE_ID,
//                runtimeComponent.getId(), getConfigurationType().getId(),
//                "Group Port", "Port for cluster group communication", null));
//      }
//
//      // management port instance
//      if (server.getManagementPort() != null) {
//        configurationInstances
//            .add(ConfigurationFactory.createConfigurationInstance(
//                MANAGEMENT_PORT_INSTANCE_ID, runtimeComponent.getId(),
//                getConfigurationType().getId(), "Management Port",
//                "Port for cluster group communication", null));
//      }
//    }
//
//    return Collections.unmodifiableCollection(configurationInstances);
//  }

//  @Override
//  public Object loadConfiguration(RuntimeComponentEx rc,
//      ConfigurationInstance configurationInstance, ConfigurationStatus status)
//      throws IOException, PlatformManagerException {
//
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//
//    TcConfigSerializer tcConfigSerializer = new TcConfigSerializer();
//    TcConfig tcConfig = tcConfigSerializer.loadConfiguration(runtimeComponent);
//    Server server = tcConfigSerializer.loadServerConfiguration(
//        runtimeComponent, tcConfig);
//    if (server == null) {
//      throw new IllegalArgumentException(
//          "Server configuration for this runtime instance is not found");
//    }

//    ObjectFactory objectFactory = new ObjectFactory();
//    PortSettings portSettings = objectFactory.createPortSettings();
//    Port port = objectFactory.createPort();
//
//    String alias = configurationInstance.getId()
//        .substring(getConfigurationType().getId().length() + 1).toLowerCase();
//
//    // instance specific properties
//    port.setAlias(alias);
//    port.setEnabled(true);
//
//    switch (configurationInstance.getId()) {
//    case TSA_PORT_INSTANCE_ID: {
//      BindPort portBinding = server.getTsaPort();
//      port.setNumber(portBinding.getValue());
//      if (portBinding.getBind() != null) {
//        port.setBindAddress(portBinding.getBind());
//      } else {
//        port.setBindAddress("0.0.0.0");
//      }
//      port.setProtocol("TCP");
//      port.setType(PortType.STANDARD);
//      port.setPrimary(true);
//      break;
//    }
//    case JMX_PORT_INSTANCE_ID: {
//      BindPort portBinding = server.getJmxPort();
//      port.setNumber(portBinding.getValue());
//      if (portBinding.getBind() != null) {
//        port.setBindAddress(portBinding.getBind());
//      } else {
//        port.setBindAddress("0.0.0.0");
//      }
//      port.setProtocol("JMX");
//      port.setType(PortType.DIAGNOSTIC);
//      break;
//    }
//    case GROUP_PORT_INSTANCE_ID: {
//      BindPort portBinding = server.getTsaGroupPort();
//      port.setNumber(portBinding.getValue());
//      if (portBinding.getBind() != null) {
//        port.setBindAddress(portBinding.getBind());
//      } else {
//        port.setBindAddress("0.0.0.0");
//      }
//      port.setProtocol("TCP");
//      port.setType(PortType.ADMINISTRATIVE);
//      break;
//    }
//    case MANAGEMENT_PORT_INSTANCE_ID: {
//      BindPort portBinding = server.getManagementPort();
//      port.setNumber(portBinding.getValue());
//      if (portBinding.getBind() != null) {
//        port.setBindAddress(portBinding.getBind());
//      } else {
//        port.setBindAddress("0.0.0.0");
//      }
//      port.setProtocol("TCP");
//      port.setType(PortType.DIAGNOSTIC);
//      break;
//    }
//    default: {
//      throw new IllegalArgumentException("Invalid configuration instance id: "
//          + configurationInstance.getId());
//    }
//    }
//
//    portSettings.getPort().add(port);
//    return portSettings;
//  }

  @Override
  public ConfigurationStatus updateConfiguration(RuntimeComponentEx rc,
      ConfigurationInstance configurationInstance, Object configurationObject)
      throws IOException, PlatformManagerException {
    throw new UnsupportedOperationException(
        "Creating new ports is not supported");

  }

  @Override
  public ConfigurationInstance createConfiguration(
      RuntimeComponentEx runtimeComponent, Object configurationObject)
      throws IOException, PlatformManagerException {
    throw new UnsupportedOperationException(
        "Creating new ports is not supported");
  }

  @Override
  public ConfigurationStatus deleteConfiguration(
      RuntimeComponentEx runtimeComponent,
      ConfigurationInstance configurationInstance) throws IOException,
      PlatformManagerException {
    throw new UnsupportedOperationException("Deleting ports is not supported");
  }

@Override
public Collection<ConfigurationInstance> getConfigurationInstances(RuntimeComponentEx arg0)
		throws IOException, PlatformManagerException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object loadConfiguration(RuntimeComponentEx arg0, ConfigurationInstance arg1, ConfigurationStatus arg2)
		throws IOException, PlatformManagerException {
	// TODO Auto-generated method stub
	return null;
}
}