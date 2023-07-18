import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PA5Main {
    /*
     * AUTHOR: Cooper Harris
     * FILE: PA5Main.java
     * ASSIGNMENT: Programming Assignment 5 - Garden
     * COURSE: CSc 210; Section A; Spring 2022
     * PURPOSE: This program reads in a text file which contains information to
     * initialize a Garden object and specify commands to be processed on
     * that Garden object. The Garden consists of Plant objects, and there
     * are 3 sub classes of Plants (Tree, Flower, Vegetable). Plants
     * can be grown, removed, or planted. The Garden can be printed.
     *
     * USAGE:
     * java PA5Main infile
     *
     * where infile is the name of an input file in the following format
     *
     * ----------- EXAMPLE INPUT -------------
     * Input file:
     * -------------------------------------------
     * | rows: 3
     * | cols: 10
     * |
     * | PLANT (0, 0) banana
     * | PRINT
     * | GROW 2
     * | GROW 4 (1, 3)
     * | GROW 1 vegetable
     * | GROW 1 lily
     * | HARVEST
     * | HARVEST (2, 3)
     * | HARVEST garlic
     * | PICK
     * | PICK (4, 3)
     * | PICK rose
     * | CUT
     * | CUT (5, 2)
     * | CUT pine
     * -------------------------------------------
     *
     * The commands shown above are all of the commands that are supported
     * by this program. It is assumed that (except for some specific errors),
     * the input is well-formed, and matches the format shown above.
     */


    public static void main(String[] args) throws FileNotFoundException {
        List<String> commandsList = readFile(args[0]);

        // System.out.println(commandsList.toString());

        int row = Integer.valueOf(commandsList.get(0)
                .substring(commandsList.get(0).length() - 1));
        int col = Integer.valueOf(commandsList.get(1)
                .substring(commandsList.get(1).length() - 1));


        for (int i = 2; i < commandsList.size(); i++) {
            String[] command = commandsList.get(i).toLowerCase().split(" ");

        }

    }

    /*
     * This method reads the infile and returns
     * a list of commands found
     * 
     * @return commandsList: ArrayList containing
     * file commands
     */
    public static List<String> readFile(String file)
            throws FileNotFoundException {
        Scanner commands = new Scanner(new File(file));
        List<String> commandsList = new ArrayList<>();

        while (commands.hasNext()) {
            commandsList.add(commands.nextLine());

        }
        for (int i = 0; i < commandsList.size(); i++) {
            if (commandsList.get(i).equals("")) {
                commandsList.remove(i);
            }
        }

        commands.close();
        return commandsList;
    }

}
