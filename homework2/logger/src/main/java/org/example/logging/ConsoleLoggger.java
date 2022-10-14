package org.example.logging;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleLoggger implements MyLogger{
    @Inject
    private Logger logger;

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
