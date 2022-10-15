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

    public static int N;

    public static void main(@NotNull String[] args) {
        String tag = "";

        if (!args[0].equals("-c") && !args[0].equals("-f") && !args[0].equals("-a")) {
            throw new IllegalArgumentException("This argument is not exits");
        }
        if (args[0].equals("-f") || args[0].equals("-a")) {
            if (args.length != 2) {
                throw new IllegalArgumentException("Tag is not exits");
            }
            tag = "<" + args[1] + ">%s</" + args[1] + ">";
        }

        final Injector injector = Guice.createInjector(new InjectionModule(args[0]));
        injector.getInstance(Application.class).waitForInput(tag);
    }

    public void waitForInput(String tag) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String message = scanner.nextLine();
                logger.log(message, tag);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
        }
    }

}
