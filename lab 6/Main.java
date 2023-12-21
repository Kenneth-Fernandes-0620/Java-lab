public class Main {
    public static void main(String[] args) {
        ConstructionProject<ConstructionItem> project1 = new ConstructionProject<>();
        project1.addItem(new Concrete());
        project1.addItem(new Hammer());
        project1.sortItems(); 
        project1.startConstruction();

        ConstructionProject<ConstructionItem> project2 = new ConstructionProject<>();
        project2.addItem(new Steel());
        project2.addItem(new Saw());
        project2.sortItems(); 
        project2.startConstruction();
    }
}
