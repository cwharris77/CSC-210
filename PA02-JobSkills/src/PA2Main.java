/*
* AUTHOR: Cooper Harris
* FILE: JobSkills.java
* ASSIGNMENT: Programming Assignment 2 - JobSkills
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: To read a csv file and print information about the positions available in
* a company and the locations these positions are open in.
* USAGE:
* Command line arguments should be formatted as follows:
* infile COMMAND Category(if applicable)
* 
* java PA2Main infile
*
* where infile is the name of a csv file in the following format
*
* Company,Title,Category,Location,Responsibilities,Minimum Qualifications,Preferred Qualifications
* Google,TitleA,CategoryX,Tel Aviv,Everything and the rest, BS, MS
* Google,TitleB,CategoryX,Tel Aviv,Everything and the rest, BS, MS
* Google,TitleB,CategoryY,Houston,Everything and the rest, BS, MS
*
* Commands the Program supports are CATCOUNT and LOCATIONS
* CATCOUNT reads an input file and for each job "Category" prints out
* the category and the number of jobs in that category
* LOCATIONS takes a given category and lists the locations that have a 
* position in that category open. Each location will be followed by a number 
* indicating how many positions in that category are open in a particular location.
* 
* It is Assummed that all data is formatted correctly within the csv file
* 
* If an unknown command is entered the program will print the error message:
* "Invalid Command"
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PA2Main {
    /*
     * A helper method that reads in a csv file and returns a hashmap mapping
     * job category to a list of job locations for that category.
     *
     * @param args, the command line arguments passed in to the
     * program. In this case args[0] is a file
     * 
     * @return jobs, the newly created hashmap
     */
    public static Map<String, List<String>> readFile(String[] args)
            throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(args[0]));
        Map<String, List<String>> jobs = new HashMap<String, List<String>>();
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split(",");
            // getting category column from file
            List<String> newLst = jobs.get(line[2]);
            if (newLst == null) {
                newLst = new ArrayList<String>();
                jobs.put(line[2], newLst);
            }
            // mapping to Locations column
            newLst.add(line[3]);
        }
        fileScanner.close();
        return jobs;
    }

    /*
     * A helper method that takes a hashmap as an argument and prints
     * each job category found in the map along with how many positions
     * are open for that category in an alphabetized list with the format:
     * Category, numberOfJobs
     *
     * @param map, a hashmap mapping job category to job location
     * 
     * @return void
     */
    public static void catCount(Map<String, List<String>> map) {
        List<String> sortedKeys = new ArrayList<String>(map.keySet());
        Collections.sort(sortedKeys);
        System.out.println("Number of positions for each category");
        System.out.println("-------------------------------------");
        for (int i = 0; i < sortedKeys.size(); i++) {
            System.out.println(
                    sortedKeys.get(i) + ", "
                    // length of the list is number of positions
                            + map.get(sortedKeys.get(i)).size());
        }
    }

    /*
     * A helper method that takes a hashmap and prints the number of
     * jobs open in a category given as an argument. It prints the list
     * in alphabetical order in the format:
     * Location, numberOfJobs
     *
     * @param map, a hashmap mapping job category to job location
     * 
     * @param args, command line arguments passed in by the user, for
     * this method, the desired category
     * 
     * @return void
     */
    public static void location(Map<String, List<String>> map, String[] args) {
        List<String> sortedKeys = new ArrayList<String>(map.keySet());
        Collections.sort(sortedKeys);
        System.out.println("LOCATIONS for category: " + args[2]);
        System.out.println("-------------------------------------");

        Map<String, Integer> locations = new HashMap<String, Integer>();

        for (int i = 0; i < map.get(args[2]).size(); i++) {
            // checking if the location is already in the map
            Integer count = locations.get(map.get(args[2]).get(i));
            if (count == null) {
                locations.put(map.get(args[2]).get(i), 1);
            } else {
                locations.put(map.get(args[2]).get(i), count + 1);
            }
        }

        List<String> sortedLocations = new ArrayList<String>(
                locations.keySet());
        Collections.sort(sortedLocations);

        for (int i = 0; i < sortedLocations.size(); i++) {
            System.out.println(sortedLocations.get(i) + ", "
            // getting location from map in sorted order
                    + locations.get(sortedLocations.get(i)));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, List<String>> jobMap = PA2Main.readFile(args);

        if (args[1].equals("CATCOUNT")) {
            PA2Main.catCount(jobMap);
        } else if (args[1].equals("LOCATIONS")) {
            PA2Main.location(jobMap, args);
        } else {
            System.out.print("Invalid Command");
        }
    }
}

