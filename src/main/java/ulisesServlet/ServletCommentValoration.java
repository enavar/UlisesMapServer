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

import wiamDB.Comments;
import wiamDB.Valoration;



/*
 * ServletCommentValoration 
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
@WebServlet("/ServletCommentValoration")
public class ServletCommentValoration extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	public ServletCommentValoration() {
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
		// input client dates
		int length = request.getContentLength();
        byte[] input = new byte[length];
        ServletInputStream sin = request.getInputStream();
        int c, count = 0 ;
        while ((c = sin.read(input, count, input.length-count)) != -1) {
            count +=c;
        }
        sin.close();
        String routeName = new String(input);
		
		// response dates
		Comments co = new Comments();
		Valoration va = new Valoration();
		try {
			co.connect();
			va.connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// type of response dates
		response.setContentType("text/html");
		// capture comments and valorations
		JSONArray arrComments = null;
		JSONArray arrValor = null;
		try {
			arrComments = co.selectComments(routeName);
			arrValor = va.selectValoration(routeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// put all the dates in one JSONArray object
		JSONArray arr = new JSONArray();
		arr.put(arrComments);
		arr.put(arrValor);
		
		String result = arr.toString();
		// send dates converted in string
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush(); 
	}
	
	

}
