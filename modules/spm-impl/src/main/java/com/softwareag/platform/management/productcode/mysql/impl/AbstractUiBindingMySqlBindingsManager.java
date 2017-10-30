package com.softwareag.platform.management.productcode.mysql.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.softwareag.platform.management.common.configuration.ConfigurationContentType;
import com.softwareag.platform.management.common.configuration.ConfigurationInstance;
import com.softwareag.platform.management.common.configuration.ConfigurationStatus;
import com.softwareag.platform.management.common.configuration.ConfigurationType;
import com.softwareag.platform.management.common.configuration.dto.CategoryDTO;
import com.softwareag.platform.management.configuration.spi.ConfigurationFactory;
import com.softwareag.platform.management.configuration.spi.ConfigurationManager;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.productcode.mysql.dto.UiBindingMySqlBindingsConfiguration;

public abstract class AbstractUiBindingMySqlBindingsManager implements ConfigurationManager {

	public static String instanceName;

	public static final String CONFIGURATION_INSTANCE_BASE_ID = "MySql"; //$NON-NLS-1$

	private static final int INITIAL_INSTANCE_ID_SUFFIX = 1;

	private transient HashMap<String, UiBindingMySqlBindingsConfiguration> inMemoryConfiguration = new HashMap<>();

	private int stateCounter = INITIAL_INSTANCE_ID_SUFFIX;

	protected abstract String getConfigurationTypeId();

	protected abstract String getConfigurationDisplayPrefix();

	@Override
	public ConfigurationType getConfigurationType() {
		return ConfigurationFactory.createConfigurationType(getConfigurationTypeId(),
				getConfigurationDisplayPrefix() + " UiBinding - MySql", //$NON-NLS-1$
				getConfigurationDisplayPrefix() + " for generic MySql type support by GCUI",
				new CategoryDTO(getConfigurationTypeId(), getConfigurationDisplayPrefix() + " - MySql"), //$NON-NLS-1$ //$NON-NLS-2$
				ConfigurationContentType.XML.value());
	}

	@Override
	public Object loadConfiguration(RuntimeComponentEx runtimeComponent, ConfigurationInstance configurationInstance,
			ConfigurationStatus status) {

			return inMemoryConfiguration.get(configurationInstance.getId());
	}

	@Override
	public ConfigurationStatus updateConfiguration(RuntimeComponentEx runtimeComponent,
			ConfigurationInstance configurationInstance, Object configurationObject) {

		inMemoryConfiguration.put(configurationInstance.getId(),
				(UiBindingMySqlBindingsConfiguration) configurationObject);

		return ConfigurationStatus.CURRENT;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<ConfigurationInstance> getConfigurationInstances(RuntimeComponentEx runtimeComponent) {
		Collection<ConfigurationInstance> configInstances = new ArrayList<>();
		
		
		try {
			//deserialize the file into object  
			FileInputStream fis = new FileInputStream("C:\\CCPluginDevelopment\\plugins\\modules\\spm-impl\\map.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    inMemoryConfiguration = (HashMap<String, UiBindingMySqlBindingsConfiguration>) ois.readObject();
		    ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String configurationInstanceId : inMemoryConfiguration.keySet()) {
			ConfigurationInstance configurationInstance = createConfigurationInstance(runtimeComponent,
					configurationInstanceId);
			configInstances.add(configurationInstance);
		}
		return configInstances;
	}

	@Override
	public ConfigurationInstance createConfiguration(RuntimeComponentEx runtimeComponent, Object configurationObject) {
		if (configurationObject == null) {
			throw new IllegalArgumentException("The provided configuration data can not be null."); //$NON-NLS-1$
		}

		UiBindingMySqlBindingsConfiguration mysqlBinding = (UiBindingMySqlBindingsConfiguration) configurationObject;

//		try {
//			Map<String, Object> map = getFieldNamesAndValues(configurationObject);
//			try {
//				installMySQL();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//		}

		String createdInstanceId = getConfigurationTypeId() + "-"
				+ getConfigurationInstanceBaseId(mysqlBinding.getName()) + stateCounter++;

		ConfigurationInstance configurationInstance = createConfigurationInstance(runtimeComponent, createdInstanceId);

		inMemoryConfiguration.put(configurationInstance.getId(), mysqlBinding);
		try {
			FileOutputStream fos = new FileOutputStream("C:\\CCPluginDevelopment\\plugins\\modules\\spm-impl\\map.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(inMemoryConfiguration);
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Save inMemoryConfigurations in fileSystem

		return configurationInstance;

	}

	private String getConfigurationInstanceBaseId(String mysqlBindingName) {
		if (mysqlBindingName == null) {
			return CONFIGURATION_INSTANCE_BASE_ID;
		}
		return mysqlBindingName;
	}

	@Override
	public ConfigurationStatus deleteConfiguration(RuntimeComponentEx runtimeComponent,
			ConfigurationInstance configurationInstance) {
		UiBindingMySqlBindingsConfiguration deletedInstance = inMemoryConfiguration
				.remove(configurationInstance.getId());
		return (deletedInstance != null) ? ConfigurationStatus.DELETED : ConfigurationStatus.NOT_DELETED;
	}

	private ConfigurationInstance createConfigurationInstance(RuntimeComponentEx runtimeComponent,
			String createdInstanceId) {
		return ConfigurationFactory.createConfigurationInstance(createdInstanceId, runtimeComponent.getId(),
				getConfigurationTypeId(), "Configuration " + createdInstanceId, "Description " + createdInstanceId, //$NON-NLS-1$//$NON-NLS-2$
				null);
	}

	public static Map<String, Object> getFieldNamesAndValues(final Object obj)
			throws IllegalArgumentException, IllegalAccessException {

		UiBindingMySqlBindingsConfiguration mysqlBinding = (UiBindingMySqlBindingsConfiguration) obj;
		Class<? extends Object> c1 = obj.getClass();
		// System.out.println(c1);
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = c1.getDeclaredFields();
		String value = null;
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			// System.out.println(name);

			if (name.equalsIgnoreCase("ServiceName")) {
				value = mysqlBinding.getServiceName();
				instanceName = value;
				// System.out.println(value);
				map.put(name, value);
				System.out.println(map.get(name));
			} else if (name.equalsIgnoreCase("Port")) {
				value = mysqlBinding.getPort();
				// System.out.println(value);
				map.put(name, value);
				System.out.println(map.get(name));
			} else if (name.equalsIgnoreCase("RootPassword")) {
				value = mysqlBinding.getRootPassword();
				// System.out.println(value);
				map.put(name, value);
				System.out.println(map.get(name));
			} else if (name.equalsIgnoreCase("ServerType")) {
				value = mysqlBinding.getServerType();
				// System.out.println(value);
				map.put(name, value);
				System.out.println(map.get(name));

			} else if (name.equalsIgnoreCase("DatabaseType")) {
				value = mysqlBinding.getDatabaseType();
				// System.out.println(value);
				map.put(name, value);
				System.out.println(map.get(name));
			} else if (name.equalsIgnoreCase("Enabled")) {
				boolean value1 = mysqlBinding.getEnabled();
				// System.out.println(value1);
				map.put(name, value1);
				System.out.println(map.get(name));
			} else {
				continue;
			}

		}
		return map;
	}

	public void installMySQL() throws Exception {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
				"msiexec /i \"c:\\CCPluginDevelopment\\mysql-5.5.33-winx64.msi\" /quiet CONSOLEARGS=\"install -type=Server -silent\"");

		builder.redirectErrorStream(true);
		Process p = builder.start();
		Thread.sleep(10000);
		createMySQLService();
	}

	public void createMySQLService() throws Exception {

		String filePath = "C:/Program Files/MySQL/MySQL Server 5.5/bin";
		File f = new File(filePath);
		System.out.println(instanceName);
		String arg[] = { "cmd", "/c", "mysqld --install " + instanceName + " --defaults-file=C:/my-small.ini" };

		ProcessBuilder builder = new ProcessBuilder(arg);
		builder.directory(f);
		Process p = builder.start();

		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}

	}

}
