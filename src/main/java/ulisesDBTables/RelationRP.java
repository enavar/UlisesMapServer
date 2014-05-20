package ulisesDBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ulisesDB.DAOconection;
import ulisesDB.Values;

/*
 * RelationRP    
 *
 * @Author: Oleksander Dovbysh
 * 			Elisabet Navarro
 * 			Sheila Perez 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
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
			ResultSet rs = stm.executeQuery("Select * from points where name in(Select pointName from relationRP where routeName='" + routeName + "' orderby position)");
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
