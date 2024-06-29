public class FilterParams {
    private double minPrice;
    private boolean includeOutOfStock;

    public FilterParams(double minPrice, boolean includeOutOfStock) {
        this.minPrice = minPrice;
        this.includeOutOfStock = includeOutOfStock;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public boolean isIncludeOutOfStock() {
        return includeOutOfStock;
    }
}