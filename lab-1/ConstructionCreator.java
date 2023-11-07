enum constructionType {
    BUILDING,
    POOL
}

public class ConstructionCreator {
    public static Construction constructionCreator(constructionType type, String companyName, Stage currentStage) {
        if (type == constructionType.POOL)
            return new PoolConstruction(companyName,currentStage);
        else return new BuildingConstruction(companyName,currentStage);
    }

    public static Construction constructionCreator(constructionType type, String companyName) {
        if (type == constructionType.POOL)
            return new PoolConstruction(companyName);
        else return new BuildingConstruction(companyName);
    }

    public static Construction constructionCreator(constructionType type) {
        if (type == constructionType.POOL)
            return ConstructionCreator.constructionCreator(type, "Generic Pool", Stage.NA);
        else return ConstructionCreator.constructionCreator(type, "Generic Builders", Stage.NA);
    }
}
