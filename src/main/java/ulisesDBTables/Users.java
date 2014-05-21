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

import ulisesDB.DAOconection;

/**
 * Users
 * Class to manage query on database table users    
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class Users extends DAOconection {
	
	public Users() throws ClassNotFoundException {
		connect();
	}
	
	/**
	 * Select all dates query of table users
	 * 
	 * @param name the user name
	 * @param pass the user password
	 * @return true if user exists, false oterwhise
	 * @throws SQLException
	 */
	public boolean selectUserByName(String name, String pass) throws SQLException {
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from users where name='" + name + "' and password=md5('" + pass + "');");
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Insert new user in database
	 * @param name the String name of an user
	 * @param password the String password for an user
	 * @param email ths String email of an user
	 * @return true if user has been insert, false otherwise
	 */
	public boolean insertUser(String name, String password, String email) {
		Statement stm;
		String insert = "insert into users values ('" + name + "',md5('" + password + "'),'" + email + "');";
		try {
			stm = con.createStatement();
			stm.executeUpdate(insert);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
