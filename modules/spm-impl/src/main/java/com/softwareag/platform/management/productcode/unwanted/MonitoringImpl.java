package com.softwareag.platform.management.productcode.mysql.impl;

import java.io.File;
import java.io.IOException;

import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.common.monitoring.RuntimeState;
import com.softwareag.platform.management.common.monitoring.RuntimeStatus;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.monitoring.spi.ApplicationRuntimeMonitor;
import com.softwareag.platform.management.monitoring.spi.RuntimeMonitor;
import com.softwareag.platform.management.monitoring.spi.RuntimeStateEx;
import com.softwareag.platform.management.monitoring.spi.RuntimeStateFactory;
import com.softwareag.platform.management.monitoring.spi.RuntimeStateMonitor;
//import com.softwareag.platform.management.productcode.mysql.impl.InstanceRuntimeComponent;

public class MonitoringImpl extends ApplicationRuntimeMonitor implements
    RuntimeStateMonitor, RuntimeMonitor {

//  @Override
//  protected File createPidFile(RuntimeComponentEx rc) {
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//    return new File(runtimeComponent.getInstanceDir(), "work/run.pid");
//  }

//  @Override
//  public RuntimeStatus getRuntimeStatus(RuntimeComponentEx arg0) {
//    try {
//      if (isOnline(arg0)) {
//        if (isOnlineMaster(arg0)) {
//          return RuntimeStatus.ONLINE_MASTER;
//        } else {
//          return RuntimeStatus.ONLINE_SLAVE;
//        }
//      }
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//    return super.getRuntimeStatus(arg0);
//  }

//  @Override
//  protected boolean isOnline(final RuntimeComponentEx rc) throws IOException,
//      PlatformManagerException {
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//    try {
//      // call rest API
////      JsonNode stats = parseServerStatistics(getServerStatistics(runtimeComponent));
////      JsonNode entities = stats.get("entities");
//     // String instanceName = entities.get(0).get("sourceId").asText();
//
//      // TODO: Ensure online 
//      return true;
//
//    } catch (Exception e) {
//      return false;
//    }
//  }

//  @Override
//  public RuntimeState getRuntimeState(RuntimeComponentEx rc) {
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//
//    final RuntimeStateEx rs = RuntimeStateFactory.createRuntimeState(runtimeComponent);
////    try {
//////      JsonNode stats = parseServerStatistics(getServerStatistics(runtimeComponent));
//////      JsonNode entities = stats.get("entities");
//////      JsonNode statistics = entities.get(0).get("statistics");
////
//////      rs.addKpi(createLiveObjectCount(statistics));
//////      rs.addKpi(createWriteOperationRate(statistics));
//////      rs.addKpi(createOffheapKpi(statistics));
////
////    } catch (IOException | PlatformManagerException e) {
////      // Ignore
////    }
//
//    return rs;
//  }

//  private boolean isOnlineMaster(final RuntimeComponentEx rc)
//      throws IOException, PlatformManagerException {
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//    TcConfigSerializer tcConfigSerializer = new TcConfigSerializer();
//    TcConfig tcConfig = tcConfigSerializer.loadConfiguration(runtimeComponent);
//    Server server = tcConfigSerializer.loadServerConfiguration(
//        runtimeComponent, tcConfig);
//    URL restApiUrl;
//    if (server.getManagementPort() != null) {
//      restApiUrl = getURL(runtimeComponent, server, true);
//    } else {
//      if (server.getTsaPort() != null) {
//        restApiUrl = getURL(runtimeComponent, server, true);
//      } else {
//        restApiUrl = getURL(runtimeComponent, server, true);
//      }
//    }
//    InputStream content = (InputStream) restApiUrl.getContent();
//    JsonNode stats = parseServerStatistics(content);
//    String serverName = AccessCustomWrapperConf.getServerName(runtimeComponent
//        .getProduct());
//    JsonNode entities = stats.get("entities");
//    for (JsonNode entity : entities) {
//      JsonNode serverGroupEntities = entity.get("serverGroupEntities");
//      for (JsonNode serverGroupEntity : serverGroupEntities) {
//        JsonNode servers = serverGroupEntity.get("servers");
//        for (JsonNode s : servers) {
//          JsonNode attributes = s.get("attributes");
//          if (attributes.get("Name").asText().matches(serverName)) {
//            if (attributes.get("State").asText().matches("ACTIVE-COORDINATOR")) {
//              return true;
//            }
//          }
//        }
//      }
//    }
//    return false;
//  }

@Override
protected File createPidFile(RuntimeComponentEx arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public RuntimeState getRuntimeState(RuntimeComponentEx arg0) {
	// TODO Auto-generated method stub
	InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) arg0;
	RuntimeStateEx rs = RuntimeStateFactory.createRuntimeState(runtimeComponent);
	return rs;
}



@Override
protected boolean isOnline(RuntimeComponentEx arg0) throws IOException, PlatformManagerException {
	// TODO Auto-generated method stub
	return true;
}

//  private URL getURL(InstanceRuntimeComponent runtimeComponent,
//                     Server server, Boolean pathForTopologies) throws IOException, PlatformManagerException {
//    String path;
//    Port port;
//    URL restApiUrl;
//    if (server.getManagementPort() != null) {
//      PortSettings portSettings = (PortSettings) configurationService
//          .loadConfiguration(runtimeComponent.getId(),
//              PortsConfigurationManagerImpl.MANAGEMENT_PORT_INSTANCE_ID,
//              ConfigurationStatus.CURRENT);
//      port = portSettings.getPort().iterator().next();
//    } else {
//      if (server.getTsaPort() != null) {
//        PortSettings portSettings = (PortSettings) configurationService
//            .loadConfiguration(runtimeComponent.getId(),
//                PortsConfigurationManagerImpl.TSA_PORT_INSTANCE_ID,
//                ConfigurationStatus.CURRENT);
//        port = portSettings.getPort().iterator().next();
//        if (port.getBindAddress() == null) {
//          port.setBindAddress("localhost");
//        }
//        port.setNumber(server.getTsaPort().getValue() + 30);
//      } else {
//        port = new Port();
//        port.setNumber(9540);
//      }
//    }
//
//    if (port.getBindAddress() == null) {
//      port.setBindAddress("localhost");
//    }
//
//    if (pathForTopologies) {
//      path = "/tc-management-api/v2/agents/topologies";
//    } else {
//      String serverName = AccessCustomWrapperConf
//          .getServerName(runtimeComponent.getProduct());
//      path = "/tc-management-api/v2/agents/statistics/servers;names="
//          + serverName;
//    }
//
//    restApiUrl = new URL("http", port.getBindAddress(), port.getNumber(), path);
//    return restApiUrl;
//  }

//  private InputStream getServerStatistics(final RuntimeComponentEx rc)
//      throws IOException, PlatformManagerException {
//    InstanceRuntimeComponent runtimeComponent = (InstanceRuntimeComponent) rc;
//    TcConfigSerializer tcConfigSerializer = new TcConfigSerializer();
//    TcConfig tcConfig = tcConfigSerializer.loadConfiguration(runtimeComponent);
//    Server server = tcConfigSerializer.loadServerConfiguration(
//        runtimeComponent, tcConfig);
//    URL restApiUrl;
//
//    if (server.getManagementPort() != null) {
//      restApiUrl = getURL(runtimeComponent, server, false);
//    } else {
//      if (server.getTsaPort() != null) {
//        restApiUrl = getURL(runtimeComponent, server, false);
//      } else {
//        restApiUrl = getURL(runtimeComponent, server, false);
//      }
//    }
//    return (InputStream) restApiUrl.getContent();
//  }
//
//  JsonNode parseServerStatistics(InputStream inputStream) throws IOException {
//    ObjectMapper mapper = new ObjectMapper();
//    return mapper.readTree(inputStream);
//  }

//  KpiValue createLiveObjectCount(JsonNode statistics) {
//    long count = statistics.get("LiveObjectCount").asLong();
//    String value = String.valueOf(count);
//    //Setting it 1 higher than the actual value so that warning is never displayed
//    String waterMark = String.valueOf(count + 1);
//
//    return RuntimeStateFactory.createKpi("LiveObjectCount", "Live Object Count", value,
//        "Objects", waterMark, waterMark, waterMark);
//  }
//
//  KpiValue createWriteOperationRate(JsonNode statistics) {
//    long rate = statistics.get("WriteOperationRate").asLong();
//    String value = String.valueOf(rate);
//    //Setting it 1 higher than the actual value so that warning is never displayed
//    String waterMark = String.valueOf(rate + 1);
//
//    return RuntimeStateFactory.createKpi("WriteOperationRate", "Write Operation Rate",
//        value, "Writes", waterMark, waterMark, waterMark);
//  }
//
//  KpiValue createOffheapKpi(JsonNode statistics) {
//    long offheapUsed = statistics.get("OffheapUsedSize").asLong();
//    long offheapMax = statistics.get("OffheapMaxSize").asLong();
//    String offheapMarginal = String.valueOf((offheapMax / 100) * 80);
//    String offheapCritical = String.valueOf((offheapMax / 100) * 90);
//
//    return RuntimeStateFactory.createKpi("OFFHEAP", "Offheap", String.valueOf(offheapUsed),
//        "KB", String.valueOf(offheapMax), offheapMarginal, offheapCritical);
//  }
}
