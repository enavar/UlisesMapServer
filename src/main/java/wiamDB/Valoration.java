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

public class Valoration {
	
private Connection con;
	
	/**
	 * Select query of table valoration
	 * @return String query result
	 * @throws SQLException
	 */
	
	public ArrayList<String> valoration() throws SQLException {
		ArrayList<String> valoration = new ArrayList<String>();
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from valoration;");
			while (rs.next()) {
				String c = "" + rs.getInt("def") + "-" +
						rs.getString("fk_route") + "-" + rs.getInt("fk_user");
				valoration.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valoration;
	}

}
