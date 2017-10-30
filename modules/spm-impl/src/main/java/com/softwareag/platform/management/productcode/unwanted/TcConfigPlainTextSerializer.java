package com.softwareag.platform.management.productcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.softwareag.platform.management.common.configuration.ConfigurationSource;
import com.softwareag.platform.management.configuration.common.serializer.ConfigurationSourceFactory;
import com.softwareag.platform.management.configuration.common.serializer.PlainTextConfigurationSerializer;
import com.softwareag.platform.management.productcode.InstanceRuntimeComponent;

public class TcConfigPlainTextSerializer extends
		PlainTextConfigurationSerializer {

	public Object loadConfiguration(InstanceRuntimeComponent runtimeComponent)
			throws FileNotFoundException, IOException {
		File tcConfigFile = new File(runtimeComponent.getInstanceDir(),
				"conf/tc-config.xml");
		return deserialize(ConfigurationSourceFactory
				.createConfigurationSource(new FileInputStream(tcConfigFile),
						"UTF-8"));
	}

	public void saveConfiguration(InstanceRuntimeComponent runtimeComponent,
			Object configurationObject) throws FileNotFoundException,
			IOException {

		ConfigurationSource confFile = ConfigurationSourceFactory
				.createConfigurationSource(configurationObject, "UTF-8");
		String content = serialize(confFile);

		File tcConfigFile = new File(runtimeComponent.getInstanceDir(),
				"conf/tc-config.xml");
		FileWriter fw = new FileWriter(tcConfigFile);
		fw.write(content);
		if (fw != null) {
			fw.close();
		}
	}
}
