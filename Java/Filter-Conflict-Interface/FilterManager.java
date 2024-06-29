import java.util.ArrayList;
import java.util.List;

public class FilterManager<T> {
    private List<Filter<T>> filters;

    public FilterManager() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(Filter<T> filter) {
        this.filters.add(filter);
    }

    public List<T> applyFilters(List<T> items, FilterParams params) {
        List<T> filteredItems = items;
        for (Filter<T> filter : filters) {
            filteredItems = filter.doFilter(filteredItems, params);
        }
        return filteredItems;
    }
}