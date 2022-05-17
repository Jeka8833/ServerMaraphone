package com.jeka8833.servermaraphone;

import com.jeka8833.servermaraphone.queue.ProcessStatus;
import com.jeka8833.servermaraphone.queue.QueryManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            response.getWriter().write("{\"success\":false, \"message\":\"Name is empty\"}");
        } else {
            try {
                int requestID = Integer.parseInt(request.getParameter("request"));
                int state = Integer.parseInt(request.getParameter("state"));

                QueryManager.REQUEST_LIST.stream()
                        .filter(request1 -> request1.getId() == requestID).findFirst()
                        .ifPresent(r -> {
                            r.setStatus(switch (state) {
                                case 1 -> ProcessStatus.PROCESSED;
                                case 2 -> ProcessStatus.CLOSED;

                                default -> ProcessStatus.WAITED;
                            });
                            if (state == 1)
                                r.setManagerName(name);
                            else
                                r.setManagerName(null);
                        });
                response.getWriter().write("{\"success\":true}");
            } catch (Exception exception) {
                response.getWriter().write("{\"success\":false, \"message\":\"RequestID or state incorrect\"}");
            }
        }
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
