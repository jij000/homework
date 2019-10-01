package edu.mum.cs.controller;

import edu.mum.cs.data.DataFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
/**
 * Servlet implementation class AdviceServlet
 */
@WebServlet(urlPatterns = "/action/advice")
public class AdviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdviceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String roast = request.getParameter("roast");		
		
  		DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
		List<String> advice = data.getAdvice(roast);
		request.setAttribute("roast", roast);
        request.setAttribute("advice", advice);
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
        request.getRequestDispatcher("../advice.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
