/*
 * AUTHOR: Cooper Harris
 * FILE: PA11Main.java
 * PURPOSE: To create solutions to the traveling salesman problem using three
 * different algorithms.
 * 
 * USAGE: Takes input from the command line in the form: 
 * PathTo/infile.mtx [HEURISTIC, BACKTRACK, MINE, TIME]
 * where the second command is one from the list on the right hand side.  
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA11Main {
    /*
     * PURPOSE: This class was taken from the given example webpage
     * and used to create a reader to read in .mtx files.
     */
    public static class MTXReader {
        private String typecode;
        private Double[][] matrix;
        
        public void read(String filename) throws java.io.IOException {
            FileInputStream input = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(input));
            
            // read type code initial line
            String line = br.readLine();
            typecode = line;
            
            // read comment lines if any
            boolean comment = true;
            while (comment) {
                line = br.readLine();
                comment = line.startsWith("%");
            }
            
            // line now contains the size information which needs to be parsed
            String[] str = line.split("( )+");
            int nRows = (Integer.valueOf(str[0].trim())).intValue();
            int nColumns = (Integer.valueOf(str[1].trim())).intValue();
            // int nNonZeros = (Integer.valueOf(str[2].trim())).intValue();
            
            // now we're into the data section
            matrix = new Double[nRows][nColumns];
            while (true) {
                line = br.readLine();
                if (line == null)  break;
                str = line.split("( )+");
                int i = (Integer.valueOf(str[0].trim())).intValue();
                int j = (Integer.valueOf(str[1].trim())).intValue();
                double x = (Double.valueOf(str[2].trim())).doubleValue();
                matrix[i-1][j-1] = x;
            }
            br.close();
        }
        
        public String getTypeCode() {
            return this.typecode;
        }   
    }
        
    public static void main(String[] args) throws IOException {
        MTXReader reader = new MTXReader();
        reader.read(args[0]);

        Double[][] matrix = reader.matrix;
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int numNodes = numRows;

        DGraph graph = new DGraph(numNodes);
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] != null) {
                    graph.addEdge(i+1, j+1, matrix[i][j]);
                }
            }
        }

        if (args[1].equals("HEURISTIC")) {
            Trip trip = heuristic(numNodes, graph);
            System.out.println(trip.toString(graph));
        } else if (args[1].equals("BACKTRACK")) {
            Trip trip = backtrack(numNodes, graph);
            System.out.println(trip.toString(graph));
        } else if (args[1].equals("MINE")) {
            Trip trip = mine(numNodes, graph);
            System.out.println(trip.toString(graph));
        } else if (args[1].equals("TIME")) {
            time(numNodes, graph);
        }
        
    }

    /*
     * The Heuristic solution to the problem. Finding the distance
     * between neighboring cities and choosing the shortest route. May
     * not be the shortest route possible.
     * 
     * @param numCities - The number of cities in the graph
     * 
     * @param graph - The graph to find a path for
     * 
     * @return myTrip - the first found trip to all cities
     */
    public static Trip heuristic(int numCities, DGraph graph) {
        Trip myTrip = new Trip(numCities);
        myTrip.chooseNextCity(1);
        int currentCity = 1;
        int holderNeighbor = graph.getNeighbors(currentCity).get(0);
        
        for (int i = 2; i <= numCities; i++) {
            for (int neighbor : graph.getNeighbors(currentCity)) {
                if (myTrip.isCityAvailable(neighbor)) {
                    if (graph.getWeight(currentCity, holderNeighbor) == -1
                            || graph.getWeight(currentCity, neighbor) < graph
                                    .getWeight(currentCity, holderNeighbor))
                    holderNeighbor = neighbor;
                }
            }
            myTrip.chooseNextCity(holderNeighbor);
            currentCity = holderNeighbor;
        }

        return myTrip;
    }

    /*
     * The recursive backtracking solution. Finding the shortest path
     * possible.
     * 
     * @param numNodes - The number of nodes in the graph
     * 
     * @param graph - The graph to find a path for
     * 
     * @return finalTrip - the shortest trip to all cities
     */
    public static Trip backtrack(int numNodes, DGraph graph) {
        Trip myTrip = new Trip(numNodes);
        myTrip.chooseNextCity(1);
        Trip finalTrip = new Trip(numNodes);

        backtrackHelper(graph, myTrip, finalTrip);
        ;

        return finalTrip;
    }

    /*
     * The helper function for the recursive backtracking. Handles
     * the actual recursion and finding of paths.
     * 
     * @param graph - The graph to find a path for
     * 
     * @param soFar - The current trip so far
     * 
     * @param minTrip - The smallest trip found
     * 
     * @return null
     */
    public static void backtrackHelper(DGraph graph, Trip soFar, Trip minTrip) {
        if (soFar.citiesLeft().isEmpty()) {
            if (soFar.tripCost(graph) < minTrip.tripCost(graph)) {
                minTrip.copyOtherIntoSelf(soFar);
            }
            return;
        }
        if (soFar.tripCost(graph) < minTrip.tripCost(graph)) {
            for (int city : soFar.citiesLeft()) {
                soFar.chooseNextCity(city);
                backtrackHelper(graph, soFar, minTrip);
                soFar.unchooseLastCity();
            }
        }
    }

    /*
     * My implementation of recursive backtracking
     * with more pruning to speed up the algorthim.
     * 
     * @param numNodes - The number of nodes in the graph
     * 
     * @param graph - The graph to find a path for
     * 
     * @return finalTrip - the shortest route to every node
     */
    public static Trip mine(int numNodes, DGraph graph) {
        Trip myTrip = new Trip(numNodes);
        myTrip.chooseNextCity(1);
        Trip finalTrip = new Trip(numNodes);

        myHelper(graph, myTrip, finalTrip);

        return finalTrip;
    }

    /*
     * The helper function for my recursive backtracking with
     * more pruning to speed it up. Handles
     * the actual recursion and finding of paths.
     * 
     * @param graph - The graph to find a path for
     * 
     * @param soFar - The current trip so far
     * 
     * @param minTrip - The smallest trip found
     * 
     * @return null
     */
    public static void myHelper(DGraph graph, Trip soFar, Trip minTrip) {
        if (soFar.citiesLeft().isEmpty()) {
            if (soFar.tripCost(graph) < minTrip.tripCost(graph)) {
                minTrip.copyOtherIntoSelf(soFar);
            }
            return;
        }

        if (soFar.tripCost(graph) < minTrip.tripCost(graph) - .5) {
            for (int city : soFar.citiesLeft()) {
                soFar.chooseNextCity(city);
                myHelper(graph, soFar, minTrip);
                soFar.unchooseLastCity();
            }
        }
    }

    /*
     * The time command function. Prints the times taken
     * for each solution to the traveling salesman
     * 
     * @param numNodes - The number of nodes in the graph
     * 
     * @param graph - The graph to find a path for
     * 
     * @return null
     */
    public static void time(int numNodes, DGraph graph) {
        long startTime = System.nanoTime();
        Trip trip = heuristic(numNodes, graph);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("heuristic: cost = " + trip.tripCost(graph) + ", "
                + duration + " milliseconds");

        long startTimeMine = System.nanoTime();
        Trip tripMine = mine(numNodes, graph);
        long endTimeMine = System.nanoTime();
        long durationMine = (endTimeMine - startTimeMine) / 1000000;
        System.out.println("mine: cost = " + tripMine.tripCost(graph) + ", "
                + durationMine + " milliseconds");

        long startTimeBack = System.nanoTime();
        Trip tripBack = backtrack(numNodes, graph);
        long endTimeBack = System.nanoTime();
        long durationBack = (endTimeBack - startTimeBack) / 1000000;
        System.out.println("backtrack: cost = " + tripBack.tripCost(graph)
                + ", " + durationBack + " milliseconds");

    }

}

