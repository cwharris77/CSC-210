/*
* AUTHOR: Cooper Harris
* FILE: User.java
* ASSIGNMENT: Programming Assignment 4 - Spotify
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: To create a user object that stores a profile.
* USAGE:
* Used with PA4 main file that takes in a txt file of songs names. 
*/

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public String nameStr;
	public String passcode;
	public List<Playlist> playlists;
	
	/*
     * The constructor for this class. Creates a new
     * user object.
     * 
     * @param name, the username of the user
     * @param password, the user's password
     *
     * @return null
     */
	public User(String name, String password) {
		this.nameStr = name;
		this.passcode = password;
		this.playlists = new ArrayList<Playlist>();
	}
	
	/*
     * This method returns the username of a user object.
     * 
     * @return nameStr, A string representing the username
     * of a user object.
     */
	public String getName() {
		return nameStr;		
	}
	
	/*
     * This method checks if a user can log in
     * by returning whether or not the given password
     * matches with the users set password.
     * 
     * @param, password, A string to check against the
     * user's password
     * 
     * @return boolean, True if the passwords match, 
     * false otherwise
     */
	public boolean attemptLogin(String password) {
		return passcode.equals(password);	
	}
	
	/*
     * This method adds a playlist object to the
     * list of playlists for this user.
     * 
     * @return null
     */
	public void addPlaylist(Playlist newPlaylist) {
		playlists.add(newPlaylist);
	}
	
	/*
     * This method returns a list of 
     * playlists for this user.
     * 
     * @return playlists, A list of playlist objects
     */
	public List<Playlist> getPlaylists(){
		return playlists;		
	}
	
	/*
     * This method selects a playlist with the specified
     * name from the list of user playlists then plays
     * the playlist
     * 
     * @return null
     */
	public void selectPlaylist(String name) {
		for (Playlist playLst : playlists) {
			if (name.equals(playLst.getName())){
				playLst.play();
			}
		}
	}
	
	/*
     * This method prints a string description of the user.
     * 
     * @return String, in the format name, numPlaylists playlist(s).
     */
	public String toString() {
		return getName() + ", " + playlists.size() + " playlist(s).";
	}
}
