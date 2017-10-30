package com.softwareag.platform.management.productcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

//import org.terracotta.config.MirrorGroup;
//import org.terracotta.config.Server;
//import org.terracotta.config.TcConfig;

import com.softwareag.platform.management.common.configuration.ConfigurationSource;
import com.softwareag.platform.management.configuration.common.serializer.ConfigurationSourceFactory;
import com.softwareag.platform.management.configuration.common.serializer.XmlConfigurationSerializer;
//import com.softwareag.platform.management.plugins.tc.inventory.AccessCustomWrapperConf;
//import com.softwareag.platform.management.plugins.tc.inventory.InstanceRuntimeComponent;
//import com.softwareag.platform.management.plugins.tc.logaccess.ParameterSubstituter;

public class TcConfigSerializer extends XmlConfigurationSerializer {

//  @Override
//  public Class<?> getConfigurationObjectClass() {
//    return org.terracotta.config.TcConfig.class;
//  }
//
//  @Override
//  protected InputStream getValidatingSchemaStream() {
//    return this.getClass().getResourceAsStream("/tc-config.xsd");
//  }

//  public TcConfig loadConfiguration(InstanceRuntimeComponent runtimeComponent)
//      throws FileNotFoundException, IOException {
//    File tcConfigFile = new File(runtimeComponent.getInstanceDir(),
//        "conf/tc-config.xml");
//    TcConfig tcConfig = (TcConfig) deserialize(ConfigurationSourceFactory
//        .createConfigurationSource(new FileInputStream(tcConfigFile), "UTF-8"));
//    return tcConfig;
//  }

//  public Server loadServerConfiguration(
//      InstanceRuntimeComponent runtimeComponent, TcConfig tcConfig)
//      throws FileNotFoundException, IOException {
//
//    String configuredServerName = AccessCustomWrapperConf
//        .getServerName(runtimeComponent.getProduct());
//    // check mirror groups first
//    if (!tcConfig.getServers().getMirrorGroup().isEmpty()) {
//      for (MirrorGroup mirrorGroup : tcConfig.getServers().getMirrorGroup()) {
//        for (Server server : mirrorGroup.getServer()) {
//          if (configuredServerName.equals(ParameterSubstituter.substitute(server.getName()))) {
//            return server;
//          }
//        }
//      }
//    }
//    // if not found, check server list
//    else {
//      for (Server server : tcConfig.getServers().getServer()) {
//        if (configuredServerName.equals(ParameterSubstituter.substitute(server.getName()))) {
//          return server;
//        }
//      }
//    }
//    return null;
//  }
//  
//  public void saveConfiguration (InstanceRuntimeComponent runtimeComponent, Object configurationObject) throws FileNotFoundException, IOException {
//	  ConfigurationSource confFile = ConfigurationSourceFactory.createConfigurationSource(configurationObject, "UTF-8");
//	  String content = serialize(confFile);
//	  
//	  File tcConfigFile = new File(runtimeComponent.getInstanceDir(),
//		        "conf/tc-config.xml");
//	  FileWriter fw = new FileWriter(tcConfigFile);
//	  fw.write(content);
//	  if (fw != null) {
//		  fw.close();
//	  }
//  }
}