import java.util.List;
import java.util.stream.Collectors;

public class AvailabilityFilter implements Filter<Product> {
    @Override
    public List<Product> doFilter(List<Product> products, FilterParams params) {
        boolean includeOutOfStock = params.isIncludeOutOfStock();
        return products.stream()
                .filter(p -> includeOutOfStock || p.isInStock())
                .collect(Collectors.toList());
    }
}