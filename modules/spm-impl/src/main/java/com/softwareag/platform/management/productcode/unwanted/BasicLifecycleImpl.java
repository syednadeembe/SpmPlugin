package com.softwareag.platform.management.productcode.mysql.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.lifecycleoperations.spi.LifecycleOperations;
import com.softwareag.platform.management.productcode.mysql.impl.InstanceRuntimeComponent;
import com.softwareag.platform.management.util.Environment;
import com.softwareag.platform.management.util.PlatformTools;
import com.softwareag.platform.management.util.ProcessExecutionResult;
import com.softwareag.platform.management.util.ProcessTools;

public class BasicLifecycleImpl implements LifecycleOperations {

  @Override
  public void start(RuntimeComponentEx runtimeComponent, String args)
      throws IOException {
    exec(runtimeComponent, "startup");
  }

  @Override
  public void stop(RuntimeComponentEx runtimeComponent, String args)
      throws IOException {
    exec(runtimeComponent, "shutdown");
  }

  @Override
  public void restart(RuntimeComponentEx runtimeComponent, String args)
      throws IOException {
    exec(runtimeComponent, "shutdown");
    exec(runtimeComponent, "startup");
  }

  @Override
  public void startInDebugMode(RuntimeComponentEx runtimeComponent, String args)
      throws IOException {
    throw new UnsupportedOperationException("debugging is not supported");
  }

  private void exec(RuntimeComponentEx runtimeComponent, String scriptName)
      throws IOException {
    File binDir = new File(
        ((InstanceRuntimeComponent) runtimeComponent).getInstanceDir(), "bin");
    String script;

    if (PlatformTools.isWindows()) {
      script = scriptName + ".bat";
    } else {
      script = "./" + scriptName + ".sh";
    }

    if (!(new File(binDir, script).exists())) {
      throw new IllegalArgumentException("Shell script does not exist."); //$NON-NLS-1$
    }

    try {
      Map<String, String> vars = new HashMap<>();
      String javaHome = System.getProperty("java.home");
      vars.put("JAVA_HOME", javaHome); //$NON-NLS-1$ //$NON-NLS-2$
      Environment env = new Environment(vars, false);

      ProcessExecutionResult result = ProcessTools
          .startProcessAndReturnExecutionResult(script, binDir, env);
      if (result.getExitCode() > 0) {
        throw new IOException("Failed to execute " + script + " from "
            + binDir.getAbsolutePath());
      }
    } catch (InterruptedException e) {
      throw new IOException(e);
    }
  }

}
