package wiamDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Points    
 *
 * Copyright 2014 local 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Points {
	
private Connection con;
	
	/**
	 * Select query of table points
	 * @return String query result
	 * @throws SQLException
	 */
	
	public ArrayList<String> points() throws SQLException {
		ArrayList<String> points = new ArrayList<String>();
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from points;");
			while (rs.next()) {
				String c = "" + rs.getInt("pk") + "-" +
						rs.getString("name") + "-" + rs.getDouble("lat") + "-" + rs.getDouble("lon") + "-" + 
						rs.getString("text") + "-" + rs.getString("img");
				points.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return points;
	}

}
