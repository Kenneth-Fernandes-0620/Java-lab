enum Stage {
    NA,
    PLANNING,
    ORDERING_MATERIALS,
    CONSTRUCTION,
    COMPLETED
}

public abstract class Construction {

    protected Stage constructionPhase = Stage.NA;
    protected String companyName;

    public abstract void plan();

    public abstract void orderMaterials();

    public abstract void startConstruction() throws InterruptedException;

}