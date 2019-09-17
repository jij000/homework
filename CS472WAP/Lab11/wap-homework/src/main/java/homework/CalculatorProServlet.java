package homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorProServlet")
public class CalculatorProServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String outStr = "<form action=\"CalcPro\" method=\"POST\">\n";
        if (!"".equals(request.getParameterValues("num1")) && request.getParameterValues("num1") != null
                && !"".equals(request.getParameterValues("num2")) && request.getParameterValues("num2") != null) {
            Long num1 = Long.parseLong(request.getParameterValues("num1")[0]);
            Long num2 = Long.parseLong(request.getParameterValues("num2")[0]);
            Long sum = num1 + num2;
            outStr += "        <input type=\"number\" id=\"num1\" name=\"num1\" value=\"" + num1.toString() + "\"/> +\n" +
                    "        <input type=\"number\" id=\"num2\" name=\"num2\" value=\"" + num2.toString() + "\"/> =\n" +
                    "        <input type=\"number\" id=\"sum\" name=\"sum\" value=\"" + sum.toString() + "\"/> <br />\n";
        }
        if (!"".equals(request.getParameterValues("num3")) && request.getParameterValues("num3") != null
                && !"".equals(request.getParameterValues("num4")) && request.getParameterValues("num4") != null) {
            Long num3 = Long.parseLong(request.getParameterValues("num3")[0]);
            Long num4 = Long.parseLong(request.getParameterValues("num4")[0]);
            Long mul = num3 * num4;
            outStr += "        <input type=\"number\" id=\"num3\" name=\"num3\" value=\"" + num3.toString() + "\" /> *\n" +
                    "        <input type=\"number\" id=\"num4\" name=\"num4\" value=\"" + num4.toString() + "\" /> =\n" +
                    "        <input type=\"number\" id=\"mul\" name=\"mul\" value=\"" + mul.toString() + "\"/> <br />\n";
        }
        outStr += "        <input type=\"submit\" id=\"submit\" name=\"submit\" value=\"submit\" />\n" +
                "    </form>";
        out.println(outStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String outStr = "<form action=\"CalcPro\" method=\"POST\">\n";
        if (!"".equals(request.getParameter("num1")) && request.getParameter("num1") != null
                && !"".equals(request.getParameter("num2")) && request.getParameter("num2") != null) {
            Long num1 = Long.parseLong(request.getParameter("num1").toString());
            Long num2 = Long.parseLong(request.getParameter("num2").toString());
            Long sum = num1 + num2;
            outStr += "        <input type=\"number\" id=\"num1\" name=\"num1\" value=\"" + num1.toString() + "\"/> +\n" +
                    "        <input type=\"number\" id=\"num2\" name=\"num2\" value=\"" + num2.toString() + "\"/> =\n" +
                    "        <input type=\"number\" id=\"sum\" name=\"sum\" value=\"" + sum.toString() + "\"/> <br />\n";
        }
        if (!"".equals(request.getParameter("num3")) && request.getParameter("num3") != null
                && !"".equals(request.getParameter("num4")) && request.getParameter("num4") != null) {
            Long num3 = Long.parseLong(request.getParameter("num3").toString());
            Long num4 = Long.parseLong(request.getParameter("num4").toString());
            Long mul = num3 * num4;
            outStr += "        <input type=\"number\" id=\"num3\" name=\"num3\" value=\"" + num3.toString() + "\" /> *\n" +
                    "        <input type=\"number\" id=\"num4\" name=\"num4\" value=\"" + num4.toString() + "\" /> =\n" +
                    "        <input type=\"number\" id=\"mul\" name=\"mul\" value=\"" + mul.toString() + "\"/> <br />\n";
        }
        outStr += "        <input type=\"submit\" id=\"submit\" name=\"submit\" value=\"submit\" />\n" +
                "    </form>";
        out.println(outStr);
    }
}