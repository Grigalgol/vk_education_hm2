package org.example.logging;


import org.example.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileLogger implements MyLogger{

    private static final Logger logger = LoggerFactory.getLogger(FileLogger.class);
    @Override
    public void log(String message,  String tag) {
        logger.info("N = " + Application.N++ + " " + String.format(tag, message));
    }
}
