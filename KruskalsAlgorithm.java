import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalsAlgorithm {

    static int findParent(int vertex, int[] parent) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findParent(parent[vertex], parent); // Path compression
        }
        return parent[vertex];
    }

    static void union(int x, int y, int[] parent, int[] rank) {
        int rootX = findParent(x, parent);
        int rootY = findParent(y, parent);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void kruskalMST(int vertices, List<Edge> edges) {
        Collections.sort(edges);

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            int rootSource = findParent(edge.source, parent);
            int rootDestination = findParent(edge.destination, parent);

            if (rootSource != rootDestination) {
                mst.add(edge);
                mstWeight += edge.weight;
                union(rootSource, rootDestination, parent, rank);
            }
        }

        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edgesCount = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();

        System.out.println("Enter the edges in the format (source destination weight):");
        for (int i = 0; i < edgesCount; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(source, destination, weight));
        }

        kruskalMST(vertices, edges);

        scanner.close();
    }
}
