package wiamDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Users    
 *
 * Copyright 2014 local 
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Users {
	
	private Connection con;
	
	/**
	 * Select query of table users
	 * @return String query result
	 * @throws SQLException
	 */
	
	public ArrayList<String> users() throws SQLException {
		ArrayList<String> users = new ArrayList<String>();
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("Select * from users;");
			while (rs.next()) {
				String c = "" + rs.getInt("pk") + "-" +
						rs.getString("name") + "-" + rs.getString("password");
				users.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void insertUser(String insert) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(insert);
			preparedStatement .executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
