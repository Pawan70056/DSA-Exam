// Implement and trace Prism algorithm

// Answer::


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge1 = new Edge(src, dest, weight);
        Edge edge2 = new Edge(dest, src, weight);
        adjList.get(src).add(edge1);
        adjList.get(dest).add(edge2);
    }

    public void prismAlgorithm(int startVertex) {
        boolean[] mstSet = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[startVertex] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.add(new Edge(-1, startVertex, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.dest;

            if (mstSet[u]) continue;

            mstSet[u] = true;

            for (Edge next : adjList.get(u)) {
                int v = next.dest;
                int weight = next.weight;
                if (!mstSet[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Edge(u, v, weight));
                }
            }
        }

        // Print the MST
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(i + " - " + key[i]);
        }
    }
}

public class qno23Main {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Start vertex is 0
        graph.prismAlgorithm(0);
    }
}
