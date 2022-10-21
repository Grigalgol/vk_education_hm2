package org.example;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.example.logging.MyLogger;
import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Application {

    @Inject
    private MyLogger logger;

    public static int N;

    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new InjectionModule(args));
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
