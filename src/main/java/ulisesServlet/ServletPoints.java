package ulisesServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
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

public class ServletPoints {
	
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
		 * @throws SQLException 
	     * @throws ClassNotFoundException 
	     * @throws JSONException 
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException, JSONException {
		
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, ClassNotFoundException, SQLException, JSONException {
			Points p = new Points();
			p.connect();
			// type of response dates
			response.setContentType("text/html");
			// capture all of interest points to db
			JSONArray arr = p.selectPoints();
			String result = arr.toString();
			// send points converted in string
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush(); 
		}

}
