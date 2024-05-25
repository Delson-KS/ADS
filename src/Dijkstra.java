import java.util.*;

public class Dijkstra<V> extends Search<V> {
    private Map<V, Double> distances = new HashMap<>();

    public Dijkstra(WeightedGraph<V> graph, V source) {
        super(source);

        for (V v : graph.getVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);

        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<V> graph) {

        while (true) {
            V currentVertex = null;
            double minDist = Double.POSITIVE_INFINITY;

            for (V v : distances.keySet()) {
                if (!marked.contains(v) && distances.get(v) < minDist) {
                    currentVertex = v;
                    minDist = distances.get(v);
                }
            }

            if (currentVertex == null) {
                break;
            }

            marked.add(currentVertex);

            for (V v : graph.getAdjacentVertices(currentVertex)) {
                if (!marked.contains(v)) {
                    double newDist = distances.get(currentVertex) + graph.getWeight(currentVertex, v);
                    if (newDist < distances.get(v)) {
                        distances.put(v, newDist);
                        edgeTo.put(v, currentVertex);
                    }
                }
            }
        }
    }
}
