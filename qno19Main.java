// Show that Djikstra algorithm may not work if edges can have negative weight. Implement Bellman ford algorithm.

// Answer::

import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class BellmanFord {
    private int V, E;
    private List<Edge> edges;

    public BellmanFord(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public void bellmanFord(int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print shortest distances
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from source to vertex " + i + ": " + distance[i]);
        }
    }
}

public class qno19Main {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges
        BellmanFord graph = new BellmanFord(V, E);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.bellmanFord(0);
    }
}
