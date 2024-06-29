package com.example;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionExample")
public class SessionExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Store a value in the session
        session.setAttribute("username", "JohnDoe");

        // Get the session creation and last accessed times
        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();

        // Check if this is a new session
        if (session.isNew()) {
            response.getWriter().println("This is a new session.");
        } else {
            response.getWriter().println("This is an existing session.");
        }

        // Print session information
        response.getWriter().println("Session ID: " + session.getId());
        response.getWriter().println("Session created: " + new Date(creationTime));
        response.getWriter().println("Last accessed: " + new Date(lastAccessedTime));

        // Retrieve the value stored in the session
        String username = (String) session.getAttribute("username");
        response.getWriter().println("Username: " + username);
    }
}