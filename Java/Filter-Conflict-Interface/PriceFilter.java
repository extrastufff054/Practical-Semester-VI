import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter implements Filter<Product> {
    @Override
    public List<Product> doFilter(List<Product> products, FilterParams params) {
        double minPrice = params.getMinPrice();
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }
}