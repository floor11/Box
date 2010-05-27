package fr.floor11.box.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ConnectionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ACTION_CONNECTION
	 */
	private static final String ACTION_CONNECTION = "connect";

	/**
	 * Default constructor.
	 */
	public ConnectionController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * action générique pour le POST ou GET.
	 * 
	 */
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (ACTION_CONNECTION.equals((String) request.getParameter("action"))) {
			actionConnection(request, response);
		} else {
			request.setAttribute("errorMessage", "Mauvais mot de passe");
			getServletConfig().getServletContext().getRequestDispatcher(
					"/JSP/connection.jsp").forward(request, response);
		}
	}

	/**
	 * action si on tente de se connecter.
	 * 
	 */
	private void actionConnection(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");

		if (isAuthorized(login, password)) {
			getServletConfig().getServletContext().getRequestDispatcher(
					"/JSP/index.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Mauvais mot de passe");
			getServletConfig().getServletContext().getRequestDispatcher(
					"/JSP/connection.jsp").forward(request, response);
		}
	}

	/**
	 *verifie les login password.
	 * 
	 * @param login
	 * @param password
	 */
	private boolean isAuthorized(String login, String password) {
		return "admin".equals(login);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
}
