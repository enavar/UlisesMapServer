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

import ulisesDBTables.Routes;

/**
 * ServletRoutes for receibe and send data from routes; implementation class Servlet.
 * This servlet get points of routes. Client send name route and servlet
 * response string with format JSONArray. The JSONArray has name, latitude,
 * longitude, street, description, url and image of points.
 * 
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
@WebServlet("/ServletRoutes")
public class ServletRoutes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletRoutes() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// type of response dates
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// input client dates
		int length = request.getContentLength();
		byte[] input = new byte[length];
		ServletInputStream sin = request.getInputStream();
		int c, count = 0;
		while ((c = sin.read(input, count, input.length - count)) != -1) {
			count += c;
		}
		sin.close();
		String in = new String(input);
		System.out.println("Servlet routes input : " + in);
		// output data
		Routes r = null;
		JSONArray arr = null;
		try {
			r = new Routes();
			arr = r.selectRoutesInfo(in);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		String result = arr.toString();
		System.out.println("Servlet routes result : " + result);
		// send points converted in string
		r.close();
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}

}
