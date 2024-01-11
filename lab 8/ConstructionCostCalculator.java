import java.util.*;
import java.util.stream.Stream;

class ConstructionCostCalculator {
    public static void main(String[] args) {
        List<ConstructionTask> site_A = new ArrayList<>();
        List<ConstructionTask> site_B = new LinkedList<>();
        List<ConstructionTask> site_C = new Vector<>();

        site_A.add(new ExcavationTask(10, 20));
        site_A.add(new ConcretePouringTask(5, 50));

        site_B.add(new ExcavationTask(15, 5));
        site_B.add(new ExcavationTask(20, 10));

        site_C.add(new ConcretePouringTask(10, 5));
        site_C.add(new ExcavationTask(20, 10));
        site_C.add(new ConcretePouringTask(15, 15));
        site_C.add(new ConcretePouringTask(10, 10));

        // Printing using Iterator
        Iterator<ConstructionTask> iterator = site_B.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        // Printing using ForEach
        double concretePouringTask = site_C.stream().filter(e -> e instanceof ConcretePouringTask).count();
        System.out.println("Concrete Pouring Tasks at Site C are: " + concretePouringTask);

        // Total Cost
        double totalCost = Stream.concat(Stream.concat(site_A.stream(), site_B.stream()), site_C.stream())
                .mapToDouble(ConstructionTask::calculateCost).sum();

        System.out.println("Total Construction Cost: " + totalCost);
    }
}