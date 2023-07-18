/*
* AUTHOR: Cooper Harris
* FILE: UserCollection.java
* ASSIGNMENT: Programming Assignment 4 - Spotify
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: To create dictionary of all user profiles
* in the current program
* USAGE:
* Used with PA4 main file that takes in a txt file of songs names. 
*/

import java.util.Map;
import java.util.TreeMap;

public class UserCollection {
	
	public Map<String, User> users; // = new TreeMap<>();
	
	/*
     * The constructor for this class. Creates a new
     * map of users.
     *
     * @return null
     */
	public UserCollection() {
		this.users = new TreeMap<>();
	}
	
	/*
     * This method checks if a user exists
     * in the map.
     * 
     * @param, username, A string to check for in
     * the user map.
     * 
     * @return boolean, True if the user is in map, 
     * false otherwise
     */
	public boolean userExists(String username) {
		if (users.get(username) == null) {
			return false;
		}
		return true;
	}
	
	/*
     * This method logs in a user if they are in the user
     * map and their password is correct.
     * 
     * @param, username, A string to check for in
     * the user map.
     * @param password, A string representing the user's
     * password 
     * 
     * @return user, If the username and password are valid the
     * user object is returned. Returns null otherwise
     */
	public User login(String username, String password) {
		if (!userExists(username)) {
			return null;
		}
		
		if (users.get(username).attemptLogin(password)) {
			return users.get(username);
		}		
				
		return null;	
	}
	
	/*
     * This method adds a user to the map of
     * users.
     * 
     * @return null
     */
	public void addUser(User add) {
		users.put(add.getName(), add);
	}
	
	/*
     * This method prints a string description of the users in
     * the user map.
     * 
     * @return String, in the format { name: numberOfPlaylists playlist(s), }.
     */
	public String toString() {
		String ret = "{ ";
		for (User user : users.values()) {
			ret += user.getName() + ": " + user.getPlaylists().size() + " playlist(s), ";
		} 
		ret += "}";
		
		return ret;
	}
}
