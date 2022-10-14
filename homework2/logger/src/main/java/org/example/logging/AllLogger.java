package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllLogger implements MyLogger {



    private static final Logger logger = LoggerFactory.getLogger(AllLogger.class);

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
