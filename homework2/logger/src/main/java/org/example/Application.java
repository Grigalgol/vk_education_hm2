package org.example;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.example.logging.MyLogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Application {

    @Inject
    private MyLogger logger;

    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new InjectionModule(args[0]));
        injector.getInstance(Application.class).waitForInput();
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String message = scanner.nextLine();
                logger.log(message);

            }
        } catch (IllegalStateException | NoSuchElementException e) {

        }
    }

}
