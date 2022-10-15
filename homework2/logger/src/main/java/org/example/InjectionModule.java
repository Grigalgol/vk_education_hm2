package org.example;

import com.google.inject.AbstractModule;
import org.example.logging.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

public final class InjectionModule extends AbstractModule {

    private final String[] args;

    public InjectionModule(@NotNull String[] args) {
        super();
        this.args = args;
    }

    @Override
    protected void configure() {
        switch (args[0]) {
            case "-c":
                bind(MyLogger.class).toInstance(new ConsoleLogger(LoggerFactory.getLogger(ConsoleLogger.class)));
                break;

            case "-f":
                if (args.length != 2) throw new IllegalArgumentException("Tag not found");
                bind(MyLogger.class).toInstance(new FileLogger(LoggerFactory.getLogger(FileLogger.class), args[1]));
                break;

            case "-a":
                if (args.length != 2) throw new IllegalArgumentException("Tag not found");
                bind(MyLogger.class).toInstance(new AllLogger(
                        LoggerFactory.getLogger(ConsoleLogger.class),
                        LoggerFactory.getLogger(FileLogger.class), args[1]));
                break;

            default:
                throw new IllegalArgumentException("No such argument");
        }

    }
}
