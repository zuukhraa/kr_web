package ru.itis.servlet;

import ru.itis.helper.HttpClientParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxServlet", urlPatterns = "/busTime")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String garagNumb = request.getParameter("garagNumb");
        String timeBus = new HttpClientParse().getTimeBus(garagNumb);
        response.getWriter().write(timeBus);
        response.setContentType("text/plain");
    }
}
