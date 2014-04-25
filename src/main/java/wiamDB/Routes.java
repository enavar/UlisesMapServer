package wiamDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Routes    
 *
 * Copyright 2014 local 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Routes {

private Connection con;
	
	/**
	 * Select query of table routes
	 * @return String query result
	 * @throws SQLException
	 */
	
	public ArrayList<String> routes() throws SQLException {
		ArrayList<String> routes = new ArrayList<String>();
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from routes;");
			while (rs.next()) {
				String c = "" + rs.getString("name") + "-" +
						rs.getString("description");
				routes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return routes;
	}
}
