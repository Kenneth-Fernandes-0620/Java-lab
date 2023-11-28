public class Main {
    public static void main(String[] args) {
        Digger digger = new Digger("Tommy");
        digger.work();
        digger.maintain();
        digger.work();
        digger.stopWorking();
        System.out.println();

        Crane crane = new Crane("James");
        crane.work();
        crane.maintain();
        crane.work();
        crane.stopWorking();
    }
}
