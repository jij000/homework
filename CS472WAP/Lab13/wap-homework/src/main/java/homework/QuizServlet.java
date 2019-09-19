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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
//        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        qIndex = quiz.getNextQuestionIndex();
        request.setAttribute("qIndex", qIndex);
        request.setAttribute("quiz", quiz);
        request.setAttribute("questions", quiz.getQuestions());

        request.getSession().setAttribute("quiz", quiz);
        request.getSession().setAttribute("qIndex", qIndex);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}