package dataStructure.graph;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 18:59
 */
public class Main {
    public static void main(String[] args) {

        UndirectedGraph<String> graph = new UndirectedGraph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addVertex("Jack");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        System.out.println(graph.getAdjVertices("Rob"));
        System.out.println(GraphTraverse.depthFirstTraversal(graph, "Rob"));
        System.out.println(GraphTraverse.breadthFirstTraverse(graph, "Rob"));
    }
}
