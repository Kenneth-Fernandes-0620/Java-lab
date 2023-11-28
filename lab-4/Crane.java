public class Crane extends ConstructionVehicle {

    public Crane(String vehicleName) {
        super.vehicleName = vehicleName;
        super.vehicleType = VehicleType.CRANE;
    }

    @Override
    public void work() {
        System.out.println(super.vehicleType.name() + " " + super.vehicleName + " has started working");
        super.isWorking = true;
    }

    @Override
    public void maintain() {
        stopWorking();
        System.out.println(super.vehicleType.name() + " " + super.vehicleName + " has started maintain");
    }

    @Override
    public void stopWorking() {
        System.out.println(super.vehicleType.name() + " " + super.vehicleName + " has stopped Working");
        super.isWorking = false;
    }

}
