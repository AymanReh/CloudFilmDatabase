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


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("update.html");
		dispatcher.include(req, resp);
		id = Integer.valueOf(req.getParameter("id"));
	}
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		int year = Integer.valueOf(req.getParameter("year"));
		String dir = req.getParameter("dir");
		String stars = req.getParameter("stars");
		String review = req.getParameter("review");
		Film f = new Film(id, title, year, dir, stars, review);
		f.setId(id);
		FilmDAO dao = new FilmDAO();
		PrintWriter out = resp.getWriter();
		
		try {
			dao.updateFilm(f);
			out.write("Successfully Updated Films");
		}catch(SQLException e){
			e.printStackTrace();			
		}
	}
	

}
