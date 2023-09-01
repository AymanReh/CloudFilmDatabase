package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import model.Film;


@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> allFilm = dao.getAllFilms();
		request.setAttribute("films", allFilm);
		RequestDispatcher rd = request.getRequestDispatcher("films.jsp");
		rd.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO dao = new FilmDAO();
		int id = Integer.valueOf(request.getParameter("id"));
		ArrayList<Film> specFilm =  dao.getFilmByID(id);
		request.setAttribute("films", specFilm);
		RequestDispatcher rd = request.getRequestDispatcher("films.jsp");
		rd.include(request, response);
	}

}
