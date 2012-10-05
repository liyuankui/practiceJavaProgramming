package lyk.practice.datastructure.graph;

import lyk.practice.datastructure.ImmutableQueueBasedOnImmutableStack;
import lyk.practice.datastructure.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/4/12
 * Time: 2:47 PM
 * The AdjacencyLinkedListGraph class is intended to fulfil some duties.
 */
public class AdjacencyLinkedListGraph<T> implements Graph<T> {

    LinkedList<LinkedList<Integer>> vertices;
    LinkedList<T> values;
    int count = 0;

    public AdjacencyLinkedListGraph() {
        vertices = new LinkedList<LinkedList<Integer>>();
        values = new LinkedList<T>();
    }

    @Override
    public int vertexCount() {
        return count;
    }

    @Override
    public int newVertex(T value) {
        LinkedList<Integer> vertex = new LinkedList<Integer>();
        values.append(value);
        vertices.append(vertex);
        return count++;
    }

    @Override
    public T getValue(int vertex) {
        return values.getValueAt(vertex);
    }

    @Override
    public boolean delVertex(int vertex) {
        return false;
    }

    @Override
    public void traverse() {
        int[] visited = new int[count];
        int left = count;
        ImmutableQueueBasedOnImmutableStack<Integer> stack = new ImmutableQueueBasedOnImmutableStack<Integer>();
        stack = stack.enqueue(0);
        while (stack.size() > 0) {
            int v = stack.peek();
            stack = stack.dequeue();

            if (visited[v] == 1) continue;
            visited[v] = 1;

            LinkedList<Integer> vertex = vertices.getValueAt(v);
            System.out.println(values.getValueAt(v));


            Object[] adjacentVertices = vertex.values();
            for (int i = 0; i < vertex.size(); i++) {
                stack = stack.enqueue((Integer) adjacentVertices[i]);
            }

        }


    }

    @Override
    public boolean connect(int start, int end) {
        vertices.getValueAt(start).append(end);
        return false;
    }


    public static void main(String[] args) {
        AdjacencyLinkedListGraph<String> g = new AdjacencyLinkedListGraph<String>();
        int a = g.newVertex("ONE");
        int b = g.newVertex("B");
        int c = g.newVertex("C");
        int d = g.newVertex("D");

        g.connect(a, b);
        g.connect(a, c);
        g.connect(c, b);
        g.connect(c, d);
        g.traverse();

    }

}
