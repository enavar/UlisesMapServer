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

import ulisesDBTables.Points;


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
			// type of response dates
			response.setContentType("text/html");
			Points p = null;
			JSONArray arr = null;
			try {
				p = new Points();
				arr = p.selectPoints();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			String result = arr.toString();
			// send points converted in string
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush(); 
		}

}
