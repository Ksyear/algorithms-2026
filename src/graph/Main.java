package graph;

public class Main {
    static void main() {
        String[] values = {"철수", "영희", "동건", "준호", "재상", "승우"};
        UnweightedGraph graph = new UnweightedGraph(values);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

//        graph.print();
        graph.bfs(0);
        graph.dfs(0);
    }
}
