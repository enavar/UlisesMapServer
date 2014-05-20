package ulisesDB;

/**
 * Class to manage all the constant values in server
 @Author: Oleksander Dovbysh
 * 			Elisabet Navarro
 * 			Sheila Perez
 * 
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 *
 */
public class Values {
	
	public static final String EXIST_DB = "true";
	public static final String NO_EXIST_DB = "false";
	
	public static final String COMMENTS_ROUTES_KEY = "fk_route";
	public static final String COMMENTS_USER_KEY = "fk_user";
	public static final String COMMENTS_DEFINITION_KEY = "def";
	
	public static final String USERS_NAME_KEY = "user";
	public static final String USERS_PASSWORD_KEY = "password";
	public static final String USERS_EMAIL_KEY = "email";
	
	public static final String IMAGE_PATH = "http://ulises-ulisesmap.rhcloud.com/images/";
	
	public static final String NEGATIVE_INPUT = "false";
	
	public static final String ROUTES_NAME_KEY = "name";
	public static final String ROUTES_DESCRIPTION_KEY = "description";
	public static final String ROUTES_REFERENCE_KEY = "fk_ref";
	public static final String ROUTES_AVERAGE_KEY = "avg";
	
	public static final String COMMENTVALORATION_USERVALORATION_KEY = "valuser";
	public static final String COMMENTVALORATION_USERCOMMENT_KEY = "comuser";
	public static final String COMMENTVALORATION_COMMENT_KEY = "comment";
	public static final String COMMENTVALORATION_VALORATION_KEY = "valoration";
	
	public static final String POINTS_NAME_KEY = "name";
	public static final String POINTS_LATITUDE_KEY = "lat";
	public static final String POINTS_LONGITUDE_KEY = "lon";
	public static final String POINTS_STREET_KEY = "street";
	public static final String POINTS_DESCRIPTION_KEY = "description";
	public static final String POINTS_URL_KEY = "url";
	public static final String POINTS_IMAGE_KEY = "image";
	public static final String POINTS_REFERENCE_KEY = "fk_ref";
	
	public static final String CITY_NAME_KEY = "name";
	public static final String CITY_COUNTRY_KEY = "country";
	public static final String CITY_REFERENCE_KEY = "ref";
	
	public static final String RELATIONRP_POINT_NAME_KEY = "pointName";
	
}
