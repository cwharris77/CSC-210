/*
* AUTHOR: Cooper Harris
* FILE: Song.java
* ASSIGNMENT: Programming Assignment 4 - Spotify
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: To create a song object and use it in a 
* user's profile.
* USAGE:
* Used with PA4 main file that takes in a txt file of songs names. 
* 
* All song titles and artists should be formatted as strings.
*/

public class Song {
	
	private String title;
	private String artist;
	private int timesPlayed;
	
	/*
     * The constructor for this class. Creates a new Song object.
     *
     * @param title, the name of the given song
     * @param artist, the artist who made the song
     * 
     * @return null
     */
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.timesPlayed = 0;
	}
	
	/*
     * This method returns the title of a song
     * object as a string.
     * 
     * @return title, A string representing the title
     * of a song object
     */
	public String getTitle() {
		return title;
	}
	
	/*
     * This method returns the name of an artist
     * 
     * @return artist, A string representing the name of 
     * the artist associated with a song object
     */
	public String getArtist() {
		return artist;
	}
	
	/*
     * This method checks how many times a song has
     * been played.
     * 
     * @return timesPlayed, An int representing the
     * number of plays a song has
     */
	public int getTimesPlayed() {
		return timesPlayed;
	}
	
	/*
     * This method plays a song by printing its 
     * description.
     * 
     * @return null
     */
	public void play() {
		System.out.println(this.toString());
		timesPlayed += 1;
	}
	
	/*
     * This method returns a string representation
     * of a song.
     * 
     * @return string, songTitle by songArtist, numberOfPlays.
     */
	public String toString() {
		return title + " by " + getArtist() + ", " + getTimesPlayed() + " play(s)";
		
	}
}
