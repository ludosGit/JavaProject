package Graphs;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

// DFS: traversing or searching tree or graph data structures
// DFS implementation using for loops instead of stack
class DFS {

    private final int V;
    private final List<List<Integer>> adj;
    // could also write:
    // private final ArrayList<ArrayList<Integer>> adj;

    // this is the Constructor method!! special method used to initialize objects, 
    // called when an object is created, typically using the new keyword. 
    // The purpose of a constructor is to set initial values for the object's attributes 
    // or perform any other necessary setup.

    public DFS(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source); // For an undirected graph
    }

    public void dfs(int startNode) {
        boolean[] visited = new boolean[V];

        // in case of a disconnected graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                int currentNode = i;

                while (!visited[currentNode]) {
                    System.out.print(currentNode + " ");
                    visited[currentNode] = true;

                    // Find an unvisited neighbor
                    int unvisitedNeighbor = -1;
                    for (int neighbor : adj.get(currentNode)) {
                        if (!visited[neighbor]) {
                            unvisitedNeighbor = neighbor;
                            break;
                        }
                    }

                    // Move to the unvisited neighbor
                    if (unvisitedNeighbor != -1) {
                        currentNode = unvisitedNeighbor;
                    } else {
                        // Backtrack to the parent (if any) if no unvisited neighbor
                        currentNode = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS tree = new DFS(7);
        tree.addEdge(0, 1);
        tree.addEdge(0, 2);
        tree.addEdge(1, 3);
        tree.addEdge(1, 4);
        tree.addEdge(2, 5);
        tree.addEdge(2, 6);

        System.out.println("Depth First Search starting from node 0:");
        tree.dfs(0);
    }
}
