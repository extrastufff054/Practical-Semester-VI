import java.util.List;
import java.util.stream.Collectors;


public interface Filter<T> {
    List<T> doFilter(List<T> items, FilterParams params);
}
