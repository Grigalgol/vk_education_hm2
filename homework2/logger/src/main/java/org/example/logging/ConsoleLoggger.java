package org.example.logging;

import com.google.inject.Inject;
import org.example.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleLoggger implements MyLogger{
    private Logger logger = LoggerFactory.getLogger(ConsoleLoggger.class);
    @Override
    public void log(String message,  String tag) {
        logger.info("N = " + Application.N++ + " " + message);
    }
}
