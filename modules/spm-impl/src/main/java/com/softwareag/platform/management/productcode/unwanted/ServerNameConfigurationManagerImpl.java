package com.softwareag.platform.management.productcode.unwanted;

import com.softwareag.platform.management.common.configuration.ConfigurationInstance;
import com.softwareag.platform.management.common.configuration.ConfigurationStatus;
import com.softwareag.platform.management.common.configuration.ConfigurationType;
import com.softwareag.platform.management.common.configuration.dto.CategoryDTO;
import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.configuration.spi.ConfigurationFactory;
import com.softwareag.platform.management.configuration.spi.ConfigurationManager;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.productcode.AccessCustomWrapperConf;
import com.softwareag.platform.management.productcode.unwanted.InstanceRuntimeComponent;
import com.softwareag.platform.management.productcode.ParameterSubstituter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class ServerNameConfigurationManagerImpl implements ConfigurationManager {
  private static final String Property_Server_Name_1 = "wrapper.app.parameter.6";
  private static final String Property_Server_Name_2 = "wrapper.app.parameter.13";
  private static final String SERVER_CONFIG_NAME = "TC-SERVER-NAME";

  private ConfigurationType configurationType = ConfigurationFactory
      .createConfigurationType(SERVER_CONFIG_NAME, "Server Name",
          "Server Name to uniquely identify an Instance", new CategoryDTO(
              SERVER_CONFIG_NAME, "Server Name"), "text");

  @Override
  public ConfigurationType getConfigurationType() throws IOException {
    return configurationType;
  }

  @Override
  public Collection<ConfigurationInstance> getConfigurationInstances(
      RuntimeComponentEx rc) throws IOException, PlatformManagerException {

    Collection<ConfigurationInstance> configurationInstances = new ArrayList<>();
    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
    configurationInstances
        .add(ConfigurationFactory.createConfigurationInstance(
            SERVER_CONFIG_NAME, runtimeComponent.getId(),
            getConfigurationType().getId(), "Server Name",
            "Server Name to uniquely identify an Instance", null));

    return Collections.unmodifiableCollection(configurationInstances);
  }

//  @Override
//  public Object loadConfiguration(RuntimeComponentEx rc,
//      ConfigurationInstance configurationInstance, ConfigurationStatus status)
//      throws IOException, PlatformManagerException {
//
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
////    Servers serverObjectFactory = new Servers();
//
//    File customWrapperConf = AccessCustomWrapperConf
//        .getRootDirectoryContext(runtimeComponent.getProduct());
//    Properties p = new Properties();
//    InputStream fis = null;
//    String serverName = null;
//    try {
//      fis = new FileInputStream(customWrapperConf);
//      p.load(fis);
//      String startScriptServerName = p.getProperty(Property_Server_Name_1);
//      String stopScriptServerName = p.getProperty(Property_Server_Name_2);
//      if (startScriptServerName.matches(stopScriptServerName)) {
//        if(!startScriptServerName.matches("\"%WRAPPER_HOSTNAME%\"")) {
//    	  serverName = startScriptServerName;
//    	}
//        else {
//          serverName = ParameterSubstituter.getHostName();	
//        }
//      }
//    } catch (Exception e) {
//        throw new PlatformManagerException(e);
//    }
//
////    serverObjectFactory.setServerName(serverName);
////    return serverObjectFactory;
//
//  }

//  @Override
//  public ConfigurationStatus updateConfiguration(RuntimeComponentEx rc,
//      ConfigurationInstance configurationInstance, Object configurationObject)
//      throws IOException, PlatformManagerException {
//
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//    Servers server = (Servers) configurationObject;
//    String serverName = server.getServerName();
//    File customWrapperConf = AccessCustomWrapperConf
//        .getRootDirectoryContext(runtimeComponent.getProduct());
//    Properties prop = new Properties();
//    InputStream fis = null;
//    FileWriter fileWriter = null;
//
//    try {
//      fis = new FileInputStream(customWrapperConf);
//      prop.load(fis);
//      prop.setProperty(Property_Server_Name_1, serverName);
//      prop.setProperty(Property_Server_Name_2, serverName);
//      fileWriter = new FileWriter(customWrapperConf);
//      for (Map.Entry entry : prop.entrySet()) {
//        fileWriter.write(entry.toString());
//        fileWriter.write("\n");
//      }
//
//      return ConfigurationStatus.PENDING_RESTART;
//    } finally {
//      if (fis != null) {
//        fis.close();
//      }
//
//      if (fileWriter != null) {
//        fileWriter.flush();
//        fileWriter.close();
//      }
//    }
//  }

  @Override
  public ConfigurationInstance createConfiguration(
      RuntimeComponentEx runtimeComponent, Object configurationObject)
      throws IOException, PlatformManagerException {
    throw new UnsupportedOperationException(
        "Creating new servers is not supported");
  }

  @Override
  public ConfigurationStatus deleteConfiguration(
      RuntimeComponentEx runtimeComponent,
      ConfigurationInstance configurationInstance) throws IOException,
      PlatformManagerException {
    throw new UnsupportedOperationException("Deleting servers is not supported");
  }

@Override
public Object loadConfiguration(RuntimeComponentEx arg0, ConfigurationInstance arg1, ConfigurationStatus arg2)
		throws IOException, PlatformManagerException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ConfigurationStatus updateConfiguration(RuntimeComponentEx arg0, ConfigurationInstance arg1, Object arg2)
		throws IOException, PlatformManagerException {
	// TODO Auto-generated method stub
	return null;
}

}
