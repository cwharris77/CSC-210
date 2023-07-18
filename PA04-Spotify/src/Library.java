/*
* AUTHOR: Cooper Harris
* FILE: Library.java
* ASSIGNMENT: Programming Assignment 4 - Spotify
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: To create a library that stores the songs read in from
* PA4 main.
* USAGE:
* Used with PA4 main file that takes in a txt file of songs names. 
*/

import java.util.Map;
import java.util.TreeMap;

public class Library {
	
	public Map<String, Song> library;
	
	/*
     * The constructor for this class. Creates a library
     * of the songs available from the given .txt file 
     * for this run of the program.
     *
     * @return null
     */
	public Library() {
		this.library = new TreeMap<String, Song>();
	}
	
	/*
     * This method returns the name of a song
     * from the library.
     * 
     * @return library.get(title), A string 
     * representing the name of a song.
     */
	public Song getSong(String title) {
		return library.get(title);
	}
	
	/*
     * This method adds a song to the library.
     * 
     * @return null
     */
	public void addSong(Song song) {
		if (song instanceof Song) {
			library.put(song.getTitle(), song);
		} 
	}
	
	/*
     * This method removes a song from the library.
     * 
     * @return null
     */
	public void removeSong(Song song) {
		library.remove(song.getTitle());
		
	}
	
	/*
     * This method prints the library songs in
     * alphabetical order.
     * 
     * @return retString, A string representation of 
     * all songs in the library.
     */
	public String toString() {
		String retString = "";
		for (String song : library.keySet()) {
			retString += (library.get(song)).toString() + '\n';
		}
		return retString;
	}
}
