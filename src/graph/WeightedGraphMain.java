package graph;

public class WeightedGraphMain {
    static void main() {
//        String[] values = {"철수", "영희", "동건", "준호", "재상", "승우"};
//        WeightedGraph graph = new WeightedGraph(values);
//
//        graph.addEdge(0, 1, 9);
//        graph.addEdge(0, 2, 7);
//        graph.addEdge(0, 3, 5);
//        graph.addEdge(0, 5, 6);
//        graph.addEdge(1, 2, 9);
//        graph.addEdge(2, 4, 5);
//        graph.addEdge(3, 5, 5);
//        graph.addEdge(4, 5, 1);
//
//        graph.print();
//        graph.bfs(0);
//        graph.dfs(0);
//        graph.primMST();
//        graph.kruskalMST();

        String[] values = {"A", "B", "C", "D", "E", "F", "G", "H"};
        WeightedGraph graph = new WeightedGraph(values);

        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 4, 4);
        graph.addEdge(1, 3, 4);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 4, 2);
        graph.addEdge(2, 5, 7);
        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 5, 8);
        graph.addEdge(3, 6, 5);
        graph.addEdge(4, 5, 4);
        graph.addEdge(5, 6, 5);
        graph.addEdge(5, 7, 3);
        graph.addEdge(6, 7, 6);

//        graph.bfs(0);
//        graph.dfs(0);
        graph.primMST();
        graph.kruskalMST();
    }
}
