package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class WeightedGraph<E> {
    VertexList<E>[] adjacentList;
    int vertexCount;

    public WeightedGraph(E[] values) {
        this.adjacentList = new VertexList[values.length];
        this.vertexCount = values.length;
        for (int i = 0; i < vertexCount; i++) {
            adjacentList[i] = new VertexList<>(values[i]);
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacentList[source].add(destination, weight);
        adjacentList[destination].add(source, weight);
    }

    public void addDestination(int source, int destination, int weight) {
        adjacentList[source].add(destination, weight);
    }

    void print() {
        for (int i = 0; i < adjacentList.length; i++) {
            System.out.print(i + ":" + adjacentList[i].value + " -> ");
            for (Vertex v : adjacentList[i].list) {
                System.out.print(v.v + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print("BFS");
        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(" -> " + u + ":" + adjacentList[u].value);
//            LinkedList<Integer> adjList = adjacentList[u].list;
            for (Vertex v : adjacentList[u].list) {
                if (visited[v.v] == false) {
                    visited[v.v] = true;
                    queue.add(v.v);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        System.out.print("DFS");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(" -> " + v + ":" + adjacentList[v].value);
        for (Vertex x : adjacentList[v].list) {
            if (visited[x.v] == false) {
                dfsUtil(x.v, visited);
            }
        }
    }

    public void primMST() {
        int[] costs = new int[vertexCount];
        Arrays.fill(costs, Integer.MAX_VALUE);

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        HashSet<Integer> noVisited = new HashSet<>();

        for (int i = 0; i < vertexCount; i++) {
            noVisited.add(i);
        }

        priorityQueue.add(new Vertex(0, 0));
        int mstWeight = 0;
        System.out.print("Prim MST: ");

        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll();
            int u = vertex.v;
            if(!noVisited.contains(u)){
                continue;
            }
            noVisited.remove(u);
            mstWeight += vertex.weight;

            System.out.print(adjacentList[u].value + ":" + vertex.weight + " -> ");
            for (Vertex e : adjacentList[u].list){
                int v = e.v;
                if(noVisited.contains(v) && e.weight<costs[v]){
                    costs[v] = e.weight;
                    priorityQueue.add(new Vertex(v, e.weight));
                }
            }
        }
        System.out.println("최소 비용: " +mstWeight);
    }

    public void kruskalMST() {
        // 1. 모든 간선 수집
        LinkedList<Edge> edges = new LinkedList<>();
        boolean[][] seen = new boolean[vertexCount][vertexCount];
        for (int u = 0; u < vertexCount; u++) {
            for (Vertex v : adjacentList[u].list) {
                if (!seen[u][v.v] && !seen[v.v][u]) {
                    edges.add(new Edge(u, v.v, v.weight));
                    seen[u][v.v] = true;
                    seen[v.v][u] = true;
                }
            }
        }

        // 2. 간선 정렬 (오름차순)
        edges.sort((a, b) -> Integer.compare(a.weight, b.weight));

        // 3. Union-Find 구조 초기화
        int[] parent = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) parent[i] = i;

        int mstWeight = 0;
        System.out.println("Kruskal MST:");

        for (Edge e : edges) {
            int rootU = find(parent, e.u);
            int rootV = find(parent, e.v);

            if (rootU != rootV) {
                union(parent, rootU, rootV);
                mstWeight += e.weight;
                System.out.println("\t" + adjacentList[e.u].value + " - " + adjacentList[e.v].value + " : " + e.weight);
            }
        }

        System.out.println("Kruskal MST 최소 비용: " + mstWeight);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY)
            parent[rootY] = rootX;
    }

    static class Edge {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private static class Vertex implements Comparable<Vertex>{
        int v;
        int weight;

        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static class VertexList<E> {
        E value;
        LinkedList<Vertex> list;

        public VertexList(E value) {
            this.value = value;
            this.list = new LinkedList<>();
        }

        public void add(int v, int weight) {
            list.add(new Vertex(v, weight));
        }
    }


}

