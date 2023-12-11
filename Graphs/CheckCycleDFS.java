package Graphs;

// Detect cycle in a DIRECTED graph using DFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 
class CheckCycleDFS {

    // graph using adjacency list representation
    // it is more convenient than adjacency binary matrix, which will be SPARSE
    // drawback is that it cannot save weights info 
    private final int V;
    private final List<List<Integer> > adj;
 
    public CheckCycleDFS(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);
 
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }
 
    // Function to check if cycle exists
    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack)
    {
        /**
         * i is the index of the current node
         * visited is a boolean array 
         * recStack should behave like a stack
         */
 
        if (recStack[i])
            return true;
 
        if (visited[i]) // if already visited means no cycles?
            return false;

        // Mark the current node as visited and
        // part of recursion stack
        visited[i] = true;
 
        recStack[i] = true;
        // adj is adjacency list
        List<Integer> children = adj.get(i);
 
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        // remove i from the stack, after having examined all the children
        // it means that node i is no more in this recursion!!!
        recStack[i] = false;
 
        return false;
    }
 
    private void addEdge(int source, int dest)
    {
        adj.get(source).add(dest);
    }
 
    // Returns true if the graph contains a
    // cycle, else false.
    private boolean isCyclic()
    {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
 
        // Call the recursive helper function to
        // detect cycle in different DFS trees
        // Just if the tree in disconnected!!
        // for (int i = 0; i < V; i++)
        int i = 0;
        if (isCyclicUtil(i, visited, recStack))
            return true;
 
        return false;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        CheckCycleDFS graph = new CheckCycleDFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
 
        // Function call
        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                               + "contain cycle");
    }
}
