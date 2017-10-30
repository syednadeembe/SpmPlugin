package com.softwareag.platform.management.productcode.mysql.runtime;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.softwareag.platform.management.common.exceptions.PlatformManagerException;
import com.softwareag.platform.management.common.monitoring.RuntimeStatus;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.monitoring.spi.RuntimeMonitor;



public class RuntimeMonitorImpl implements RuntimeMonitor {

	@Override
	public RuntimeStatus getRuntimeStatus(RuntimeComponentEx realmServer) throws IOException, PlatformManagerException {
		// TODO
		boolean runtimeStatus = false;
		
		try {
			runtimeStatus = isAlive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (runtimeStatus) {
			
			return RuntimeStatus.ONLINE;
		}
		
		return RuntimeStatus.STOPPED;

	}

	// put this code in try catch 
	public boolean isAlive() throws Exception {
		boolean flag = false;
		String filePath = "C:/Program Files/MySQL/MySQL Server 5.5/bin";
        File f = new File(filePath);
        String arg[] = {"cmd", "/c", "mysqladmin -u root ping"};
        ProcessBuilder builder = new ProcessBuilder(arg);
        builder.directory(f);
        //builder.redirectErrorStream(true);
        Process p = builder.start();
        Thread.sleep(10000);
		
		
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
			if (line.equalsIgnoreCase("mysqld is alive")) {
				System.out.println("Server is Alive");
				flag = true;
			}
		}
		return flag;

	}

}
