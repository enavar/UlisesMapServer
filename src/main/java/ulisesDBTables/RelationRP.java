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
 * RelationRP
 * Class to manage query on database table relationrp  
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class RelationRP extends DAOconection {

	public RelationRP() throws ClassNotFoundException {
		connect();
	}
	
	/**
	 * Select all the points from a determinated route
	 * @param routeName is a name of a route
	 * @param imgPath the String path for a image in server
	 * @return JSONArray of route points
	 * @throws SQLException
	 * @throws JSONException
	 */
	public JSONArray selectRoutePoints(String routeName,String imgPath) throws SQLException,JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		JSONArray result = new JSONArray();
		// obtener los puntos
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from points where name in(Select pointName from relationRP where routeName='" + routeName + "')");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put(Values.POINTS_NAME_KEY, rs.getString(Values.POINTS_NAME_KEY));
				json.put(Values.POINTS_LATITUDE_KEY, rs.getString(Values.POINTS_LATITUDE_KEY));
				json.put(Values.POINTS_LONGITUDE_KEY, rs.getString(Values.POINTS_LONGITUDE_KEY));
				json.put(Values.POINTS_STREET_KEY, rs.getString(Values.POINTS_STREET_KEY));
				json.put(Values.POINTS_DESCRIPTION_KEY, rs.getString(Values.POINTS_DESCRIPTION_KEY));
				json.put(Values.POINTS_URL_KEY, rs.getString(Values.POINTS_URL_KEY));
				json.put(Values.POINTS_IMAGE_KEY, "" + imgPath + rs.getString(Values.POINTS_IMAGE_KEY));
				arr.put(json);
			}
			// ordenar los puntos
			stm = con.createStatement();
			ResultSet rs2 = stm.executeQuery("Select pointName from relationRP where routeName='" + routeName + "' order by position");
			while (rs2.next()) {
				String name = rs2.getString(Values.RELATIONRP_POINT_NAME_KEY);
				for (int i = 0; i < arr.length(); i++) {
					JSONObject json = arr.getJSONObject(i);
					if (name.equals(json.get(Values.POINTS_NAME_KEY))) {
						result.put(json);
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * Constructs the path of images in server with a route name input
	 * @param routeName the name of the route
	 * @return the string path of images
	 */
	public String imgpathFromRoute(String routeName) {
		String imagePath = "";
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select country,name from city where ref in (Select fk_ref from points where name in(Select pointName from relationRP where routeName='" + routeName + "'))");
			while (rs.next()) {
				imagePath = Values.IMAGE_PATH + rs.getString(Values.CITY_COUNTRY_KEY) + "/" + rs.getString(Values.CITY_NAME_KEY) + "/";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imagePath;
	}
}
