public class ConstructionCompany {

    public static void main(String[] args) {
        Foreman foreman = new Foreman(101, "Kenneth", 1000);
        SiteManager siteManager = new SiteManager(102, "Manager 1", 500);
        foreman.displayDetails();
        siteManager.displayDetails();
    }
}
