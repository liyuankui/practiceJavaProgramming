package lyk.practice.datastructure.graph;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/4/12
 * Time: 3:25 PM
 * The WeightedGraph class is intended to fulfil some duties.
 */
public interface WeightedGraph<T> extends Graph<T> {

    // connect vertices with weight
    public boolean connect(int start, int end, int weight);

    // reassign the weithgt between two vertices
    public boolean reWeight(int start, int end, int weight);
}
