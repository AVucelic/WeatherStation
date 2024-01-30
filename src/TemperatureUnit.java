public enum TemperatureUnit {
    CELSIUS(-27315),
    KELVIN(0);

    private final int conversionFactor;

    private TemperatureUnit(int conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double get(double reading) {
        return (reading + conversionFactor) / 100.0;
    }

}
