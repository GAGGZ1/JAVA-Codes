import java.util.*;
import java.util.HashMap;

class Graph {
    Map<Integer, List<Integer>> adjList;

    Graph() {
        adjList = new HashMap<>();
    }

    // Add a vertex
    void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // Add an edge
    void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    // Display the graph
    void display() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
