package com.Lab01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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

        LoginModel model = new LoginModel();

        if(model.isValidData(login, pass)) {
            request.setAttribute("Title", "Welcome");
            request.setAttribute("Body", "Welcome back, "+ login);
        } else {
            request.setAttribute("Title", "Error logging");
            request.setAttribute("Body", "Error with logging");
        }

        request.getRequestDispatcher("/logged.jsp").forward(request, response);
    }

}
