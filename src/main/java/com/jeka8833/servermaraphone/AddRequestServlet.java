package com.jeka8833.servermaraphone;

import com.jeka8833.servermaraphone.queue.ProcessStatus;
import com.jeka8833.servermaraphone.queue.QueryManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddRequestServlet", value = "/add")
public class AddRequestServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String phone = request.getParameter("phone");
        String region = request.getParameter("region");
        String vpo = request.getParameter("vpo");


        response.getWriter().write("{\"success\":false, \"message\":\"RequestID or state incorrect\"}");
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
