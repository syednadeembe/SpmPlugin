/*
* Copyright (c) 2011-2017 Software AG, Darmstadt, Germany and/or Software AG USA Inc., Reston, VA, USA, and/or its subsidiaries and/or its affiliates and/or their licensors.
*
* Use, reproduction, transfer, publication or disclosure is prohibited except as specifically provided for in your License Agreement with Software AG.
*/
package com.softwareag.platform.management.productcode.mysql.runtime;

/**
* Provides allowed statuses of a runtime component.
*/
public enum RuntimeStatus {
               /**
               * The state cannot be determined 
                */
               UNKNOWN,
               
               /**
               * Component is starting
               */
               STARTING,
               
               /**
               * Component is online
               */
               ONLINE,
               
               /**
     * Component is paused
     */
    PAUSED,

               /**
               * Component is running but unresponsive
               */
               UNRESPONSIVE,

               /**
               * Component failed or crashed
               */
               FAILED,
               
               /**
     * Component detected fatal errors 
     */
    ERROR,

               /**
               * Component is stopping
               */
               STOPPING,
               
               /**
               * Component is not running
               */
               STOPPED,
               
               /**
               * Component is online in MASTER role
               * @since 1.1
               */
               ONLINE_MASTER,
               
               /**
               * Component is online in SLAVE role
               * @since 1.1
               */
               ONLINE_SLAVE,
               
               /**
               * Component is started but not ready yet to accept client requests.
               * Typically this indicates some prolong internal initialization state which eventually should change to ONLINE_XXX status.
               * Sometimes client action is required, for example configuring the component.
               * This behavior is component specific.
               * @since 1.3
               */
               NOT_READY; 
               
               /**
               * Whether the component runtime status is {@link #ONLINE}, {@link #ONLINE_MASTER} or {@link #ONLINE_SLAVE}
               * @return Whether the component runtime status is {@link #ONLINE}, {@link #ONLINE_MASTER} or {@link #ONLINE_SLAVE}
               */
               public boolean isOnline() { 
                   return this == ONLINE || this == ONLINE_MASTER || this == ONLINE_SLAVE;
               }

}
