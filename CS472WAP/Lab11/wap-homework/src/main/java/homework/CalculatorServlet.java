package homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!"".equals(request.getParameterValues("num1")) && request.getParameterValues("num1")!= null
                && !"".equals(request.getParameterValues("num2")) && request.getParameterValues("num2")!= null) {
            Long num1 = Long.parseLong(request.getParameterValues("num1").toString());
            Long num2 = Long.parseLong(request.getParameterValues("num2").toString());
            Long sum = num1 + num2;
            out.println(num1.toString() + " + " + num2.toString() + " = " + sum.toString());
        }
        if (!"".equals(request.getParameterValues("num3")) && request.getParameterValues("num3")!= null
                && !"".equals(request.getParameterValues("num4")) && request.getParameterValues("num4")!= null) {
            Long num3 = Long.parseLong(request.getParameterValues("num3").toString());
            Long num4 = Long.parseLong(request.getParameterValues("num4").toString());
            Long mul = num3 * num4;
            out.println(num3.toString() + " * " + num4.toString() + " = " + mul.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (!"".equals(request.getParameter("num1")) && request.getParameter("num1")!= null
        && !"".equals(request.getParameter("num2")) && request.getParameter("num2")!= null) {
            Long num1 = Long.parseLong(request.getParameter("num1").toString());
            Long num2 = Long.parseLong(request.getParameter("num2").toString());
            Long sum = num1 + num2;
            out.println(num1.toString() + " + " + num2.toString() + " = " + sum.toString());
        }
        if (!"".equals(request.getParameter("num3")) && request.getParameter("num3")!= null
                && !"".equals(request.getParameter("num4")) && request.getParameter("num4")!= null) {
            Long num3 = Long.parseLong(request.getParameter("num3").toString());
            Long num4 = Long.parseLong(request.getParameter("num4").toString());
            Long mul = num3 * num4;
            out.println(num3.toString() + " * " + num4.toString() + " = " + mul.toString());
        }
    }
}