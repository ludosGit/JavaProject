package Graphs;
import java.util.Arrays;

// A Java program for Dijkstra's single source shortest path
// algorithm. The program is for adjacency matrix
// representation of the graph
// GREEDY ALGORITHM: makes a locally optimal choice in each step 
// in order to find the optimal solution

public class Dijkstra {
    // static final int V = 9; defines a constant variable V which CANNOT be modified
    // Declare an attribute
    private int V;

    // Constructor to initialize the attribute
    public Dijkstra(int initialValue) {
        this.V = initialValue;
    }

    // Getter method to retrieve the value of the attribute
    public int getV() {
        return V;
    }

    // Setter method to update the value of the attribute
    public void setV(int newValue) {
        this.V = newValue;
    }

    // A utility function to find the vertex with minimum
    // distance value, from the set of vertices not yet
    // included in shortest path tree
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value as infinite
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance
    // array
    void printPath(int parent[], int j, int src)
{
    // System.out.print(Arrays.toString(parent));
    // Base Case : If j is source
    if (parent[j]==-1)
       {System.out.println(" \t\t \t\t \t\t" + src);
       return;
}

    printPath(parent, parent[j], src);

    System.out.println(" \t\t \t\t \t\t" + j);
}

    void printSolution(int dist[], int parent[], int src)
    {
        System.out.println(
            "Vertex \t\t Distance from Source \t\t Path from Source");
        for (int i = 0; i < V; i++){
            System.out.println(i + " \t\t " + dist[i] + " \t\t");
            printPath(parent, i, src);
        }
    }
 
    // Function that implements Dijkstra's single source
    // shortest path algorithm for a graph represented using
    // adjacency matrix representation
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; // The output array.
                                 // dist[i] will hold
        // the shortest distance from src to i

        int parent[] = new int[V];
        parent[src] = -1;

        // sptSet[i] will true if vertex i is included in
        // shortest path tree or shortest distance from src
        // to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[]
        // as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to src in first iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (int v = 0; v < V; v++)
 
                // Update dist[v] only if is not in sptSet,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0
                    && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                    }
                    
        }
 
        // print the constructed distance array
        printSolution(dist, parent, src);
    }
 
    // Driver's code
    public static void main(String[] args)
    {
        /* Graph defined by adjacency sparse matrix
         */
        int graph[][]
            = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        // initialize a Dijkstra object with 9 vertices
        Dijkstra t = new Dijkstra(9);
 
        // Function call
        t.dijkstra(graph, 0);
    }
}
