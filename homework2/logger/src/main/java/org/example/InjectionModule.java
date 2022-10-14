package org.example;
import com.google.inject.AbstractModule;
import org.example.logging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InjectionModule extends AbstractModule {

    private final String arg;

    public InjectionModule(String arg){
        super();
        this.arg = arg;
    }

    @Override
    protected void configure() {
        switch(arg) {
            case "-f" :
                bind(MyLogger.class).to(FileLogger.class);
                break;
            case "-a" :
                bind(MyLogger.class).to(AllLogger.class);
                break;
            default:
                bind(MyLogger.class).to(ConsoleLoggger.class);
        }

    }
}
