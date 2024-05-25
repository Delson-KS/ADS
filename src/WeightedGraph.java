import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<V> {
    private boolean directed;
    private Map<V, Vertex<V>> vertexMap = new HashMap<>();

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public WeightedGraph() {
        this(false);
    }

    public void addVertex(V data) {
        vertexMap.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, Double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
        }

        if (!hasVertex(dest)) {
            addVertex(dest);
        }

        getVertex(source).addAdjacentVertex(getVertex(dest), weight);

        if (!directed) {
            getVertex(dest).addAdjacentVertex(getVertex(source), weight);
        }

    }

    public boolean hasVertex(V data) {
        return vertexMap.containsKey(data);
    }

    public Vertex<V> getVertex(V data) {
        return vertexMap.get(data);
    }

    public Iterable<V> getVertices() {
        return vertexMap.keySet();
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source)) {
            return false;
        }

        return getVertex(source).getAdjacentVertices().containsKey(getVertex(dest));
    }

    public Double getWeight(V source, V dest) {
        if (!hasEdge(source, dest)) {
            return Double.POSITIVE_INFINITY;
        }

        return vertexMap.get(source).getAdjacentVertices().get(getVertex(dest));
    }

    public Iterable<V> getAdjacentVertices(V data) {
        return vertexMap.keySet();
    }
}
