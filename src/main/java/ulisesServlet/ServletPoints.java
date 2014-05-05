package ulisesServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import wiamDB.Points;


/*
 * ServletPoints   
 *
 * @Author: Oleksander Dovbysh
 * 			Elisabet Navarro
 * 			Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletPoints")
public class ServletPoints extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	public ServletPoints() {
		      super();
		    }
		/**
		 * Iniciar la conexion
		 */
	    public void init() {
			
	    }

	    /**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
			Points p = new Points();
			try {
				p.connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// type of response dates
			response.setContentType("text/html");
			// capture all of interest points to db
			JSONArray arr = null;
			try {
				arr = p.selectPoints();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = arr.toString();
			// send points converted in string
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush(); 
		}

}
