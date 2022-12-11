package com.StefanAgustoHutapeaJSleepDN;

import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Proyek Akhir
 * Stefan Agusto Hutapea
 * 2106700744
 */

@SpringBootApplication
public class JSleep
{   
    public static void main(String[] args)
    {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            JsonDBEngine.join();
        }));
    }
}