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
	 * @return JSONArray of route points
	 * @throws SQLException
	 * @throws JSONException
	 */
	public JSONArray selectRoutePoints(String routeName) throws SQLException,JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select lat,lon from points where name in(Select pointName from relationRP where routeName='" + routeName + "')");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put(Values.POINTS_LATITUDE_KEY, rs.getString(Values.POINTS_LATITUDE_KEY));
				json.put(Values.POINTS_LONGITUDE_KEY, rs.getString(Values.POINTS_LONGITUDE_KEY));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}
}
