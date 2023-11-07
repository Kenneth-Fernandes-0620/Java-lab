public class Main {

    private static int companies;

    public static int getCompanies() {
        return companies;
    }

    public static void setCompanies(int companies) {
        Main.companies = companies;
    }

    public static void addCompanies() {
        Main.companies = Main.companies + 1;
    }

    public static void main(String[] args) {
        //Program start
        Main.setCompanies(0);

        // Creating One Company
        Main.addCompanies();
        Company bigBuildingBuilders = new Company(ConstructionCreator.constructionCreator(constructionType.BUILDING, "Big Builders", Stage.PLANNING));
        bigBuildingBuilders.construction.orderMaterials();
        try {
            bigBuildingBuilders.construction.startConstruction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Creating Another Company
        Main.addCompanies();
        Company poolBuilders = new Company(ConstructionCreator.constructionCreator(constructionType.POOL));
        poolBuilders.construction.plan();
        poolBuilders.construction.orderMaterials();
        try {
            poolBuilders.construction.startConstruction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Main.addCompanies();
        Company poolBuilders2 = new Company(ConstructionCreator.constructionCreator(constructionType.POOL, "Scenic Pool Builders"));
        poolBuilders2.construction.plan();
        poolBuilders2.construction.orderMaterials();
        try {
            poolBuilders2.construction.startConstruction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
