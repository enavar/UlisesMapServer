package wiamDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Routes    
 *
 * @Author: Oleksander Dovbysh
 * 			Elisabet Navarro
 * 			Sheila Perez 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Routes {

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
	 * Select query of table routes
	 * 
	 * @param routeName the name of selected route
	 * @return JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException
	 */

	public JSONArray selectRoutesInfo() throws SQLException,JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from routes");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put("name", rs.getString("name"));
				json.put("description", rs.getString("description"));
				// average
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}
	
	public JSONArray selectPointsDeterminatedRoute(String name) throws SQLException,JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from" + name + ";");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put("name", rs.getString("fk_name"));
				json.put("lat", rs.getString("fk_lat"));
				json.put("lon", rs.getString("fk_lon"));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}
}
