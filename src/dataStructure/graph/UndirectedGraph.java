package dataStructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 18:25
 */
public class UndirectedGraph<E> {

    private Map<E, List<E>> adjVertices;

    public UndirectedGraph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(E label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }

    public void removeVertex(String label) {
        adjVertices.values().stream().forEach(e -> e.remove(label));
        adjVertices.remove(label);
    }

    public void addEdge(E vertex1, E vertex2) {
        System.out.println(vertex1 + " " + vertex2);
        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }

    public void removeEdge(E vertex1, E vertex2) {
        List<E> list1 = adjVertices.get(vertex1);
        List<E> list2 = adjVertices.get(vertex2);
        if (list1 != null) {
            list1.remove(vertex2);
        }
        if (list2 != null) {
            list2.remove(vertex1);
        }
    }

    public List<E> getAdjVertices(E vertex) {
        return adjVertices.get(vertex);
    }
}
