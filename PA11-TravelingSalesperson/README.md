heuristic: cost = 3.3969307170000005, 3 milliseconds
mine: cost = 1.3566775349999998, 32 milliseconds
backtrack: cost = 1.3566775349999998, 74 milliseconds

These are the results of my timing for backtracking versus my algorithm on big11.mxt.
I think my backtracking algorithm ran faster because i put a check before the for loop to only run the loop if the cost of the current trip was lower than the minimum trip by at least .5 seconds. This version still gets very close to the shortest path 
in the other test cases and performs much better than the other backtracking algorithm.

