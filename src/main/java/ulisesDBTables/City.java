package ulisesDBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ulisesDB.DAOconection;



/*
 * City    
 *
 * @Author: Oleksander Dovbysh
 * 			Elisabet Navarro
 * 			Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class City extends DAOconection {
	
	public City() throws ClassNotFoundException {
		connect();
	}
	
	/**
	 * Select country query of table city
	 * @return array of JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException 
	 */
	
	public JSONArray selectCountry() throws SQLException, JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select distinct country from city;");
			while (rs.next()) {
				 JSONObject json = new JSONObject();
				 json.put("country",rs.getString("country"));
				 arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * Select cities of determinated country
	 * @param country a String name of a country
	 * @return array of JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException 
	 */
	
	public JSONArray selectCities(String country) throws SQLException, JSONException {
		Statement stm;
		JSONArray arr = new JSONArray();
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from city where country='" + country + "';");
			while (rs.next()) {
				 JSONObject json = new JSONObject();
				 json.put("ref",rs.getString("ref"));
				 json.put("name",rs.getString("name"));
				 arr.put(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * Select cities and contry for determinated ref
	 * @param ref a reference for a city and a country
	 * @return JSONObject result of query
	 * @throws SQLException
	 * @throws JSONException 
	 */
	public JSONObject selectCityCountry(String ref) throws SQLException, JSONException {
		Statement stm;
		JSONObject json = new JSONObject();
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from city where ref='" + ref + "';");
			while (rs.next()) {
				 json.put("name",rs.getString("name"));
				 json.put("country",rs.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return json;
	}

}
