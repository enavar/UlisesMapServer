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
package ulisesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DAOconection
 * Class to manage connection with database    
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class DAOconection {
	/** Connection with database */
	protected Connection con = null;
	/** Constant databse user */
	public static final String USERNAME = System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME");
	/** Constant for database password */
	public static final String PASSWORD = System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD");
	/** Constant for database host */
	public static final String HOST = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
	/** Constant for database port connection */
	public static final String PORT = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
	/** Constant for database name */
	public static final String DBNAME = System.getenv("OPENSHIFT_APP_NAME");
	

	/**	
	 * Method to set database connection
	 * @param e is a database connection
	 * @throws ClassNotFoundException 
	 */
	public void connect() throws ClassNotFoundException {
		String url = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DBNAME;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					url, USERNAME, PASSWORD); // ("base de datos","usuario","pasword")
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Conexion realizado");
	}
	
	/**
	 * Method to close database connection
	 */
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
