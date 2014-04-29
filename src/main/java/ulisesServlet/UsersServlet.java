
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
 * UsersServlet
 * 
 * @Author: Oleksander Dovbysh Elisabet Navarro Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3. See
 * http://www.gnu.org/licenses/gpl.html for more information.
 */

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public UsersServlet() {
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
		// database conection
		Users u = new Users();
		try {
			u.connect();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("doget");
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
		System.out.println(recievedString);	
		/**
		// check if user exists in db
		boolean exist = false;
		try {
			exist = u.selectUserByName(user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (exist) {
			// accio depenent de comment o valoration
		} else {
			u.insertUser(user, pass);
		}
		// output data
		PrintWriter out = response.getWriter();
		out.print(exist);
		out.flush(); */
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
				System.out.println(recievedString);	
				/**
				// check if user exists in db
				boolean exist = false;
				try {
					exist = u.selectUserByName(user, pass);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (exist) {
					// accio depenent de comment o valoration
				} else {
					u.insertUser(user, pass);
				}
				// output data
				PrintWriter out = response.getWriter();
				out.print(exist);
				out.flush(); */
	}
	
}
