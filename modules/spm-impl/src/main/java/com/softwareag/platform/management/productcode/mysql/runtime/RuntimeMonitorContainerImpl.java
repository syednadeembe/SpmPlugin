package com.softwareag.platform.management.productcode.mysql.runtime;

import java.io.IOException;



import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.common.monitoring.RuntimeStatus;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.monitoring.spi.RuntimeMonitor;
//import com.softwareag.platform.management.nirvana.LogHandler;
//import com.softwareag.platform.management.nirvana.inventory.impl.NirvanaRealmServer;
//import com.softwareag.platform.management.nirvana.manager.NirvanaRealmManager;


/**
 * Implementation of RuntimeMonitor for Nirvana. If returns the status of Nirvana Realm server default interface.
 * 
 * @author nkan
 * 
 */
public class RuntimeMonitorContainerImpl  implements RuntimeMonitor {

//	private static final WmJournalLogger _logger = LogHandler.getLogger(RuntimeMonitorImpl.class);

	@Override
	public RuntimeStatus getRuntimeStatus(RuntimeComponentEx realmServer) throws IOException, PlatformManagerException {
		// TODO
		
		
		
		return RuntimeStatus.ONLINE_MASTER;
		
	}
	
	
}
