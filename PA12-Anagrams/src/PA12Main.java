/*
* AUTHOR: Cooper Harris
* FILE: PA12Main.java
* ASSIGNMENT: Programming Assignment 12 - Anagrams
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: This program reads in a text file which contains a dictionary 
* of accepted words, a word to find anagrams for, and an integer representing
* the number of words that may be used to for each anagram. If 0 print
* all anagrams found. Uses a provided helper class to check what words
* can be found in the given anagram word.
* USAGE: 
* java PA1Main infile, anagramWord numWordsAllowed
*
* where infile is the name of an input file in the following format
*
* Example input: dict1.txt barbarabush 0
* 
* The input is assumed to be well-formed, and matches the format shown above.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PA12Main {
    public static void main(String[] args) throws FileNotFoundException {
        LetterInventory inventory = new LetterInventory(args[1]);

        ArrayList<String> wordsList = readFile(args[0]);
        ArrayList<String> wordsFound = findWords(wordsList, inventory);

        ArrayList<String> soFar = new ArrayList<>();

        System.out.println("Phrase to scramble: " + args[1] + "\n");
        System.out.println("All words found in " + args[1] + ":");
        System.out.println(wordsFound.toString() + "\n");
        System.out.println("Anagrams for " + args[1] + ":");
        findAnagrams(wordsFound, inventory, Integer.valueOf(args[2]), soFar);

    }

    /*
     * Reads the given .txt file and adds all words to an arrayList
     *
     * @param arg, A string representing a .txt file
     * 
     * @return wordsList - an ArrayList of the words in the file
     */
    public static ArrayList<String> readFile(String arg)
            throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(arg));
        ArrayList<String> wordsList = new ArrayList<>();

        while (scanner.hasNext()) {
            wordsList.add(scanner.next());
        }
        scanner.close();

        return wordsList;
    }

    /*
     * Finds all words in the dictionary that can be found in the word
     * used to make anagrams. Uses a helper class LetterInventory.
     *
     * @param list - An ArrayList of words found in the dictionary file
     * 
     * @param inventory - The letter inventory containing all letters
     * of the anagram word.
     * 
     * @return container - an ArrayList of the words found in the anagram word
     */
    public static ArrayList<String> findWords(ArrayList<String> list,
            LetterInventory inventory) {
        ArrayList<String> container = new ArrayList<>();

        for (String word : list) {
            if (inventory.contains(word)) {
                container.add(word);
            }
        }

        return container;
    }

    /*
     * Finds all words and combinations of words that are
     * anagrams of the user input word using recursive backtracking.
     *
     * @param wordsInScramble - the list of words that can be found in the given
     * word
     * 
     * @param inventory - The letter inventory containing all letters
     * of the given word.
     * 
     * @param numWordsAllowed - The number of words that can be used to form
     * an anagram
     * 
     * @param sofar - A list containing the anagram that has been found so far
     * 
     * @return void
     */
    public static void findAnagrams(ArrayList<String> wordsInScramble,
            LetterInventory inventory, int numWordsAllowed,
            ArrayList<String> soFar) {
        // This means there were no letters left to use, and an anagram was found
        if (inventory.isEmpty()) {
            System.out.println(soFar.toString());
        }
        for (int i = 0; i < wordsInScramble.size(); i++) {
            // Checking if the max amount of words have already been used
            if (!(soFar.size() == numWordsAllowed) || numWordsAllowed == 0) {
                // Choose
                soFar.add(wordsInScramble.get(i));
                String currentWord = wordsInScramble.get(i);
                // Explore
                if (inventory.contains(currentWord)) {
                    inventory.subtract(currentWord);
                    findAnagrams(wordsInScramble, inventory, numWordsAllowed,
                            soFar);
                    inventory.add(currentWord);
                }
                // Unchoose
                soFar.remove(soFar.size() - 1);
            }
        }

    }
}
