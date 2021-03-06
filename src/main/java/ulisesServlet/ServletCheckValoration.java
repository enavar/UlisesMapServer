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

import org.json.JSONException;
import org.json.JSONObject;

import wiamDB.Valoration;

/*
 * ServletCheckUser
 * 
 * @Author: Oleksander Dovbysh Elisabet Navarro Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3. See
 * http://www.gnu.org/licenses/gpl.html for more information.
 */

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletCheckValoration")
public class ServletCheckValoration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ServletCheckValoration() {
		super();
	}
	
	/**
	 * Iniciar la conexion
	 */
	public void init() {
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// database conection
				Valoration val = new Valoration();
				try {
					val.connect();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				// type of response dates
				response.setContentType("text/html");
				response.setStatus(HttpServletResponse.SC_OK);
				// input client dates
				int length = request.getContentLength();
		        byte[] input = new byte[length];
		        ServletInputStream sin = request.getInputStream();
		        int c, count = 0 ;
		        while ((c = sin.read(input, count, input.length-count)) != -1) {
		            count +=c;
		        }
		        sin.close();
		        String recievedString = new String(input);
				// convert String into JSONObject and recuperate keys
		        String result = "";
		        try {
					JSONObject json = new JSONObject(recievedString);
					String routeName = json.getString("routeName");
					String userName = json.getString("userName");
					boolean exist = val.checkValoration(routeName, userName);
					if (exist) {
						result = "ok";
					} else {
						result = "This route doesn't accept another valoration from" + userName;
					}
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        
				// output data
				PrintWriter out = response.getWriter();
				out.print(result);
				out.flush();
	}
	
}
