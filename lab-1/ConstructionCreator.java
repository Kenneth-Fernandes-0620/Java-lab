enum ConstructionType {
    BUILDING,
    POOL
}

public class ConstructionCreator {
    public static Construction constructionCreator(ConstructionType type, String companyName, Stage currentStage) {
        if (type == ConstructionType.POOL)
            return new PoolConstruction(companyName,currentStage);
        else return new BuildingConstruction(companyName,currentStage);
    }

    public static Construction constructionCreator(ConstructionType type, String companyName) {
        if (type == ConstructionType.POOL)
            return new PoolConstruction(companyName);
        else return new BuildingConstruction(companyName);
    }

    public static Construction constructionCreator(ConstructionType type) {
        if (type == ConstructionType.POOL)
            return ConstructionCreator.constructionCreator(type, "Generic Pool", Stage.NA);
        else return ConstructionCreator.constructionCreator(type, "Generic Builders", Stage.NA);
    }
}
