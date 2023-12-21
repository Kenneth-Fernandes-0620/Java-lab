import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstructionProject<T extends ConstructionItem> {
    private List<T> items;

    public ConstructionProject() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void startConstruction() {
        System.out.println("Starting construction project...");

        for (T item : items) {
            item.use();
        }

        System.out.println("Construction project completed!");
    }

    public void sortItems() {
        Collections.sort(items);
    }
}