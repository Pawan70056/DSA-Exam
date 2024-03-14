// Discuss ant colony algorithm and implement it to find shortest path within connected graph.

// Answer:

// Ant Colony Optimization (ACO):

// Ant Colony Optimization (ACO) is a metaheuristic optimization algorithm inspired by the foraging behavior 
// of ants. It is particularly effective for solving combinatorial optimization problems such as the 
// Traveling Salesman Problem (TSP) or the shortest path problem.

// In ACO, artificial ants construct solutions to the optimization problem by iteratively building paths 
// through the problem space. These paths are guided by pheromone trails, which represent the quality of 
// solutions found so far. Ants probabilistically choose the next component of their path based on both 
// the pheromone trail strength and the heuristic information (e.g., distance between cities).

// As ants explore the solution space, they deposit pheromone on the paths they traverse. This pheromone 
// evaporates over time, preventing the algorithm from prematurely converging to suboptimal solutions. 
// Over multiple iterations, the pheromone trails gradually converge towards better solutions.

// Implementation of Ant Colony Optimization for Shortest Path Finding in a Connected Graph:

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class qno27AntColonyShortestPath {
    private int numAnts;
    private double[][] graph;
    private double[][] pheromones;
    private double alpha;
    private double beta;
    private double evaporationRate;
    private int numIterations;
    private int numNodes;
    private List<Integer> bestPath;
    private double bestPathLength;

    public qno27AntColonyShortestPath(int numAnts, double[][] graph, double alpha, double beta, double evaporationRate, int numIterations) {
        this.numAnts = numAnts;
        this.graph = graph;
        this.alpha = alpha;
        this.beta = beta;
        this.evaporationRate = evaporationRate;
        this.numIterations = numIterations;
        this.numNodes = graph.length;
        this.pheromones = new double[numNodes][numNodes];
        initializePheromones();
        this.bestPath = new ArrayList<>();
        this.bestPathLength = Double.POSITIVE_INFINITY;
    }

    private void initializePheromones() {
        double initialPheromone = 1.0 / numNodes;
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                pheromones[i][j] = initialPheromone;
            }
        }
    }

    public void solve() {
        for (int iter = 0; iter < numIterations; iter++) {
            List<List<Integer>> antPaths = constructAntPaths();
            updatePheromones(antPaths);
            updateBestPath(antPaths);
        }
    }

    private List<List<Integer>> constructAntPaths() {
        List<List<Integer>> antPaths = new ArrayList<>();
        for (int ant = 0; ant < numAnts; ant++) {
            int startNode = new Random().nextInt(numNodes);
            List<Integer> path = new ArrayList<>();
            path.add(startNode);
            boolean[] visited = new boolean[numNodes];
            visited[startNode] = true;

            for (int i = 0; i < numNodes - 1; i++) {
                int currentNode = path.get(i);
                int nextNode = selectNextNode(currentNode, visited);
                path.add(nextNode);
                visited[nextNode] = true;
            }
            antPaths.add(path);
        }
        return antPaths;
    }

    private int selectNextNode(int currentNode, boolean[] visited) {
        double[] probabilities = new double[numNodes];
        double totalProbability = 0.0;

        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                probabilities[i] = Math.pow(pheromones[currentNode][i], alpha) * Math.pow(1.0 / graph[currentNode][i], beta);
                totalProbability += probabilities[i];
            }
        }

        double rand = Math.random() * totalProbability;
        double cumulativeProbability = 0.0;

        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                cumulativeProbability += probabilities[i];
                if (cumulativeProbability >= rand) {
                    return i;
                }
            }
        }
        return -1; // should not reach here
    }

    private void updatePheromones(List<List<Integer>> antPaths) {
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                pheromones[i][j] *= (1.0 - evaporationRate); // Evaporation
            }
        }

        for (List<Integer> path : antPaths) {
            double pathLength = getPathLength(path);
            for (int i = 0; i < numNodes - 1; i++) {
                int currentNode = path.get(i);
                int nextNode = path.get(i + 1);
                pheromones[currentNode][nextNode] += 1.0 / pathLength; // Pheromone deposition
                pheromones[nextNode][currentNode] += 1.0 / pathLength; // Pheromone deposition
            }
        }
    }

    private double getPathLength(List<Integer> path) {
        double length = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            length += graph[path.get(i)][path.get(i + 1)];
        }
        return length;
    }

    private void updateBestPath(List<List<Integer>> antPaths) {
        for (List<Integer> path : antPaths) {
            double pathLength = getPathLength(path);
            if (pathLength < bestPathLength) {
                bestPathLength = pathLength;
                bestPath = new ArrayList<>(path);
            }
        }
    }

    public List<Integer> getBestPath() {
        return bestPath;
    }

    public double getBestPathLength() {
        return bestPathLength;
    }

    public static void main(String[] args) {
        // Example usage
        int numNodes = 5;
        double[][] graph = {
                {0, 10, 15, 20, 25},
                {10, 0, 35, 25, 30},
                {15, 35, 0, 30, 10},
                {20, 25, 30, 0, 15},
                {25, 30, 10, 15, 0}
        };
        int numAnts = 10;
        double alpha = 1.0;
        double beta = 2.0;
        double evaporationRate = 0.5;
        int numIterations = 1000;

        qno27AntColonyShortestPath antColony = new qno27AntColonyShortestPath(numAnts, graph, alpha, beta, evaporationRate, numIterations);
        antColony.solve();

        System.out.println("Best path length: " + antColony.getBestPathLength());
        System.out.println("Best path: " + antColony.getBestPath());
    }
}
