/**
 * This class manages the currently logged in user
 * @author rachelmao
 *
 */
public class User {
	private static User single_instance = null;
	// Setting accessLevel default to 1 for admin development purposes. Usually this value should be -1.
	private int accessLevel = 1;
	//	private int accessLevel = -1;
	private User() {
		
	}
	/**
	 * This method creates a new or returns the current instance of the User.
	 * @return the current instance of the User.
	 */
	public static User getInstance() {
		if (single_instance == null) {
			single_instance = new User();
		}
		return single_instance;
	}
	
	/**
	 * This method returns the access level of the User: 1 for admin, 0 for regular user.
	 * @return the access level of the User.
	 */
	public int getAccessLevel() {
		return accessLevel;
	}
	
	/**
	 * This method sets the access level of the User: 1 for admin, 0 for regular user.
	 * @param accessLevel the access level of the User.
	 */
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

}
