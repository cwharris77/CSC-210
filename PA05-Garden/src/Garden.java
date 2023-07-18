import java.util.ArrayList;
import java.util.List;

/*
 * AUTHOR: Cooper Harris
 * FILE: Garden.java
 * PURPOSE: This class creates a new garden object that holds
 * the plots of plants that have been planted.
 */

public class Garden {
    private String plant;
    private int rows;
    private int cols;
    public List<String[][]> garden;

    Garden(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.garden = new ArrayList<>();

        if (5 * cols > 80) {
            System.out.print("Too many plot columns");
            System.exit(0);
        }

    }

    /*
     * This method prints the garden in its
     * currrent state
     * 
     * @return null
     */
    public void printGarden() {
        String retStr = "";
        for (int i = 0; i < garden.size(); i++) {
            retStr += garden.get(i);
        }
        System.out.println(retStr);
    }


}
