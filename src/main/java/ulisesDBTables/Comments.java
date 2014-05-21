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
package ulisesDBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ulisesDB.DAOconection;
import ulisesDB.Values;



/**
 * Comments
 * Class to manage query on database table comments   
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class Comments extends DAOconection {
	
	public Comments() throws ClassNotFoundException {
		connect();
	}
	
	/**
	 * Select query of table comments
	 * @param routeName the name of selected route
	 * @return array of JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException 
	 */
	public JSONArray selectComments(String routeName) throws SQLException, JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from comments where fk_route='" + routeName + "';");
			while (rs.next()) {
				 JSONObject json = new JSONObject();
				 json.put(Values.COMMENTS_DEFINITION_KEY, rs.getString(Values.COMMENTS_DEFINITION_KEY));
				 json.put(Values.COMMENTS_USER_KEY,rs.getString(Values.COMMENTS_USER_KEY));
				 arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * Insert comment in database
	 * @param comment the string comment for insert
	 * @param user the name of user who inserts the comment
	 * @param route the name of the route for comment
	 */
	public boolean insertComment(String comment,String user,String route) {
		Statement stm;
		String insert = "insert into comments values ('" + comment + "','" + route + "','" + user + "');";
		try {
			stm = con.createStatement();
			stm.executeUpdate(insert);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Check if a user has a comment in determinated route
	 * @param routeName the string name of route 
	 * @param userName the user name who inserte the comment
	 * @return true if comment exists, false otherwish
	 * @throws SQLException
	 */
	public boolean checkComment(String routeName,String userName) throws SQLException {
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from comments where fk_route='" + routeName + "' and fk_user='" + userName + "';");
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
