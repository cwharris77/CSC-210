/*
* AUTHOR: Cooper Harris
* FILE: WordSearch.java
* ASSIGNMENT: Programming Assignment 1 - WordSearch
* COURSE: CSc 210; Section 001; Spring 2022
* PURPOSE: This program reads in two text files, one which contains a dictionary 
* of accepted words and the other holding a grid of letters that will be 
* searched for the accepted words. The program takes thesse input files
* and automatically searches for and prints any valid words it finds, in the 
* order they are found.
* USAGE: 
* java PA1Main infile, infile2
*
* where infile is the name of an input file in the following format
*
* ----------- EXAMPLE INPUT -------------
* Input file:
* -------------------------------------------
*Aarhus
*Aaron
*Ababa
*aback
*abaft
*abandon
*abandoned
*abandoning
*abandonment
*abandons
*abase

* and infile2 is the name of an input file in the following format
* ----------- EXAMPLE INPUT -------------
* Input file:
* -------------------------------------------
*6
*6
*y c o d e j
*h s e y p k
*l p h b w a
*l o b w x z
*w o b a a i
*p l y y c g
*
*infile 1 may use any combination of letters or symbols that the user wants
*but they must be strings.
*infile2 starts with two lines of numeric string input that specify number of
*rows, then number of columns. After this the grid may be composed of any 
*string symbols as long as it matched the specified width and height.
* the input is well-formed, and matches the format shown above.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearch {
    /*
     * This is how you declare constants in Java. You can now type
     * 'MIN_WORD_LENGTH' anywhere you want to refer to it.
     */
    private static final int MIN_WORD_LENGTH = 3;

    public static void main(String[] args) throws FileNotFoundException {
        String[][] wordGrid = WordSearch.readFile(args);
        ArrayList<String> validWords = WordSearch.wordsDict(args);
        int i = 0, j = 0;
        int numRow = wordGrid.length, numCol = wordGrid[0].length;
        /*
         * checking in the desired order with a for loop, r->l, l->r, t->b, b->t
         */
        for (i = 0; i < numRow; i++) {
            String checkStr = "";
            for (j = 0; j < numCol; j++) {
                checkStr += wordGrid[i][j];
            }
            WordSearch.checkWord(checkStr, validWords);
        }
        for (i = 0; i < numRow; i++) {
            String checkStr = "";
            for (j = numCol - 1; j >= 0; j--) {
                checkStr += wordGrid[i][j];
            }
            WordSearch.checkWord(checkStr, validWords);
        }
        for (j = 0; j < numCol; j++) {
            String checkStr = "";
            for (i = 0; i < numRow; i++) {
                checkStr += wordGrid[i][j];
            }
            WordSearch.checkWord(checkStr, validWords);
        }
        for (j = 0; j < numCol; j++) {
            String checkStr = "";
            for (i = numRow - 1; i >= 0; i--) {
                checkStr += wordGrid[i][j];
            }
            WordSearch.checkWord(checkStr, validWords);
        }
    }

    /*
     * A helper method that returns a 2D String that contains the [row][column]
     * letters.
     *
     * @param args, the files passed in by the user
     * 
     * @return wordGrid, the newly created grid of strings that will be searched
     * from.
     */
    public static String[][] readFile(String[] args)
            throws FileNotFoundException {
        Scanner gridScanner = new Scanner(new File(args[1]));
        /*
         * numRow, number of rows the grid has
         * numCol, number of columns
         */
        int numRow = Integer.valueOf(gridScanner.nextLine());
        int numCol = Integer.valueOf(gridScanner.nextLine());
        String[][] wordGrid = new String[numRow][numCol];
        wordGrid = new String[numRow][numCol];
        int i = 0;
        int j = 0;
        /*
         * looping through the word grid adding one letter at a time
         * i represents rows j represents columns
         */
        while (gridScanner.hasNext()) {
            wordGrid[i][j] = gridScanner.next();
            j++;
            if (j == numCol) {
                i++;
                j = 0;
            }
        }
        gridScanner.close();

        return wordGrid;
    }

    /*
     * A helper method that returns an ArrayList containing all valid words from
     * infile.
     *
     * @param args, the files passed in by the user
     * 
     * @return validWords, the ArrayList of valid words.
     */
    public static ArrayList<String> wordsDict(String[] args)
            throws FileNotFoundException {
        Scanner dictScanner = new Scanner(new File(args[0]));
        ArrayList<String> validWords = new ArrayList<String>();

        while (dictScanner.hasNext()) {
            validWords.add(dictScanner.nextLine().toLowerCase());
        }

        dictScanner.close();

        return validWords;
    }

    /*
     * A helper method that checks the created grid of letters for valid words
     * in
     * order: left->right, right->left, top->bottom, bottom->top. It prints
     * any words it finds as it finds them.
     *
     * @param line, a string of letters from the grid to check for words
     * 
     * @param validWords, the ArrayList of valid words
     * 
     * @return void
     */
    public static void checkWord(String checkStr,
            ArrayList<String> validWords) {
        String word = null;
        for (int i = 0; i < checkStr.length(); i++) {
            /*
             * checking for valid words in min range 3
             * using substring. Once inner loop has finsihed
             * outer loop moves i one letter closer to begin
             * checking again
             */
            for (int j = i + 3; j <= checkStr.length(); j++) {
                word = checkStr.substring(i, j).toLowerCase();

                if ((word.length() >= MIN_WORD_LENGTH)
                        && (validWords.contains(word))) {
                    System.out.println(word);
                }
            }
        }
    }
}
