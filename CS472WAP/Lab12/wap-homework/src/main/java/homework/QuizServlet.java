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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

        Quiz quiz = null;
        if (request.getSession().getAttribute("quiz") == null) {
            quiz = new Quiz();
        } else {
            quiz = (Quiz) request.getSession().getAttribute("quiz");
        }
        int qIndex;
        if (request.getSession().getAttribute("qIndex") != null) {
            qIndex = (Integer) request.getSession().getAttribute("qIndex");
            if (qIndex == -1) {
                quiz = new Quiz(); // reset
            } else {
                if (!"".equals(request.getParameter("ans")) && request.getParameter("ans") != null) {
                    int ans = Integer.valueOf(request.getParameter("ans").toString());
                    if (ans == Quiz.answers[qIndex]) {
                        quiz.addScore();
                    }
                }
            }
        }
        outHtml += "    <p>Your current score is " + quiz.getScore() + ".</p>";
        qIndex = quiz.getNextQuestionIndex();
        if (qIndex == -1) {
            outHtml += "    <p>You hava completed the Number Quiz, with a score of " + quiz.getScore() + " of " + quiz.questions.length + ".</p>";
        } else {
            outHtml += "    <p>Guess the next number in the sequence.</p>";
            outHtml += quiz.questions[qIndex];
            outHtml += "    <form action=\"Quiz\" method=\"GET\">";
            outHtml += "    <label>Your ansewer: </label><input type=\"number\" id=\"ans\" name=\"ans\" /> ";
            outHtml += "    <input type=\"submit\" id=\"submit\" name=\"submit\" value=\"submit\" />";
            outHtml += "    </form>";
        }
        outHtml += "</body>";
        outHtml += "";
        outHtml += "</html>";

        request.getSession().setAttribute("quiz", quiz);
        request.getSession().setAttribute("qIndex", qIndex);
        out.println(outHtml);
    }
}