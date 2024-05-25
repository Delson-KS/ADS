import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<T>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (!(object instanceof Vertex<?> vertex)) return false;

        return Objects.equals(getData(), vertex.getData()) && Objects.equals(getAdjacentVertices(), vertex.getAdjacentVertices());
    }

}