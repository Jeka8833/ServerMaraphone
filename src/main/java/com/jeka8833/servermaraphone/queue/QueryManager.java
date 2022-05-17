package com.jeka8833.servermaraphone.queue;

import com.google.gson.Gson;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.*;

public class QueryManager implements ServletContextListener {

    public static final Gson GSON = new Gson();
    private static final Random RANDOM = new Random();
    public static final Set<Request> REQUEST_LIST = new HashSet<>();

    public static boolean addRequest(String phoneNumber, Regions region, String pvo) {
        var newRequest = new Request(RANDOM.nextLong(), phoneNumber, region, pvo, ProcessStatus.WAITED);
        if (REQUEST_LIST.contains(newRequest)) return false;

        REQUEST_LIST.add(newRequest);
        return true;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("CarregarBot initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
