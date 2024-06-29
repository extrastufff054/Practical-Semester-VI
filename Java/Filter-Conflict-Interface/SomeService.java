import java.util.Arrays;
import java.util.List;

public class SomeService {
    private final FilterManager<Product> filterManager;

    public SomeService() {
        this.filterManager = new FilterManager<>();
        this.filterManager.addFilter(new PriceFilter());
        this.filterManager.addFilter(new AvailabilityFilter());
    }

    public List<Product> getProducts() {
        List<Product> products = Arrays.asList(
            new Product("Product 1", 10.0, true),
            new Product("Product 2", 20.0, false),
            new Product("Product 3", 15.0, true)
        );

        FilterParams params = new FilterParams(15.0, false);
        return filterManager.applyFilters(products, params);
    }

    public static void main(String[] args) {
        SomeService service = new SomeService();
        List<Product> filteredProducts = service.getProducts();

        for (Product product : filteredProducts) {
            System.out.println(product.getName() + " - Price: " + product.getPrice() + ", In Stock: " + product.isInStock());
        }
    }
}