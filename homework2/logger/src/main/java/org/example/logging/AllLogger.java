package org.example.logging;

import org.example.Application;
import org.slf4j.Logger;

public class AllLogger implements MyLogger {
    private final Logger consoleLogger;
    private final Logger fileLogger;
    private final String tag;

    public AllLogger(Logger consoleLogger, Logger fileLogger, String tag) {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
        this.tag = "<" + tag + ">%s</" + tag + ">";
    }

    @Override
    public void log(String message) {
        consoleLogger.info("N = " + Application.N++ + " " + message);
        fileLogger.info("N = " + Application.N++ + " " + String.format(tag, message));
    }
}
