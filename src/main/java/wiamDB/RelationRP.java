package wiamDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class RelationRP {

	private Connection con;
	private DAOconection databaseDAO = new DAOconection();

	/**
	 * Method to set database connection
	 * 
	 * @throws ClassNotFoundException
	 */

	public void connect() throws ClassNotFoundException {
		databaseDAO.connect();
		con = databaseDAO.getCon();
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
				json.put("lat", rs.getString("lat"));
				json.put("lon", rs.getString("lon"));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}
}
