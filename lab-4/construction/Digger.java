package construction;

public class Digger extends ConstructionVehicle {

    public Digger(String vehicleName) {
        super.vehicleName = vehicleName;
        super.vehicleType = VehicleType.DIGGER;
    }

    @Override
    public void work() {
        System.out.println(super.vehicleType.name() + " " + super.vehicleName + " has started working");
        super.isWorking = true;
    }

    @Override
    public void maintain() {
        System.out.println(super.vehicleType.name() + " " + super.vehicleName + " has started maintain");
    }

    @Override
    public void stopWorking() {
        System.out.println(super.vehicleType.name() + " " + super.vehicleName + " has stopped Working");
        super.isWorking = false;
    }
}