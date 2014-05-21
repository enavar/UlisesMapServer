/**
 * Copyright (c) 2014, Oleksander Dovbysh & Elisabet Navarro & Sheila Perez
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ulisesDBTables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ulisesDB.DAOconection;
import ulisesDB.Values;

/**
 * City
 * Class to manage query on database table city    
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
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
				 json.put(Values.CITY_COUNTRY_KEY,rs.getString(Values.CITY_COUNTRY_KEY));
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
				 json.put(Values.CITY_REFERENCE_KEY,rs.getString(Values.CITY_REFERENCE_KEY));
				 json.put(Values.CITY_NAME_KEY,rs.getString(Values.CITY_NAME_KEY));
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
				 json.put(Values.CITY_NAME_KEY,rs.getString(Values.CITY_NAME_KEY));
				 json.put(Values.CITY_COUNTRY_KEY,rs.getString(Values.CITY_COUNTRY_KEY));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return json;
	}

}
