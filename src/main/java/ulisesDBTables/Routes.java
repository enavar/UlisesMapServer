package ulisesDBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ulisesDB.DAOconection;

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

public class Routes extends DAOconection {

	private Valoration val = new Valoration();

	public Routes() throws ClassNotFoundException {
		connect();
	}

	/**
	 * Select query of table routes
	 * 
	 * @param ref the id of selected city 
	 * @return JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException
	 * @throws ClassNotFoundException 
	 */

	public JSONArray selectRoutesInfo(String ref) throws SQLException,JSONException, ClassNotFoundException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from routes where fk_ref='" + ref + "';");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				String routeName = rs.getString("name");
				json.put("name", routeName);
				json.put("description", rs.getString("description"));
				json.put("fk_ref", rs.getString("fk_ref"));
				json.put("avg", val.averageValoration(routeName));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}
	
}
