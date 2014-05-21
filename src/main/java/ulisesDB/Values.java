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

/**
 * Values
 * Class to manage all the constant dates for control input and 
 * output dates between server and client   
 *
 * @Author: Oleksander Dovbysh, Elisabet Navarro, Sheila Perez
 * @version: 1.0
 */
public class Values {
	/** Message for true result in check methods */ 
	public static final String EXIST_DB = "true";
	/** Message for false result in check methods */ 
	public static final String NO_EXIST_DB = "false";
	
	/** routes name column key for table comments in database */
	public static final String COMMENTS_ROUTES_KEY = "fk_route";
	/** user name column key for table comments in database */
	public static final String COMMENTS_USER_KEY = "fk_user";
	/** comment value column key for table comments in database */
	public static final String COMMENTS_DEFINITION_KEY = "def";
	
	/** user name column key for table users in database */
	public static final String USERS_NAME_KEY = "user";
	/** user password column key for table users in database */
	public static final String USERS_PASSWORD_KEY = "password";
	/** user email column key for table users in database */
	public static final String USERS_EMAIL_KEY = "email";
	
	/** predefined path for points of interest images in server */
	public static final String IMAGE_PATH = "http://ulises-ulisesmap.rhcloud.com/images/";
	/** predefined path for routes images in server */
	public static final String IMAGE_ROUTES_PATH = "http://ulises-ulisesmap.rhcloud.com/images/routes/";
	
	/** predefined response for bad input dates */
	public static final String NEGATIVE_INPUT = "false";
	
	/** route name column key for table routes in database */
	public static final String ROUTES_NAME_KEY = "name";
	/** route image column key for table routes in database */
	public static final String ROUTES_IMAGE_KEY = "image";
	/** route description column key for table routes in database */
	public static final String ROUTES_DESCRIPTION_KEY = "description";
	/** route reference city and country column key for table routes in database */
	public static final String ROUTES_REFERENCE_KEY = "fk_ref";
	/** route average of valorations column key for table routes in database */
	public static final String ROUTES_AVERAGE_KEY = "avg";
	
	/** user valoration key for JSONObjects */
	public static final String COMMENTVALORATION_USERVALORATION_KEY = "valuser";
	/** user comment key for JSONObjects */
	public static final String COMMENTVALORATION_USERCOMMENT_KEY = "comuser";
	/** comment key for JSONObjects */
	public static final String COMMENTVALORATION_COMMENT_KEY = "comment";
	/** valoration key for JSONObjects */
	public static final String COMMENTVALORATION_VALORATION_KEY = "valoration";
	
	/** point name column key for table points in database */
	public static final String POINTS_NAME_KEY = "name";
	/** point latitude column key for table points in database */
	public static final String POINTS_LATITUDE_KEY = "lat";
	/** point longitude column key for table points in database */
	public static final String POINTS_LONGITUDE_KEY = "lon";
	/** point street direction column key for table points in database */
	public static final String POINTS_STREET_KEY = "street";
	/** point description column key for table points in database */
	public static final String POINTS_DESCRIPTION_KEY = "description";
	/** url information column key for table points in database */
	public static final String POINTS_URL_KEY = "url";
	/** point image column key for table points in database */
	public static final String POINTS_IMAGE_KEY = "image";
	/** point reference city and country column key for table points in database */
	public static final String POINTS_REFERENCE_KEY = "fk_ref";
	
	/** city name column key for table city in database */
	public static final String CITY_NAME_KEY = "name";
	/** country name column key for table city in database */
	public static final String CITY_COUNTRY_KEY = "country";
	/** city and country reference column key for table city in database */
	public static final String CITY_REFERENCE_KEY = "ref";
	
	/** point name column key for table relationrp in database */
	public static final String RELATIONRP_POINT_NAME_KEY = "pointName";
	
}
