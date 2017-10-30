package com.softwareag.platform.management.productcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.softwareag.platform.management.common.inventory.Category;
import com.softwareag.platform.management.inventory.spi.Inventory;
import com.softwareag.platform.management.inventory.spi.ProductEx;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentEx;
import com.softwareag.platform.management.inventory.spi.RuntimeComponentFactory;

public class InventoryImpl implements Inventory {

    private List<RuntimeComponentEx> components = new ArrayList<>();

    @Override
    public Collection<RuntimeComponentEx> getRuntimeComponents(ProductEx product) {
        components.clear(); 

        RuntimeComponentEx sdkProcess = RuntimeComponentFactory.createProcess(product, product.getId() + "-process", "Cloud Extension - Container"); //$NON-NLS-1$ //$NON-NLS-2$
        components.add(sdkProcess);
        
//        RuntimeComponentEx sdkEngine = RuntimeComponentFactory.createRuntimeComponent(product, product.getId() + "-saltEngine", "Cloud Extension for Salt - SaltEngine", //$NON-NLS-1$ //$NON-NLS-2$
//                Category.ENGINE, sdkProcess.getId());
//           
//            RuntimeComponentEx sdkEngine2 = RuntimeComponentFactory.createRuntimeComponent(product, product.getId() + "-jenkinsEngine", "Cloud Extension for Jenkins - JenkinsEngine", //$NON-NLS-1$ //$NON-NLS-2$
//                    Category.ENGINE, sdkProcess.getId());
            
            RuntimeComponentEx sdkEngine3 = RuntimeComponentFactory.createRuntimeComponent(product, product.getId() + "-MySql", "Command Central Extension for MySql - MySqlEngine", //$NON-NLS-1$ //$NON-NLS-2$
                    Category.ENGINE, sdkProcess.getId());
        
//        components.add(sdkEngine);
//        components.add(sdkEngine2);
        components.add(sdkEngine3);
        

        return Collections.unmodifiableList(components);
    }
}
