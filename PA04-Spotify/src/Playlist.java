/*
* AUTHOR: Cooper Harris
* FILE: Playlist.java
* ASSIGNMENT: Programming Assignment 4 - Spotify
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: To create a playlist object that stores song 
* objects.
* USAGE:
* Used with PA4 main file that takes in a txt file of songs names. 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Playlist {
	
	public String playlist;	
	public List<Song> playlistSongs;
	public Map<String, Song> sortedSongs;
	
	/*
     * The constructor for this class. Creates an empty Playlist
     * Object.
     *
     * @param name, the name of the playlist to be 
     * created
     * 
     * @return null
     */
	public Playlist(String name) {
		this.playlist = name;
		this.playlistSongs = new ArrayList<Song>();
		this.sortedSongs = new TreeMap<String, Song>();
	}
	
	/*
     * A constructor for this class. Creates aPlaylist
     * Object containing a list of song objects.
     *
     * @param name, the name of the playlist to be 
     * created.
     * 
     * @return null
     */
	public Playlist(String name, List<Song> contents) {
		this.playlist = name;
		this.playlistSongs = contents;
	}
	
	/*
     * This method returns the name of a playlist object.
     * 
     * @return playlist, A string representing the name
     * of a playlist object.
     */
	public String getName() {
		return playlist;
	}
	
	/*
     * This method adds a song to a playlist.
     * 
     * @return null
     */
	public void addSong(Song song) {
		if (song instanceof Song) {
			playlistSongs.add(song);
		}
	}
	
	/*
     * A private helper method I created to sort the
     * songs inside playlists.
     * 
     * @return null
     */
	private void sortSongs() {
		for (Song song : playlistSongs) {
			sortedSongs.put(song.getTitle(), song);
		}
	}
	
	/*
     * This method plays a playlist by printing
     * every song in the playlist using the song
     * attribute toString().
     * 
     * @return null
     */
	public void play() {
		sortSongs();
		for (Song song : sortedSongs.values()) {
			song.play();
		}
	}
	
	/*
     * This method removes a song from a playlist.
     * 
     * @return null
     */
	public void removeSong(Song song) {
		for (Song checkSong : playlistSongs) {
			if (checkSong.equals(song)) {
				playlistSongs.remove(song);
			}
		}
	}
}
