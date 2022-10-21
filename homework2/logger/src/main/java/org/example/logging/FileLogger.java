package org.example.logging;

import org.example.Application;
import org.slf4j.Logger;

public class FileLogger implements MyLogger {
    private final Logger logger;
    private final String tag;

    public FileLogger(Logger logger, String tag) {
        this.logger = logger;
        this.tag = "<" + tag + ">%s</" + tag + ">";
    }

    @Override
    public void log(String message) {
        logger.info("N = " + Application.N++ + " " + String.format(tag, message));
    }
}
