package wiamDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Valoration    
 *
 * Copyright 2014 local 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Comments {
	
private Connection con;
	
	/**
	 * Select query of table valoration
	 * @return String query result
	 * @throws SQLException
	 */
	
	public ArrayList<String> comments() throws SQLException {
		ArrayList<String> comments = new ArrayList<String>();
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from comments;");
			while (rs.next()) {
				String c = "" + rs.getString("def") + "-" +
						rs.getString("fk_route") + "-" + rs.getInt("fk_user");
				comments.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comments;
	}

}
