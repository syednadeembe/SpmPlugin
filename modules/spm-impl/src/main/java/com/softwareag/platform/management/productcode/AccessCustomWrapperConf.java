package com.softwareag.platform.management.productcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import com.softwareag.platform.management.inventory.spi.ProductEx;
import com.softwareag.platform.management.productcode.ParameterSubstituter;

public class AccessCustomWrapperConf {
  private static String Property_Server_Name_1 = "wrapper.app.parameter.6";
  private static String Property_Server_Name_2 = "wrapper.app.parameter.13";
  private static String DEFAULT_SERVER_NAME = "%WRAPPER_HOSTNAME%";

  public static File getRootDirectoryContext(ProductEx product) {
    String path = "Terracotta" + File.separator + "server" + File.separator
        + "wrapper" + File.separator + "conf" + File.separator
        + "custom_wrapper.conf";
    File customConf = new File(product.getSuiteInstallDirectory(), path);
    if (!customConf.exists()) {
      try {
        writeCustomWrapperConf(customConf);
      } catch (IOException e) {

      }

    }
    return new File(product.getSuiteInstallDirectory(), path);
  }

  public static String readCustomWrapperConf(File customWrapperConf) {
    Properties props = new Properties();
    String serverName = null;
    InputStream fis = null;
    try {
      fis = new FileInputStream(customWrapperConf);
      props.load(fis);
      serverName = props.getProperty(Property_Server_Name_1);
    } catch (Exception e) {

    }
    return serverName;
  }

  private static void writeCustomWrapperConf(File customWrapperConf)
      throws IOException {
    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter(customWrapperConf);
      fileWriter.write(Property_Server_Name_1 + "=" + DEFAULT_SERVER_NAME);
      fileWriter.write("\n");
      fileWriter.write(Property_Server_Name_2 + "=" + DEFAULT_SERVER_NAME);
    } finally {
      if (fileWriter != null) {
        fileWriter.flush();
        fileWriter.close();
      }
    }
  }

  public static String getServerName(ProductEx product) {
    if(!readCustomWrapperConf(getRootDirectoryContext(product)).matches("\"%WRAPPER_HOSTNAME%\""))
	  return readCustomWrapperConf(getRootDirectoryContext(product));
    return ParameterSubstituter.getHostName();
  }
}
