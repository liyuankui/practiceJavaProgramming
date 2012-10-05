package lyk.practice.datastructure.graph;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/29/12
 * Time: 3:43 PM
 * The Graph interface is intended to fulfil some duties.
 */
public interface Graph<T> {
    // return the number of total vertices
    public int vertexCount();

    // return the # of new vertex
    public int newVertex(T value);

    // get the value of certain vertex by #
    public T getValue(int vertex);

    // remove a vertex
    public boolean delVertex(int vertex);

    // traverse the graph
    public void traverse();

    // connect vertices
    public boolean connect(int start, int end);
}

