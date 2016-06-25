package rs.edu.viser.logger;

import org.apache.log4j.Logger;

/**
 * Created by neman
 *
 * Used for logging in debug mode. Configurable in log4j.properties.
 */
public class LOG {
    private final Logger logger;

    public LOG(Class<?> cls) {
        this.logger = Logger.getLogger(cls.getName());
    }

    public void info(String msg) {
        if (logger.isDebugEnabled()) {
            logger.info(msg);
        }
    }

    public void warning(String msg) {
        if (logger.isDebugEnabled()) {
            logger.warn(msg);
        }
    }

    public void error(String msg) {
        if (logger.isDebugEnabled()) {
            logger.error(msg);
        }
    }

}
