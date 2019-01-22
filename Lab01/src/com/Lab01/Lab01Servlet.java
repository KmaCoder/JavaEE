package com.Lab01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Lab01Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("Title", "Login Page");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if(login.equals("admin") && pass.equals("admin")) {
            request.setAttribute("Title", "Welcome");
            request.setAttribute("Body", "Welcome back, "+ login);
        } else {
            request.setAttribute("Title", "Error logging");
            request.setAttribute("Body", "Error with logging");
        }

        request.getRequestDispatcher("/logged.jsp").forward(request, response);
    }

}
