/**
 * Copyright (c) 2014, Oleksander Dovbysh & Elisabet Navarro & Sheila Perez
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ulisesServletInsert;

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

import ulisesDB.Values;
import ulisesDBTables.Comments;

/**
 * ServletInsertComment for insert new comment in database implementation class
 * Servlet
 * 
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
@WebServlet("/ServletInsertComment")
public class ServletInsertComment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletInsertComment() {
		super();
	}

	/**
	 * Start the servlet
	 */
	public void init() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// type of response dates
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
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
		int c, count = 0;
		while ((c = sin.read(input, count, input.length - count)) != -1) {
			count += c;
		}
		sin.close();
		String recievedString = new String(input);
		System.out.println("Servlet insertcomment input : " + recievedString);
		// convert String into JSONObject and recuperate keys
		String result = "";
		try {
			JSONObject json = new JSONObject(recievedString);
			String comment = json.getString(Values.COMMENTS_DEFINITION_KEY);
			String route = json.getString(Values.COMMENTS_ROUTES_KEY);
			String user = json.getString(Values.COMMENTS_USER_KEY);
			boolean exist = co.insertComment(comment, user, route);
			if (exist) {
				result = Values.EXIST_DB;
			} else {
				result = Values.NO_EXIST_DB;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// output data
		co.close();
		System.out.println("Servlet insertcomment result : " + result);
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}
}
