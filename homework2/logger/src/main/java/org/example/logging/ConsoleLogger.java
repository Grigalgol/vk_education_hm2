package org.example.logging;

import org.example.Application;
import org.slf4j.Logger;

public class ConsoleLogger implements MyLogger {

    private Logger logger;

    public ConsoleLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.info("N = " + Application.N++ + " " + message);
    }
}
