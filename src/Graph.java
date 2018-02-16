


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Graph {
    /* Creates a vertex with the given number. */
    public void addVertex(int num);
    
    /* Creates an edge from the first vertex to the second. */
    public void addEdge(int from, int to);

    /* Finds the egonet centered at a given node. */
    public HashMap<Integer,Integer> friendsRec (int center);

    /* Returns all SCCs in a directed graph. Recall that the warm up
     * assignment assumes all Graphs are directed, and we will only 
     * test on directed graphs. */
    
    public ArrayList<Integer> bestFriendsRec (int center, int num);
    
   // public HashMap<Integer, HashSet<Integer>> exportGraph();
} 
