package com.StefanAgustoHutapeaJSleepDN;

import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Javadoc
 * @author Stefan Agusto Hutapea
 */

/**
 * The JSleep class is the main entry point for a Spring Boot application.
 * It runs the JsonDBEngine and the SpringApplication, and adds a shutdown hook
 * to gracefully terminate the JsonDBEngine when the application is stopped.
 */
@SpringBootApplication
public class JSleep
{
    /**
     * The main method of the JSleep class.
     *
     * @param args an array of command-line arguments passed to the application
     */
    public static void main(String[] args)
    {
        // Run the JsonDBEngine and the SpringApplication
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        // Add a shutdown hook to gracefully terminate the JsonDBEngine
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            JsonDBEngine.join();
        }));
    }
}