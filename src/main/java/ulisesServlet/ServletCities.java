package ulisesServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import ulisesDBTables.City;


/*
 * ServletCities   
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
@WebServlet("/ServletCities")
public class ServletCities extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ServletCities() {
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
			// input client dates
			int length = request.getContentLength();
	        byte[] input = new byte[length];
	        ServletInputStream sin = request.getInputStream();
	        int c, count = 0 ;
	        while ((c = sin.read(input, count, input.length-count)) != -1) {
	            count +=c;
	        }
	        sin.close();
	        String in = new String(input);
			
			// response dates
	        City ci = null;
	        JSONArray arr = null;
			try {
				ci = new City();
				arr = new JSONArray();
				if (in.equals("false")) {
		        	arr = ci.selectCountry();
		        } else {
		        	arr = ci.selectCities(in);
		        }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			String result = arr.toString();
			// send dates converted in string
			PrintWriter out = response.getWriter();
			out.print(result);
			out.flush(); 
		}
}
