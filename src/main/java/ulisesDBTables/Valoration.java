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
 * Valoration
 * Class to manage query on database table valoration    
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class Valoration extends DAOconection {
	
	public Valoration() throws ClassNotFoundException {
		connect();
	}
	
	/**
	 * Select query of table valoracio
	 * @param routeName the name of selected route
	 * @return array of JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException 
	 */
	public JSONArray selectValoration(String routeName) throws SQLException, JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from valoration where fk_route='" + routeName + "';");
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
	 * Insert new valoration in database
	 * @param valoracio double number of valoration
	 * @param user String name of user who valorated
	 * @param route String name of valorated route
	 * @return true if valoration has been insert, false otherwise
	 */
	public boolean insertValoration(double valoracio,String user,String route) {
		Statement stm;
		String insert = "insert into valoration values (" + valoracio + ",'" + route + "','" + user + "');";
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
	 * Check if determinated user has valored a determinated route
	 * @param routeName the string name of a route
	 * @param userName the string name who valorates
	 * @return return true if user has valorated the route, false otherwise
	 * @throws SQLException
	 */
	public boolean checkValoration(String routeName,String userName) throws SQLException {
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from valoration where fk_route='" + routeName + "' and fk_user='" + userName + "';");
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Average of a valorations in determinated route
	 * @param routeName string the name of a route
	 * @return double a value of an average valoration
	 */
	public double averageValoration(String routeName) {
		double result = 0;
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select avg(def) from valoration where fk_route='" + routeName + "';"); 	 
			while (rs.next()) {
				result = rs.getDouble(Values.ROUTES_AVERAGE_KEY);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
