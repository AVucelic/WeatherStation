import java.util.ArrayList;
import java.util.List;

public enum MeasurementUnit {
    CELSIUS(SensorType.TEMPERATURE, 1, -27315),
    KELVIN(SensorType.TEMPERATURE, 1, 0),
    FAHRENHEIT(SensorType.TEMPERATURE, 1.8, -45967),
    INHG(SensorType.TEMPERATURE, 1, 0),
    MBAR(SensorType.TEMPERATURE, 33.864, 0);

    private final double cf1;
    private final double cf2;
    private final SensorType sensorType;

    public SensorType getSensorType() {
        return sensorType;
    }

    private MeasurementUnit(SensorType sensorType, double conversionFactor1, double conversionFactor2) {
        this.cf1 = conversionFactor1;
        this.cf2 = conversionFactor2;
        this.sensorType = sensorType;
    }

    public double get(int reading) {
        return (reading * cf1 + cf2) / 100.0;
    }

    public static List<MeasurementUnit> valuesOf(SensorType sensorType) {
        List<MeasurementUnit> list = new ArrayList<MeasurementUnit>();
        for (MeasurementUnit unit : MeasurementUnit.values()) {

            if (unit.sensorType == sensorType) {
                list.add(unit);
            }
        }
        return list;
    }
}
