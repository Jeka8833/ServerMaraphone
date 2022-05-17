package com.jeka8833.servermaraphone;

import com.google.gson.Gson;
import com.jeka8833.servermaraphone.queue.QueryManager;
import com.jeka8833.servermaraphone.queue.Regions;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet(name = "RegionServlet", value = "/region")
public class RegionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(QueryManager.GSON.toJson(
                Arrays.stream(Regions.values()).collect(Collectors.toMap(Regions::name, Regions::getRealName))));
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
