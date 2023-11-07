public class PoolConstruction extends Construction {

    public PoolConstruction(String companyName) {
        super.companyName = companyName;
    }

    public PoolConstruction(String companyName, Stage currentStage) {
        super.companyName = companyName;
        super.constructionPhase = currentStage;
    }

    @Override
    public void plan() {
        super.constructionPhase = Stage.PLANNING;
        System.out.println("Started Planning Phase for the Pool by company " + super.companyName);
    }

    @Override
    public void orderMaterials() {
        super.constructionPhase = Stage.ORDERING_MATERIALS;
        System.out.println("Started Ordering Materials like Paint, Cement, etc by company " + super.companyName);
    }

    @Override
    public void startConstruction() throws InterruptedException {
        super.constructionPhase = Stage.CONSTRUCTION;
        System.out.println("Construction has begun by company " + super.companyName);
        // Wait for some time
        Thread.sleep(5000);
        super.constructionPhase = Stage.COMPLETED;
        System.out.println("Construction has Ended");
    }
}
