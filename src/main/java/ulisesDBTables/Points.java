
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
 * Points
 * 
 * @Author: Oleksander Dovbysh 
 * 			Elisabet Navarro 
 * 			Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3. See
 * http://www.gnu.org/licenses/gpl.html for more information.
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
