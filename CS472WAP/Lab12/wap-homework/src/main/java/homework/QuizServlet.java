package homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String outHtml = "";
        outHtml += "<!DOCTYPE html>";
        outHtml += "<html lang=\"en\">";
        outHtml += "";
        outHtml += "<head>";
        outHtml += "    <meta charset=\"UTF-8\">";
        outHtml += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
        outHtml += "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">";
        outHtml += "    <title>The Number Quiz</title>";
        outHtml += "</head>";
        outHtml += "";
        outHtml += "<body>";
        outHtml += "    <h1>The Number Quiz</h1>";
        outHtml += "    <p>Your current score is " + request.getSession().getAttribute("score") + ".</p>";
        outHtml += "    <p>Guess the next number in the sequence.</p>";
        outHtml += "    <form action=\"CalcPro\" method=\"POST\">";
        outHtml += "outHtml + = \"<label>Your ansewer: </label><input type=\"number\" id=\"ans\" name=\"ans\" /> ";
        outHtml += "outHtml + = \"<input type=\"submit\" id=\"submit\" name=\"submit\" value=\"submit\" />";
        outHtml += "    </form>";
        outHtml += "</body>";
        outHtml += "";
        outHtml += "</html>";
        request.getSession().setAttribute("question", Quiz.);
        if (!"".equals(request.getParameter("num1")) && request.getParameter("num1")!= null) {
            Long num1 = Long.parseLong(request.getParameter("num1").toString());
            Long num2 = Long.parseLong(request.getParameter("num2").toString());
            Long sum = num1 + num2;
            out.println(num1.toString() + " + " + num2.toString() + " = " + sum.toString());
        }
        out.println(outHtml);
    }
}