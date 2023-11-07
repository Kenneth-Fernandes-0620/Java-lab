public class BuildingConstruction extends Construction {

    public BuildingConstruction(String companyName) {
        super.companyName = companyName;
    }

    public BuildingConstruction(String companyName, Stage currentStage) {
        super.companyName = companyName;
        super.constructionPhase = currentStage;
    }


    @Override
    public void plan() {
        super.constructionPhase = Stage.PLANNING;
        System.out.println("Started Planning Phase for the Building by company " + super.companyName);
    }

    @Override
    public void orderMaterials() {
        super.constructionPhase = Stage.ORDERING_MATERIALS;
        System.out.println("Started Ordering Materials like Bricks, Mortar, etc by company " + super.companyName);
    }

    @Override
    public void startConstruction() throws InterruptedException {
        super.constructionPhase = Stage.CONSTRUCTION;
        System.out.println("Construction has begun by company " + super.companyName);
        // Wait for some time
        Thread.sleep(2000);
        super.constructionPhase = Stage.COMPLETED;
        System.out.println("Construction has Ended");
    }
}
