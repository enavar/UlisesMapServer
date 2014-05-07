package ulisesServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import wiamDB.Comments;

/*
 * ServletInsertComment
 * 
 * @Author: Oleksander Dovbysh Elisabet Navarro Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3. See
 * http://www.gnu.org/licenses/gpl.html for more information.
 */

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletInsertComment")
public class ServletInsertComment extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public ServletInsertComment() {
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
		// type of response dates
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		Comments co = null;
		try {
			co = new Comments();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}		
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
			String comment = json.getString("def");
			String route = json.getString("fk_route");
			String user = json.getString("fk_user");
			boolean exist = co.insertComment(comment, user, route);
			if (exist) {
				result = "Your comment has been added";
			} else {
				result = "Sorry, your comment hasn't been added";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		        
		// output data
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}
}
