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
 * Points
 * Class to manage query on database table points   
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class Points extends DAOconection {
	
	public Points() throws ClassNotFoundException {
		connect();
	}
	
	
	/**
	 * Select query of table points
	 * @param ref the id of selected city 
	 * @param imgPath the String path for images in server
	 * @return Array of JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException
	 */
	public JSONArray selectPoints(String ref,String imgPath) throws SQLException, JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from points where fk_ref='" + ref + "';");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put(Values.POINTS_NAME_KEY, rs.getString(Values.POINTS_NAME_KEY));
				json.put(Values.POINTS_LATITUDE_KEY, rs.getDouble(Values.POINTS_LATITUDE_KEY));
				json.put(Values.POINTS_LONGITUDE_KEY, rs.getDouble(Values.POINTS_LONGITUDE_KEY));
				json.put(Values.POINTS_STREET_KEY, rs.getString(Values.POINTS_STREET_KEY));
				json.put(Values.POINTS_DESCRIPTION_KEY, rs.getString(Values.POINTS_DESCRIPTION_KEY));
				json.put(Values.POINTS_URL_KEY, rs.getString(Values.POINTS_URL_KEY));
				json.put(Values.POINTS_IMAGE_KEY, "" + imgPath + rs.getString(Values.POINTS_IMAGE_KEY));
				json.put(Values.POINTS_REFERENCE_KEY, rs.getString(Values.POINTS_REFERENCE_KEY));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	
}
