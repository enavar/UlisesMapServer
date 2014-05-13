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
	
	
	public JSONArray selectCommentValoration(String routeName) throws JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select v.def as valoration,v.fk_user as valuser,c.def as comment,c.fk_user as comuser from (Select * from comments where fk_route = '" + routeName +
					"') as c full outer join (Select * from valoration where fk_route ='" + routeName + "') as v on c.fk_route=v.fk_route and v.fk_user=c.fk_user;");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put("valoration", rs.getInt("valoration"));
				json.put("comment", rs.getString("comment"));
				if (rs.getString("valuser") != null) {
					json.put("user",rs.getString("valuser"));
				} else {
					json.put("user",rs.getString("comuser"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
}
