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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class qno27AntColonyShortestPath {
    private int numOfNodes;
    private double[][] graph;
    private int numOfAnts;
    private double[][] pheromoneMatrix;
    private double alpha; // Pheromone importance factor
    private double beta; // Heuristic importance factor
    private double evaporationRate;
    private int source;
    private int destination;
    private int maxIterations;

    public qno27AntColonyShortestPath(int numOfNodes, double[][] graph, int numOfAnts, double alpha, double beta, double evaporationRate, int source, int destination, int maxIterations) {
        this.numOfNodes = numOfNodes;
        this.graph = graph;
        this.numOfAnts = numOfAnts;
        this.alpha = alpha;
        this.beta = beta;
        this.evaporationRate = evaporationRate;
        this.source = source;
        this.destination = destination;
        this.maxIterations = maxIterations;
        
        // Initialize pheromone matrix
        pheromoneMatrix = new double[numOfNodes][numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            Arrays.fill(pheromoneMatrix[i], 1.0); // Initialize with equal pheromone level
        }
    }

    public List<Integer> findShortestPath() {
        List<Integer> shortestPath = new ArrayList<>();
        double shortestDistance = Double.MAX_VALUE;
        
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            List<List<Integer>> antPaths = constructPaths();
            updatePheromone(antPaths);
            
            // Update shortest path if a better one is found
            for (List<Integer> path : antPaths) {
                double distance = calculateDistance(path);
                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    shortestPath = new ArrayList<>(path);
                }
            }
            
            evaporatePheromone();
        }
        
        return shortestPath;
    }

    private List<List<Integer>> constructPaths() {
        List<List<Integer>> antPaths = new ArrayList<>();
        Random random = new Random();
        
        for (int ant = 0; ant < numOfAnts; ant++) {
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[numOfNodes];
            int currentNode = source;
            path.add(currentNode);
            visited[currentNode] = true;
            
            while (currentNode != destination) {
                int nextNode = selectNextNode(currentNode, visited, random);
                path.add(nextNode);
                visited[nextNode] = true;
                currentNode = nextNode;
            }
            
            antPaths.add(path);
        }
        
        return antPaths;
    }

    private int selectNextNode(int currentNode, boolean[] visited, Random random) {
        double[] probabilities = new double[numOfNodes];
        double totalProbability = 0.0;
        
        for (int node = 0; node < numOfNodes; node++) {
            if (!visited[node]) {
                probabilities[node] = Math.pow(pheromoneMatrix[currentNode][node], alpha) * Math.pow(1.0 / graph[currentNode][node], beta);
                totalProbability += probabilities[node];
            }
        }
        
        double randomValue = random.nextDouble() * totalProbability;
        double cumulativeProbability = 0.0;
        for (int node = 0; node < numOfNodes; node++) {
            if (!visited[node]) {
                cumulativeProbability += probabilities[node];
                if (cumulativeProbability >= randomValue) {
                    return node;
                }
            }
        }
        
        // Should not reach here
        return -1;
    }

    private void updatePheromone(List<List<Integer>> antPaths) {
        for (int i = 0; i < numOfNodes; i++) {
            for (int j = 0; j < numOfNodes; j++) {
                pheromoneMatrix[i][j] *= (1.0 - evaporationRate);
            }
        }
        
        for (List<Integer> path : antPaths) {
            double pheromoneToAdd = 1.0 / calculateDistance(path);
            for (int i = 0; i < path.size() - 1; i++) {
                int from = path.get(i);
                int to = path.get(i + 1);
                pheromoneMatrix[from][to] += pheromoneToAdd;
                pheromoneMatrix[to][from] += pheromoneToAdd; // Pheromone is symmetric
            }
        }
    }

    private void evaporatePheromone() {
        // Evaporate pheromone
    }

    private double calculateDistance(List<Integer> path) {
        double distance = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            distance += graph[path.get(i)][path.get(i + 1)];
        }
        return distance;
    }

    public static void main(String[] args) {
        // Create graph and parameters
        
        // Run ACO algorithm to find the shortest path
    }
}
