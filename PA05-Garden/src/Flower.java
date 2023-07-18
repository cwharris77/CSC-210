/*
 * AUTHOR: Cooper Harris
 * FILE: Garden.java
 * PURPOSE: This class creates a new flower object and
 * allows a set of commands to be done on the flower.
 */

public class Flower extends Garden {
    private String[][] plot;
    String flower;
    int x;
    int y;

    Flower(String type, int rows, int cols) {
        super(rows, cols);
        this.flower = type;
        this.plot = new String[5][5];
        this.x = 2;
        this.y = 2;
    }

    /*
     * This method plants a new flower in the garden
     * 
     * @return null
     */
    public void plant(String flower) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                plot[i][j] = ".";
            }
        }
        plot[x][y] = flower.substring(0, 1).toLowerCase();
    }

    /*
     * This method returns the Array of the current
     * flower.
     * 
     * @return plot: A 2D Array containing the string
     * representation of the flower
     */
    public String[][] getPlot() {
        return plot;
    }

    /*
     * This method adds a plot to the garden
     * 
     * @return null
     */
    public void addPlot() {
        garden.add(this.getPlot());
    }

    /*
     * This method returns a String representation
     * of the current plot
     * 
     * @return aString: A string containing "."
     * and the letter that represents the flower
     */
    @Override
    public String toString() {
        String aString = "";

        for (int row = 0; row < plot.length; row++) {
            if (row > 0) {
                aString += "\n";
            }

            for (int col = 0; col < plot[row].length; col++) {
                aString += " " + plot[row][col];
            }
        }
        return aString;
    }

    /*
     * This method grows the current flower
     * the number of times specified by num
     * 
     * @return null
     */
    public void grow(int num) {
        for (int i = 0; i < num; i++) {
            if (x - 1 >= 0) {
                plot[x - 1][y] = plot[2][2];
                plot[x + 1][y] = plot[2][2];
                plot[x][y - 1] = plot[2][2];
                plot[x][y + 1] = plot[2][2];

            }
        }
    }



}
