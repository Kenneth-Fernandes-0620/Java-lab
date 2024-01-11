class ConcretePouringTask implements ConstructionTask {
    private double cubicMeters;
    private double costPerCubicMeter;

    public ConcretePouringTask(double cubicMeters, double costPerCubicMeter) {
        this.cubicMeters = cubicMeters;
        this.costPerCubicMeter = costPerCubicMeter;
    }

    @Override
    public double calculateCost() {
        return cubicMeters * costPerCubicMeter;
    }

    @Override
    public String toString() {
        return "ConcretePouringTask [cubicMeters=" + cubicMeters + ", costPerCubicMeter=" + costPerCubicMeter + "]";
    }

}