package com.seavus.calculator;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Calculator")
public class WebCalculator extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        calculateResult(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        calculateResult(request, response);
    }

    private void calculateResult(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("first") != null && req.getParameter("operator") != null && req.getParameter("second") != null) {
            Integer first = Integer.parseInt(req.getParameter("first"));
            String operator = req.getParameter("operator");
            Integer second = Integer.parseInt(req.getParameter("second"));
            Integer result = null;
            if (operator.equals("+")) {
                result = first + second;
            } else if (operator.equals("-")) {
                result = first - second;
            }

            resp.setContentType("text/html");
            if (result != null) {
                resp.getWriter().println("The calculated result is " + result);
            } else {
                resp.getWriter().println("There is error with the given parameters.");
            }
        }
        resp.getWriter().println("All parameters not provided.");
    }
}
