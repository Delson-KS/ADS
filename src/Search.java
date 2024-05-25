import java.util.*;

public class Search<V> {
    protected V source;
    protected Set<V> marked;
    protected Map<V, V> edgeTo;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<V> path = new Stack<>();
        for (V vertex = v; vertex != null; vertex = edgeTo.get(vertex)) {
            path.push(vertex);
        }

        return path;
    }
}
