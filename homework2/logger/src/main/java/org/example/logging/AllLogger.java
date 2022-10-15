package org.example.logging;

import org.example.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllLogger implements MyLogger {
    private static final Logger consoleLogger = LoggerFactory.getLogger(ConsoleLoggger.class);
    private static final Logger fileLogger = LoggerFactory.getLogger(FileLogger.class);
    @Override public void log(String message,  String tag) {
        consoleLogger.info("N = " + Application.N++ + " " + message);
        fileLogger.info("N = " + Application.N++ + " " + String.format(tag, message));
    }
}
