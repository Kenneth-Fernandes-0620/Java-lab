import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ConstructionProject {
    private String projectName;
    private double budget;

    public ConstructionProject(String projectName, double budget) {
        this.projectName = projectName;
        this.budget = budget;
    }

    public String getProjectName() {
        return projectName;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return projectName +
                " (budget = " + budget +
                ")";
    }
}

public class Construction {
    public static void main(String[] args) {

        List<ConstructionProject> projects = new ArrayList<>();
        projects.add(new ConstructionProject("Project A", 50000));
        projects.add(new ConstructionProject("Project B", 75000));
        projects.add(new ConstructionProject("Project C", 60000));

        projects.sort(Comparator.comparingDouble(ConstructionProject::getBudget));

        System.out.println("Projects are (Sorted by Cost): ");
        projects.forEach(System.out::println);
    }
}
