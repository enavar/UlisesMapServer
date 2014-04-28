package ulisesServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wiamDB.Users;
import net.sf.json.JSONObject;

/*
 * PointsServlet    
 *
 * Copyright 2014 local 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class PointsServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection con;
	private DAOconection databaseDAO = new DAOconection();
		
	public PointsServlet() {
		      super();
		    }
		/**
		 * Iniciar la conexion
		 */
	    public void init() {
			
	    	try {
				databaseDAO.connect();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = databaseDAO.getCon();	
	    }

	    /**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// type of response dates
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			// input client dates
			int id;
			// output server dates
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			//json = u.selectPoint(id);
			out.print(json);
			out.flush();
		}



}
