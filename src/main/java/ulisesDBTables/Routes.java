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
 * Routes    
 *
 * @Author: Oleksander Dovbysh
 * 			Elisabet Navarro
 * 			Sheila Perez 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

/**
 * 
 * Class to manage query on database table routes
 *
 */
public class Routes extends DAOconection {

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
		Valoration val = new Valoration();
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from routes where fk_ref='" + ref + "';");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				String routeName = rs.getString(Values.ROUTES_NAME_KEY);
				json.put(Values.ROUTES_NAME_KEY, routeName);
				json.put(Values.ROUTES_IMAGE_KEY, Values.IMAGE_ROUTES_PATH + rs.getString(Values.ROUTES_IMAGE_KEY));
				json.put(Values.ROUTES_DESCRIPTION_KEY, rs.getString(Values.ROUTES_DESCRIPTION_KEY));
				json.put(Values.ROUTES_REFERENCE_KEY, rs.getString(Values.ROUTES_REFERENCE_KEY));
				json.put(Values.ROUTES_AVERAGE_KEY, val.averageValoration(routeName));
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arr;
	}
	

	/**
	 * Select relation query for obtain comments and valorations from determinated user and route
	 * 
	 * @param routeName the name of a selected route 
	 * @return JSONArray result of query
	 * @throws SQLException
	 * @throws JSONException
	 * @throws ClassNotFoundException 
	 */
	public JSONArray selectCommentValoration(String routeName) throws JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select v.def as valoration,v.fk_user as valuser,c.def as comment,c.fk_user as comuser from (Select * from comments where fk_route = '" + routeName + "') as c full outer join (Select * from valoration where fk_route ='" + routeName + "') as v on c.fk_route=v.fk_route and v.fk_user=c.fk_user;");
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put(Values.COMMENTVALORATION_VALORATION_KEY, rs.getDouble(Values.COMMENTVALORATION_VALORATION_KEY));
				json.put(Values.COMMENTVALORATION_COMMENT_KEY, rs.getString(Values.COMMENTVALORATION_COMMENT_KEY));
				if (rs.getString("valuser") != null) {
					json.put(Values.USERS_NAME_KEY,rs.getString(Values.COMMENTVALORATION_USERVALORATION_KEY));
				} else {
					json.put(Values.USERS_NAME_KEY,rs.getString(Values.COMMENTVALORATION_USERCOMMENT_KEY));
				}
				arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
}
