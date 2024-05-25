import java.util.LinkedList;
import java.util.Queue;

public class BFS <V> extends Search<V> {
    public BFS(MyGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            V currentVertex = queue.poll();

            for (Vertex<V> neighbor : graph.getVertex(currentVertex).getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor.getData())) {
                    marked.add(neighbor.getData());
                    edgeTo.put(neighbor.getData(), currentVertex);
                    queue.add(neighbor.getData());
                }
            }
        }
    }
}
