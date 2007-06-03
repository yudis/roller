/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */

package org.apache.roller.weblogger.business.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.roller.RollerException;
import org.apache.roller.weblogger.business.RollerImpl;
import org.apache.roller.weblogger.business.BookmarkManager;
import org.apache.roller.weblogger.business.FileManager;
import org.apache.roller.weblogger.business.PluginManager;
import org.apache.roller.weblogger.business.pings.AutoPingManager;
import org.apache.roller.weblogger.business.pings.PingQueueManager;
import org.apache.roller.weblogger.business.pings.PingTargetManager;
import org.apache.roller.weblogger.business.PropertiesManager;
import org.apache.roller.weblogger.business.referrers.RefererManager;
import org.apache.roller.weblogger.business.UserManager;
import org.apache.roller.weblogger.business.WeblogManager;
import org.apache.roller.weblogger.business.runnable.ThreadManager;
import org.apache.roller.weblogger.business.search.IndexManager;
import org.apache.roller.weblogger.business.themes.ThemeManager;


/**
 * A Hibernate specific implementation of the Roller business layer.
 */
public class HibernateRollerImpl extends RollerImpl {    
    static final long serialVersionUID = 5256135928578074652L;
    private static Log mLogger = LogFactory.getLog(HibernateRollerImpl.class);    
    
    // a persistence utility class
    private HibernatePersistenceStrategy strategy = null;
    
    @com.google.inject.Inject
    public HibernateRollerImpl(
        HibernatePersistenceStrategy strategy,
        AutoPingManager   autoPingManager,
        BookmarkManager   bookmarkManager,
        FileManager       fileManager,
        IndexManager      indexManager,
        PingQueueManager  pingQueueManager,
        PingTargetManager pingTargetManager,
        PluginManager     pluginManager,
        PropertiesManager propertiesManager,
        RefererManager    refererManager,
        ThemeManager      themeManager,
        ThreadManager     threadManager,
        UserManager       userManager,
        WeblogManager     weblogManager) throws RollerException {
        
        super(
            autoPingManager,
            bookmarkManager,
            fileManager,
            indexManager,
            pingQueueManager,
            pingTargetManager,
            pluginManager,
            propertiesManager,
            refererManager,
            themeManager,
            threadManager,
            userManager,
            weblogManager); 
        this.strategy = strategy;
    }
        
    public void flush() throws RollerException {
        this.strategy.flush();
    }    
}

