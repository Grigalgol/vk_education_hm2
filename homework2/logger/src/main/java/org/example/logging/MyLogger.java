package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MyLogger {

    void log(String message, String tag);
}
