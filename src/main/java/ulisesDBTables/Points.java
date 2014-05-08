
package ulisesDBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ulisesDB.DAOconection;

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
	 * @return Array of JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException
	 */
	
	public JSONArray selectPoints(String ref) throws SQLException, JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from points where fk_ref='" + ref + "';");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put("name", rs.getString("name"));
				json.put("lat", rs.getDouble("lat"));
				json.put("lon", rs.getDouble("lon"));
				json.put("street", rs.getString("street"));
				json.put("description", rs.getString("description"));
				json.put("url", rs.getString("url"));
				json.put("image", rs.getString("image"));
				json.put("fk_ref", rs.getString("fk_ref"));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	
}
