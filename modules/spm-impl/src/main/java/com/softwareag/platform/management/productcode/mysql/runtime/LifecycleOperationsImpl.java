package com.softwareag.platform.management.productcode.mysql.runtime;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.log4j.Level;

import com.softwareag.platform.management.common.inventory.Category;
import com.softwareag.platform.management.common.monitoring.RuntimeStatus;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.lifecycleoperations.spi.LifecycleOperations;
import com.softwareag.platform.management.productcode.mysql.impl.AbstractUiBindingMySqlBindingsManager;
//import com.softwareag.platform.management.nirvana.LogHandler;
//import com.softwareag.platform.management.nirvana.NirvanaConstants;
//import com.softwareag.platform.management.nirvana.exception.NirvanaSPMException;
//import com.softwareag.platform.management.nirvana.inventory.impl.NirvanaRealmServer;
//import com.softwareag.platform.management.nirvana.manager.NirvanaRealmManager;
//import com.softwareag.platform.management.nirvana.util.CommonUtil;
import com.softwareag.platform.management.util.PlatformTools;
import com.softwareag.platform.management.util.ProcessExecutionResult;
import com.softwareag.platform.management.util.ProcessTools;
import com.webmethods.sc.logging.log4j.WmJournalLogger;


public class LifecycleOperationsImpl implements LifecycleOperations {
	
	
	@Override
	public void restart(RuntimeComponentEx arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(RuntimeComponentEx arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Call Start Command Here");
	//	public boolean start() throws Exception {
			
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "net start "+ AbstractUiBindingMySqlBindingsManager.instanceName);
	//	    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "net start MySQL");

			builder.redirectErrorStream(true);
			Process p = builder.start();
			

	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }  
	}

	@Override
	public void startInDebugMode(RuntimeComponentEx arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(RuntimeComponentEx arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Call Stop Command Here");
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "net stop "+ AbstractUiBindingMySqlBindingsManager.instanceName);
	//	ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "net stop MySQL");

		builder.redirectErrorStream(true);
		Process p = builder.start();
	}


}