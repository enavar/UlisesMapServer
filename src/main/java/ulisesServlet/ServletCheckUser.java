
package ulisesServlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
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

import wiamDB.Users;

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
@WebServlet("/ServletCheckUser")
public class ServletCheckUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ServletCheckUser() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// database conection
				Users u = new Users();
				try {
					u.connect();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				System.out.println("dopost");
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
					String user = json.getString("user");
					String pass = json.getString("password");
					boolean exist = u.selectUserByName(user, pass);
					if (exist) {
						result = "Welcome!";
					} else {
						result = "Try again";
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
