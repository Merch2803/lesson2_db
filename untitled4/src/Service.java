import java.util.Collection;

public interface Service<T> {

    void update(Box object);

    boolean add(T object);
}
