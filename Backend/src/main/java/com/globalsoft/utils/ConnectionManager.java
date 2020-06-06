package com.globalsoft.utils;

import com.zaxxer.hikari.HikariConfig;
import javax.sql.DataSource;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karan
 */
@Component
public class ConnectionManager {

    private static HikariDataSource dataSource;

    private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());
    private ConnectionManager() {
        try {
            String hikariCpConfigLocation = PropertyReader.getValue("finapp.connectionpool.hikaricp.config.location");
            HikariConfig cfg = new HikariConfig(hikariCpConfigLocation);
            dataSource = new HikariDataSource(cfg);

            String minIdle = PropertyReader.getValue("finapp.connectionpool.hikaricp.min.idle");

            String maxPoolSize = PropertyReader.getValue("finapp.connectionpool.hikaricp.max.pool.size");

            LOGGER.log(Level.INFO, "minIdle from conf file: " + minIdle);
            LOGGER.log(Level.INFO, "maxPoolSize from conf file: " + maxPoolSize);
            int minIdleI = 50;
            int maxPoolSizeI = 150;

            if (minIdle != null && minIdle.trim().length() > 0) {
                try {
                    minIdleI = Integer.parseInt(minIdle);
                } catch (Exception e) {
                    minIdleI = 50;
                }
            }

            if (maxPoolSize != null && maxPoolSize.trim().length() > 0) {
                try {
                    maxPoolSizeI = Integer.parseInt(maxPoolSize);
                } catch (Exception e) {
                    maxPoolSizeI = 150;
                }
            }

            LOGGER.log(Level.INFO, "minIdle finally: " + minIdle);
            LOGGER.log(Level.INFO, "maxPoolSize finally: " + maxPoolSize);
            
            dataSource.setMinimumIdle(minIdleI);
            dataSource.setMaximumPoolSize(maxPoolSizeI);//The maximum number of connections, idle or busy, that can be present in the pool.
            //dataSource.setAutoCommit(false);
            dataSource.setLoginTimeout(3);
        } catch (Exception e) {
        	LOGGER.log(Level.SEVERE, "Error in ConnectionManager:", e);
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Singleton Helper, only loads when required
     */
    private static class SingletonHelper {
        private static final ConnectionManager INSTANCE = new ConnectionManager();
    }

    /**
     * Thread safe get Instance implementation
     *
     * @return
     */
    public static synchronized ConnectionManager getConnectionManager() {
        return SingletonHelper.INSTANCE;
    }
}
