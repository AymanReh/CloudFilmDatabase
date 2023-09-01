package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.FilmDAO;
import model.Film;



@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("create.html");
		dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO dao = new FilmDAO();
		String title = request.getParameter("title");
		int year = Integer.valueOf(request.getParameter("year"));
		String dir = request.getParameter("dir");
		String stars = request.getParameter("stars");
		String review = request.getParameter("review");
		Film f = new Film(0, title, year, dir, stars, review);
		PrintWriter out = response.getWriter();
		
		try {
			dao.insertFilm(f);
			out.write("Successfully inserted contact");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}				
	}