package lyk.practice.datastructure;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/29/12
 * Time: 3:43 PM
 * The Graph class is intended to fulfil some duties.
 */
public interface Graph<T> {
    GraphNode<T>[] getNodes();

    GraphNode<T>[] getItsAdjacencyNodes(GraphNode<T> node);

}

class GraphNode<T> {

}

class GraphEdge {

}
