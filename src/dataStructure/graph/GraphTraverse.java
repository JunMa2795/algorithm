package dataStructure.graph;

import dataStructure.queue.GenericQueue;
import dataStructure.stack.GenericStack;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 19:03
 */
public class GraphTraverse {

    public static <E> Set<E> depthFirstTraversal(UndirectedGraph<E> graph, E root) {
        Set<E> visited = new LinkedHashSet<>();
        GenericStack<E> stack = new GenericStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            E vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (E v : graph.getAdjVertices(vertex)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    public static <E> Set<E> breadthFirstTraverse(UndirectedGraph<E> graph, E root) {
        Set<E> visited = new LinkedHashSet<>();
        GenericQueue<E> queue = new GenericQueue<>();
        queue.enqueue(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            E vertex = queue.dequeue();
            for (E v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.enqueue(v);
                }
            }
        }
        return visited;
    }
}
